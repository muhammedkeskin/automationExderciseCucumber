package exercises.steps;

import exercises.pages.CartPage;
import exercises.utils.ConfigurationReader;
import exercises.utils.Driver;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.File;
import org.openqa.selenium.chrome.ChromeOptions;


public class CartPageSteps extends CartPage {

    HomePageSteps homePageSteps = new HomePageSteps();


    public void addRandomProductToCartOnHomePage() {
        addFirstProductToCart.click();

        WebDriverWait wait = new WebDriverWait(Driver.get(),10);
        wait.until(ExpectedConditions.elementToBeClickable(continueShoppingButton));
        continueShoppingButton.click();
    }

    public static void jsScroll() {
        JavascriptExecutor je = (JavascriptExecutor) Driver.get();
        je.executeScript("window.scrollBy(0,500)");
    }

    public void clickCartButtonOnHomePage() throws InterruptedException {
        Thread.sleep(3000);
        viewCartButtonProduct.click();
    }

    public void verifyCartPageIsDisplayed() {
        Assert.assertTrue(productsInCart.size()>0);
    }

    public void clickProceedToCheckoutButtonOnCartPage() {
        proceedToCheckoutButton.click();
    }

    public CartPageSteps verifyNameOnCheckoutPage() {
        String gender = homePageSteps.gender;
        String expectedName=gender+". "+homePageSteps.firstName+" "+homePageSteps.lastName;
        String actualName= nameOnCheckoutPage.getText();
        Assert.assertEquals(expectedName,actualName);
        return this;
    }

    public CartPageSteps verifyCompanyOnCheckoutPage() {
        String expectedCompany=homePageSteps.company;
                String actualCompany=companyOnCheckoutPage.getText();
                Assert.assertEquals(expectedCompany,actualCompany);
        return this;
    }

    public CartPageSteps verifyAddressOnCheckoutPage() {
        String expectedAddress=homePageSteps.address;
        String actualAddress=addressOnCheckoutPage.getText();
        Assert.assertEquals(expectedAddress,actualAddress);
        return this;
    }

    public CartPageSteps verifyCityStateZipcodeOnCheckoutPage() {
        String expectedAddress=homePageSteps.city+" "+homePageSteps.state+" "+homePageSteps.zipCode;
        String actualAddress=cityStateZipcodeOnCheckoutPage.getText();
        Assert.assertEquals(expectedAddress,actualAddress);
        return this;
    }

    public CartPageSteps verifyCountryOnCheckoutPage() {
        String expectedCountry=homePageSteps.country;
        String actualCountry=countryOnCheckoutPage.getText();
        Assert.assertEquals(expectedCountry,actualCountry);
        return this;
    }

    public CartPageSteps verifyMobileNumberOnCheckoutPage() {
        String expectedMobileNumber=homePageSteps.mobileNumber;
        String actualMobileNumber=mobilePhoneNumber.getText();
        Assert.assertEquals(expectedMobileNumber,actualMobileNumber);
        return this;
    }

    public void clickRegisterLoginButtonOnCartPage() {
        registerLoginButtonOnCartPage.click();
    }

    public CartPageSteps addACommentOnCartPage() {
        commentArea.sendKeys(ConfigurationReader.get("comment"));
        return this;
    }

    public CartPageSteps clickPlaceOrderButtonOnCartpage() {
        placeOrderButton.click();
        return this;
    }

    public CartPageSteps enterNameOnCard() {
        nameOnCartArea.sendKeys(ConfigurationReader.get("nameOnCart"));
        return this;
    }

    public CartPageSteps enterCartNumber() {
        cardNumberArea.sendKeys(ConfigurationReader.get("cartNumber"));
        return this;
    }

    public CartPageSteps enterCVCNumber() {
        CVCNumberArea.sendKeys(ConfigurationReader.get("CVCNumber"));
        return this;
    }

    public CartPageSteps EnterExpirationMonth() {
        expirationMonthArea.sendKeys(ConfigurationReader.get("expirationMonth"));
        return this;
    }

    public CartPageSteps EnterExpirationYear() {
        expirationYearArea.sendKeys(ConfigurationReader.get("expirationYear"));
        return this;
    }

    public void clickPayANdConfirmButtonOnCartPage() {
        payAndConfirmButton.click();
    }

    public CartPageSteps clickDownloadInvoiceButtonOnCartPage() {
        downloadInvoiceButton.click();
        return this;
    }

    public CartPageSteps verifyInvoiceDownloadedSuccessfully() throws InterruptedException {

        // Chrome'un varsayılan indirme dizinini seçilir:
        ChromeOptions options = new ChromeOptions();
        String downloadPath = "C:\\Users\\MuhammedKeskin\\Downloads";
        options.addArguments("download.default_directory", downloadPath);

        clickDownloadInvoiceButtonOnCartPage();

        // İndirme işleminin tamamlanması beklenir:
        Thread.sleep(10000);

        // İndirilen dosyanın var olup olmadığı kontrolü:
        File downloadedFile = new File(downloadPath + "/invoice.txt");

        Assert.assertTrue(downloadedFile.exists());

        return this;
    }

}
