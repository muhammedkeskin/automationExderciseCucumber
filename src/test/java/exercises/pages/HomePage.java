package exercises.pages;

import exercises.utils.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    public HomePage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(partialLinkText = "Signup")
    public WebElement LoginSignupButton;

    @FindBy(xpath = "//div[@class='signup-form']/h2")
    public WebElement signupText;

    @FindBy(name = "name")
    public WebElement nameBox;

    @FindBy(css = "[data-qa='signup-email']")
    public WebElement emailBoxForRegistering;

    @FindBy(css = "[data-qa='signup-button']")
    public WebElement signUpButton;

    @FindBy(xpath = "//b[contains (text(),'Enter Account Information')]")
    public WebElement createAccountPageVerification;

    @FindBy(id = "id_gender1")
    public WebElement genderMaleCheckBox;

    @FindBy(xpath = "//input[@type='password']")
    public WebElement chooseAPasswordArea;

    @FindBy(id = "days")
    public WebElement dayDropdown;

    @FindBy(id = "months")
    public WebElement monthDropdown;

    @FindBy(id = "years")
    public WebElement yearDropdown;

    @FindBy(xpath = "//*[@id='newsletter']")
    public WebElement newsletterSignupBox;

    @FindBy(id = "optin")
    public WebElement specialOfferBox;


    @FindBy(id = "first_name")
    public WebElement firstNameBox;

    @FindBy(id = "last_name")
    public WebElement lastNameBox;

    @FindBy(id = "company")
    public WebElement companyBox;

    @FindBy(id = "address1")
    public WebElement addressBox1;

    @FindBy(id = "address2")
    public WebElement addressBox2;

    @FindBy(id = "country")
    public WebElement countryDropdown;

    @FindBy(id = "state")
    public WebElement stateBox;

    @FindBy(id = "city")
    public WebElement cityBox;

    @FindBy(id = "zipcode")
    public WebElement zipcodeBox;

    @FindBy(id = "mobile_number")
    public WebElement mobileNumberBox;

    @FindBy(css = "[data-qa='create-account']")
    public WebElement createAccountButton;

    @FindBy(xpath = "//*[text()='Account Created!']")
    public WebElement accountCreatedText;

    @FindBy(xpath = "//*[@class='btn btn-primary']")
    public WebElement continueButton;

    @FindBy(xpath = "//*[text()=' Logged in as ']/b")
    public WebElement loggedInNameText;

    @FindBy(xpath = "//*[text()=' Delete Account']")
    public WebElement deleteButton;

    @FindBy(css = "[aria-label='Close ad']")
    public WebElement dismissPopupButton;

    @FindBy(xpath = "//div[@class='login-form']/h2")
    public WebElement loginToYourAccountText;

    @FindBy(css = "[data-qa='login-email']")
    public WebElement emailArea;

    @FindBy(css = "[data-qa='login-password']")
    public WebElement passwordArea;

    @FindBy(css = "[data-qa='login-button']")
    public WebElement loginButton;

    @FindBy(css = "[data-qa='continue-button']")
    public WebElement continueButtonAfterAccountIsDeleted;

    @FindBy(xpath = "//p[text()='Your email or password is incorrect!']")
    public WebElement IncorrectEmailOrPasswordErrorMessage;

    @FindBy(xpath = "//a[@href='/logout']")
    public WebElement logoutButton;

    @FindBy(partialLinkText = "Contact")
    public WebElement contactUsButton;

}

