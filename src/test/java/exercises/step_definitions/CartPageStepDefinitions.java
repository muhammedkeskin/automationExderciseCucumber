package exercises.step_definitions;

import exercises.steps.CartPageSteps;
import io.cucumber.java.en.*;

import java.io.IOException;

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

    @When("Click RegisterLogin button")
    public void click_register_login_button() {
        clickRegisterLoginButtonOnCartPage();
    }

    @When("Enter description in comment text area and click Place Order")
    public void enter_description_in_comment_text_area_and_click_place_order() {
        addACommentOnCartPage()
                .clickPlaceOrderButtonOnCartpage();
    }

    @When("Enter payment details: Name on Card, Card Number, CVC, Expiration date")
    public void enter_payment_details_name_on_card_card_number_cvc_expiration_date() {
        enterNameOnCard()
                .enterCartNumber()
                .enterCVCNumber()
                .EnterExpirationMonth()
                .EnterExpirationYear();
    }

    @When("Click Pay and Confirm Order button")
    public void click_pay_and_confirm_order_button() {
        clickPayANdConfirmButtonOnCartPage();
    }

    @When("Click Download Invoice button and verify invoice is downloaded successfully.")
    public void click_download_invoice_button_and_verify_invoice_is_downloaded_successfully() throws InterruptedException {
        verifyInvoiceDownloadedSuccessfully();
    }

}
