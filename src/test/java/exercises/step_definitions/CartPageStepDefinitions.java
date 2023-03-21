package exercises.step_definitions;

import exercises.steps.CartPageSteps;
import io.cucumber.java.en.*;

public class CartPageStepDefinitions extends CartPageSteps {

    @When("Add products to cart")
    public void add_products_to_cart() {
        jsScroll();
        addRandomProductToCartOnHomePage();
    }

    @When("Click Cart button")
    public void click_cart_button() throws InterruptedException {
        clickCartButtonOnHomePage();
    }

    @Then("Verify that cart page is displayed")
    public void verify_that_cart_page_is_displayed() {
        verifyCartPageIsDisplayed();
    }

    @When("Click Proceed To Checkout")
    public void click_proceed_to_checkout() {
        clickProceedToCheckoutButtonOnCartPage();
    }

    @Then("Verify that the entered address information is the same")
    public void verify_that_the_entered_address_information_is_the_same() {
        verifyNameOnCheckoutPage()
                .verifyCompanyOnCheckoutPage()
                .verifyAddressOnCheckoutPage()
                .verifyCityStateZipcodeOnCheckoutPage()
                .verifyCountryOnCheckoutPage()
                .verifyMobileNumberOnCheckoutPage();
    }
}
