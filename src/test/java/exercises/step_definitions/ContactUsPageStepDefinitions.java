package exercises.step_definitions;

import exercises.steps.ContactusPageSteps;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class ContactUsPageStepDefinitions extends ContactusPageSteps {

    @Then("Verify GET IN TOUCH is visible")
    public void verify_get_in_touch_is_visible() {
        getInTouchIsVisible();
    }

    @When("Enter name, email, subject and message")
    public void enter_name_email_subject_and_message() {
        enterNameOnContactUsPage()
                .enterEmailOnContactUsPage()
                .enterSubjectOnContactUsPage()
                .enterMessageOnContactUsPage();
    }

    @When("Upload file")
    public void upload_file() {
        uploadFileOnContactUsPage();
    }

    @When("Click Submit button")
    public void click_submit_button() {
        clickSubmitButtonOnContactUsPage();
    }

    @When("Click OK button")
    public void click_ok_button() {
        clickOkButtonOnContactUsPage();
    }

    @When("Verify success message Success! Your details have been submitted successfully is visible")
    public void verify_success_message_success_your_details_have_been_submitted_successfully_is_visible() {
        verifySuccessMessageOnContactUsPage();
    }

    @When("Click Home button and verify that landed to home page successfully")
    public void click_home_button_and_verify_that_landed_to_home_page_successfully() {
        clickHomePageButtonOnContactUsPage()
                .verifyLandedToHomePage();
    }

}
