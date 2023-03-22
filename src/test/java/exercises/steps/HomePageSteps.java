package exercises.steps;

import com.github.javafaker.Faker;
import exercises.pages.HomePage;
import exercises.utils.ConfigurationReader;
import exercises.utils.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class HomePageSteps extends HomePage {

    public static String firstName="";
    public static String lastName="";
    public static String company="";
    public static String address="";
    public static String country="";
    public static String state="";
    public static String city="";
    public static String zipCode="";
    public static String mobileNumber="";
    public static String gender;

    public void virfyTheHomePageLoadedSuccessfully() {
        Assert.assertEquals("Automation Exercise",Driver.get().getTitle());
        //Assert.assertEquals("https://automationexercise.com/", Driver.get().getCurrentUrl());
        //Assert.assertTrue(Driver.get().getCurrentUrl().contains("https://automationexercise"));
    }

    public void clickLoginSignUpButton() {
        LoginSignupButton.click();
    }

    public void signUpTextIsVisible() {
        Assert.assertTrue(signupText.isDisplayed());
    }

    public HomePageSteps enterNameOnRegistrationPage() {
        nameBox.sendKeys("name1");
        return this;
    }

    public HomePageSteps enterEmailOnRegistrationPage() {
        emailBoxForRegistering.sendKeys(Faker.instance().internet().emailAddress());
        return this;
    }

    public void clickSignUpButton() {
        signUpButton.click();
    }

    public void checkEnterInfosText() {
        Assert.assertTrue(createAccountPageVerification.isDisplayed());
    }

    public HomePageSteps selectGender() {
        if (!genderMaleCheckBox.isSelected()) {
            genderMaleCheckBox.click();
            gender = genderMaleCheckBox.getAttribute("value");
        }
        return this;
    }

    public HomePageSteps fillPassword() {
        String password = ConfigurationReader.get("password");
        chooseAPasswordArea.sendKeys(password);
        return this;
    }

    private static void selectByText(WebElement element, String text) {
        Select objSelect = new Select(element);
        objSelect.selectByVisibleText(text);
    }

    public HomePageSteps selectBirthDay() {
        selectByText(dayDropdown, "1");
        return this;
    }

    public HomePageSteps selectBirthMonth() {
        selectByText(monthDropdown, "January");
        return this;
    }

    public HomePageSteps selectBirthYear() {
        selectByText(yearDropdown, "1988");
        return this;
    }

    public void selectNewsLetterCheckbox() {
        if (!newsletterSignupBox.isSelected()){
            newsletterSignupBox.click();
        }
    }

    public void selectReceiveSpecialOffers() {
        if (!specialOfferBox.isSelected()) {
            specialOfferBox.click();
        }
    }

    public HomePageSteps fillFirstName() {
        firstName=Faker.instance().name().firstName();
        firstNameBox.sendKeys(firstName);
        return this;
    }

    public HomePageSteps fillLastName() {
        lastName=Faker.instance().name().lastName();
        lastNameBox.sendKeys(lastName);
        return this;
    }

    public HomePageSteps fillCompany() {
        company=Faker.instance().company().name();
        companyBox.sendKeys(company);
        return this;
    }

    public HomePageSteps fillAddress() {
        address=Faker.instance().address().fullAddress();
        addressBox1.sendKeys(address);
        return this;
    }

    public HomePageSteps fillAddress2() {
        addressBox1.sendKeys("");
        return this;
    }

    public HomePageSteps fillCountry() {
        country="United States";
        selectByText(countryDropdown,country);
        return this;
    }

    public HomePageSteps fillState() {
        state=Faker.instance().address().state();
        stateBox.sendKeys(state);
        return this;
    }

    public HomePageSteps fillCity() {
        city=Faker.instance().address().city();
        cityBox.sendKeys(city);
        return this;
    }

    public HomePageSteps fillZipCode() {
        zipCode=Faker.instance().address().zipCode();
        zipcodeBox.sendKeys(zipCode);
        return this;
    }

    public HomePageSteps fillMobileNumber() {
        mobileNumber=Faker.instance().phoneNumber().phoneNumber();
        mobileNumberBox.sendKeys(mobileNumber);
        return this;
    }

    public void clickCreateAccountButton() {
        createAccountButton.click();
    }

    public void checkingIfAccountIsCreated() {
        Assert.assertTrue(accountCreatedText.isDisplayed());
    }

    public void clickContinueButtonOnRegistrationPage() {
        WebDriverWait wait = new WebDriverWait(Driver.get(),10);
        wait.until(ExpectedConditions.elementToBeClickable(continueButton));
        continueButton.click();
    }

    //POPUP HANDLE İLK HALİ:
    public void verifyThatNavigatedToProductsPage() {
        try {
            if (dismissPopupButton.isDisplayed()) {
                dismissPopupButton.click();
            }
        } catch (NoSuchElementException e) {
        }

        Assert.assertEquals(Driver.get().getTitle(), "Automation Exercise - All Products");
    }
/*
    public void handlePopup() {
        try {
            WebElement outherFrame=Driver.get().findElement(By.id("aswift_3"));
            Driver.get().switchTo().frame(outherFrame);

            WebElement innerFrame=Driver.get().findElement(By.id("ad_iframe"));
            Driver.get().switchTo().frame(innerFrame);
            WebElement popup = Driver.get().findElement(By.cssSelector("[aria-label='Close ad']"));
            if (popup.isDisplayed()) {
                popup.click();
            }

            Driver.get().switchTo().defaultContent();
            Driver.get().switchTo().defaultContent();

        } catch (NoSuchElementException e) {
        }
        Assert.assertEquals(Driver.get().getTitle(), "Automation Exercise - All Products");
    }

*/

    public void handlePopup() {

        try {
            List<WebElement> iframes=Driver.get().findElements(By.xpath("//ins//iframe[contains(@id,'aswift')]"));
            int size=iframes.size();
            WebDriverWait wait = new WebDriverWait(Driver.get(),10);

            WebElement outerIframe = Driver.get().findElement(By.xpath("(//ins//iframe[contains(@id,'aswift')])["+size+"]"));
            Driver.get().switchTo().frame(outerIframe);

            WebElement innerIframe =  Driver.get().findElement(By.id("ad_iframe"));
            Driver.get().switchTo().frame(innerIframe);

            WebElement popup = Driver.get().findElement(By.cssSelector("[aria-label='Close ad']"));
            wait.until(ExpectedConditions.elementToBeClickable(popup));

            if (popup.isDisplayed()) {
                WebElement closeButton = Driver.get().findElement(By.cssSelector("[aria-label='Close ad']"));
                closeButton.click();
            }

        } catch (NoSuchElementException e) {
        }
        Driver.get().switchTo().defaultContent();
        Driver.get().switchTo().defaultContent();


        try {
            List<WebElement> iframes=Driver.get().findElements(By.xpath("//ins//iframe[contains(@id,'aswift')]"));
            int size=iframes.size();
            WebDriverWait wait = new WebDriverWait(Driver.get(),10);

            WebElement outerIframe = Driver.get().findElement(By.xpath("(//ins//iframe[contains(@id,'aswift')])["+size+"]"));
            Driver.get().switchTo().frame(outerIframe);

            WebElement popup = Driver.get().findElement(By.cssSelector("[aria-label='Close ad']"));
            wait.until(ExpectedConditions.elementToBeClickable(popup));

            if (popup.isDisplayed()) {
                WebElement closeButton = Driver.get().findElement(By.cssSelector("[aria-label='Close ad']"));
                closeButton.click();
            }
            Driver.get().switchTo().defaultContent();
        } catch (NoSuchElementException e) {
        }
        Driver.get().switchTo().defaultContent();
    }

    public void dismissPopupAfterClickingContinueButton() {
        Driver.get().switchTo().frame("aswift_3");
        WebDriverWait wait = new WebDriverWait(Driver.get(),10);
        wait.until(ExpectedConditions.elementToBeClickable(dismissPopupButton));
        dismissPopupButton.click();
    }

    public void verifyingThatLoggedInAsUsernameIsVisible() {
        WebDriverWait wait = new WebDriverWait(Driver.get(),10);
        wait.until(ExpectedConditions.elementToBeClickable(loggedInNameText));
        Assert.assertEquals(loggedInNameText.getText(),"name1");
    }

    public void deleteAccount() {
        deleteButton.click();
    }

    public void verifyingIfAccountIsDeleted() {
        String pageUrl = Driver.get().getCurrentUrl();
        Assert.assertTrue(pageUrl.contains("delete_account"));
    }

    public void loginToYourAccountTextIsVisible() {
        Assert.assertTrue(loginToYourAccountText.isDisplayed());
    }

    public void login(String email, String password) {
        emailArea.sendKeys(email);
        passwordArea.sendKeys(password);
    }

    public void clickLoginButton() {
        loginButton.click();
    }

    public void clickContinueButtonAfterAccountIsDeleted() {
        continueButtonAfterAccountIsDeleted.click();
    }

    public HomePageSteps enterIncorrectEmail() {
        emailArea.sendKeys(ConfigurationReader.get("incorrectEmail"));
        return this;
    }

    public HomePageSteps enterPassword() {
        passwordArea.sendKeys(ConfigurationReader.get("password"));
        return this;
    }

    private String getTextOfWebElement(WebElement webElement) {
        String textOfWebElements=webElement.getText();
        return textOfWebElements;
    }

    public void verifyErrorThatIsVisible(String errorMessage) {
        WebElement ele = Driver.get().findElement(By.xpath("//*[text()='"+errorMessage+"']"));
        Assert.assertEquals(errorMessage,getTextOfWebElement(ele));
    }

    public void clickLogoutButton() {
        logoutButton.click();
    }

    public void verifyThatNavigatedToLoginPage() {
        Assert.assertEquals(Driver.get().getTitle(),"Automation Exercise - Signup / Login");
    }

    public HomePageSteps enterexistingEmailOnRegistrationPage() {
        String email=ConfigurationReader.get("email");
        emailBoxForRegistering.sendKeys(email);
        return this;
    }

    public void clickContactUsButton() {
        contactUsButton.click();
    }

    public void clickOnProductsButton() throws InterruptedException {
        productsButton.click();

        Thread.sleep(10000);
        try {
            dismissButtonOnPopop.click();
        } catch (Exception e) {

        }
    }
}
