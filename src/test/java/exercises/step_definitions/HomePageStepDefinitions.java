package exercises.step_definitions;

import exercises.steps.HomePageSteps;
import exercises.utils.ConfigurationReader;
import exercises.utils.Driver;
import io.cucumber.java.en.*;

import java.util.Map;

public class HomePageStepDefinitions extends HomePageSteps {

    @Given("Launch browser")
    public void launch_browser() {
        Driver.get();
    }

    @Given("Navigate to Home Page")
    public void navigate_to_home_page() {
        String url= ConfigurationReader.get("url");
        Driver.get().get(url);
    }

    @When("Verify that home page is visible successfully")
    public void verify_that_home_page_is_visible_successfully() {
        virfyTheHomePageLoadedSuccessfully();
    }

    @When("Click on Signup-Login button")
    public void click_on_signup_login_button() {
        clickLoginSignUpButton();
    }

    @When("Verify New User Signup! is visible")
    public void verify_new_user_signup_is_visible() {
        signUpTextIsVisible();
    }

    @When("Enter name and email address")
    public void enter_name_and_email_address() {
        enterNameOnRegistrationPage()
                .enterEmailOnRegistrationPage();
    }
    @When("Click Signup button")
    public void click_signup_button() {
        clickSignUpButton();
    }

    @When("Verify that ENTER ACCOUNT INFORMATION is visible")
    public void verify_that_enter_account_information_is_visible() {
        checkEnterInfosText();
    }

    @When("Fill details: Title, Name, Email, Password, Date of birth")
    public void fill_details_title_name_email_password_date_of_birth() {
        selectGender()
                .fillPassword()
                .selectBirthDay()
                .selectBirthMonth()
                .selectBirthYear();
    }

    @When("Select checkbox Sign up for our newsletter")
    public void select_checkbox_sign_up_for_our_newsletter() {
        selectNewsLetterCheckbox();
    }

    @When("Select checkbox Receive special offers from our partners!")
    public void select_checkbox_receive_special_offers_from_our_partners() {
        selectReceiveSpecialOffers();
    }

    @When("Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number")
    public void fill_details_first_name_last_name_company_address_address2_country_state_city_zipcode_mobile_number() {
        fillFirstName()
                .fillLastName()
                .fillCompany()
                .fillAddress()
                .fillAddress2()
                .fillCountry()
                .fillState()
                .fillCity()
                .fillZipCode()
                .fillMobileNumber();
    }

    @When("Click Create Account button")
    public void click_create_account_button() {
        clickCreateAccountButton();
    }

    @When("Verify that ACCOUNT CREATED! is visible")
    public void verify_that_account_created_is_visible() {
        checkingIfAccountIsCreated();
    }

    @When("Click Continue button")
    public void click_continue_button() {
        clickContinueButtonOnRegistrationPage();
    }

    @When("Verify that Logged in as username is visible")
    public void verify_that_logged_in_as_username_is_visible() {
        handlePopup();
        verifyingThatLoggedInAsUsernameIsVisible();
    }

    @When("Click Delete Account button")
    public void click_delete_account_button() {
        deleteAccount();
    }

    @When("Verify that ACCOUNT DELETED! is visible and click Continue button")
    public void verify_that_account_deleted_is_visible_and_click_continue_button() {
        verifyingIfAccountIsDeleted();
        clickContinueButtonAfterAccountIsDeleted();
    }

    @Then("Verify Login to your account is visible")
    public void verify_login_to_your_account_is_visible() {
        loginToYourAccountTextIsVisible();
    }

    @When("Enter correct email address and password")
    public void enter_correct_email_address_and_password(Map<String, String> userInfo) {
        login(userInfo.get("email"), userInfo.get("password"));
    }

    @When("Click login button")
    public void click_login_button() {
        clickLoginButton();
    }

    @Then("Verify that ACCOUNT DELETED! is visible")
    public void verify_that_account_deleted_is_visible() {
        verifyingIfAccountIsDeleted();
    }

    @When("Enter incorrect email address and password")
    public void enter_incorrect_email_address_and_password() {
        enterIncorrectEmail()
                .enterPassword();
    }

    @Then("Verify error that {string} is visible")
    public void verify_error_that_is_visible(String errorMessage) {
        verifyErrorThatIsVisible(errorMessage);
    }

    @When("Click Logout button")
    public void click_logout_button() {
        clickLogoutButton();
    }

    @Then("Verify that user is navigated to login page")
    public void verify_that_user_is_navigated_to_login_page() {
        verifyThatNavigatedToLoginPage();
    }

    @When("Enter name and already registered email address")
    public void enter_name_and_already_registered_email_address() {
        enterNameOnRegistrationPage()
                .enterexistingEmailOnRegistrationPage();
    }

    @When("Click on Contact Us button")
    public void click_on_contact_us_button() {
        clickContactUsButton();
    }

    @When("Click on Products button")
    public void click_on_products_button() throws InterruptedException {
        clickOnProductsButton();
    }

}
