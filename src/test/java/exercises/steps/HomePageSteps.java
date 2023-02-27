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


public class HomePageSteps extends HomePage {

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

    public HomePageSteps fillFirst() {
        firstNameBox.sendKeys(Faker.instance().name().firstName());
        return this;
    }

    public HomePageSteps fillLastName() {
        lastNameBox.sendKeys(Faker.instance().name().lastName());
        return this;
    }

    public HomePageSteps fillCompany() {
        companyBox.sendKeys(Faker.instance().company().name());
        return this;
    }

    public HomePageSteps fillAddress() {
        addressBox1.sendKeys(Faker.instance().address().fullAddress());
        return this;
    }

    public HomePageSteps fillAddress2() {
        addressBox1.sendKeys("");
        return this;
    }

    public HomePageSteps fillCountry() {
        selectByText(countryDropdown,"United States");
        return this;
    }

    public HomePageSteps fillState() {
        stateBox.sendKeys(Faker.instance().address().state());
        return this;
    }

    public HomePageSteps fillCity() {
        cityBox.sendKeys(Faker.instance().address().city());
        return this;
    }

    public HomePageSteps fillZipCode() {
        zipcodeBox.sendKeys(Faker.instance().address().zipCode());
        return this;
    }

    public HomePageSteps fillMobileNumber() {
        mobileNumberBox.sendKeys(Faker.instance().phoneNumber().phoneNumber());
        return this;
    }

    public void clickCreateAccountButton() {
        createAccountButton.click();
    }

    public void checkingIfAccountIsCreated() {
        Assert.assertTrue(accountCreatedText.isDisplayed());
    }

    public void clickContinueButtonOnRegistrationPage() {
        continueButton.click();
    }

    private void dismissPopupAfterClickingContinueButton() {
        Driver.get().switchTo().frame("aswift_3");
        WebDriverWait wait = new WebDriverWait(Driver.get(),10);
        wait.until(ExpectedConditions.elementToBeClickable(dismissPopupButton));
        dismissPopupButton.click();
    }

    public void verifyingThatLoggedInAsUsernameIsVisible() {
        try {
            if (dismissPopupButton.isDisplayed()) {
                dismissPopupAfterClickingContinueButton();
            }
        } catch (NoSuchElementException e) {
        }
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

}
