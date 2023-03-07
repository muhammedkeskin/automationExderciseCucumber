package exercises.step_definitions;

import exercises.steps.ProductsPageSteps;
import io.cucumber.java.en.*;

import java.util.List;

public class ProductPageStepDefinitions extends ProductsPageSteps {

    @Then("Verify user is navigated to ALL PRODUCTS page successfully")
    public void verify_user_is_navigated_to_all_products_page_successfully() {
        verifyThatNavigatedToProductsPage();
    }

    @Then("The products list is visible")
    public void the_products_list_is_visible() {
        verifyProductListIsVisibleOnProductPage();
    }

    @When("Click on View Product of {int}. product")
    public void click_on_view_product_of_product(int productNumber) {
        clickOnGivenProduct(productNumber);
    }

    @Then("User is landed to product detail page")
    public void user_is_landed_to_product_detail_page() {
        verifyThatNavigatedToProductDetailPage();
    }

    @Then("Verify that detail following details are visible")
    public void verify_that_detail_following_details_are_visible(List<String> details) {
        verifyDetailsOnProductPage(details);
    }

    @When("Enter product name {string} in search input and click search button")
    public void enter_product_name_in_search_input_and_click_search_button(String productName) {
        enterProductNameOnProductPage(productName)
                .clickSearchButtonOnProductPage();
    }

    @Then("Verify SEARCHED PRODUCTS is visible")
    public void verify_searched_products_is_visible() {
        verifySearchedProductIsVisible();
    }

    @Then("Verify all the products related to searched word {string} are visible")
    public void verify_all_the_products_related_to_searched_word_are_visible(String searchedWord) {
        verifyAllProductsAreRelatedToSearch(searchedWord);
    }

    @When("Scroll down to footer")
    public void scroll_down_to_footer() {
        scrollDownOfThePageByJs();
    }

    @Then("Verify text SUBSCRIPTION")
    public void verify_text_subscription() {
        veifyTextSubscription();
    }

    @When("Enter email address in input and click arrow button")
    public void enter_email_address_in_input_and_click_arrow_button() {
        enterEmailAddressToSubscriptionInput();
    }

    @Then("Verify success message You have been successfully subscribed! is visible")
    public void verify_success_message_you_have_been_successfully_subscribed_is_visible() {
        verifySuccessMessageIsAvailableAboutSubscription();
    }




}
