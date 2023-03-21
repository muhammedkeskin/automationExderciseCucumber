package exercises.steps;

import exercises.pages.CartPage;
import exercises.pages.HomePage;
import exercises.utils.Driver;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;


public class CartPageSteps extends CartPage {

    HomePageSteps homePageSteps = new HomePageSteps();


    public void addRandomProductToCartOnHomePage() {
        addFirstProductToCart.click();
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
}
