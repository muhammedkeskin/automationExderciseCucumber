package exercises.pages;

import exercises.utils.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactUsPage {

    public ContactUsPage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(xpath = "//div[@class='contact-form']/h2")
    public WebElement getInTouchText;

    @FindBy(css = "[data-qa='name']")
    public WebElement nameInputInContacyUsPage;

    @FindBy(css = "[data-qa='email']")
    public WebElement emailInputInContacyUsPage;

    @FindBy(css = "[data-qa='subject']")
    public WebElement subjectInputInContacyUsPage;

    @FindBy(css = "[data-qa='message']")
    public WebElement messageInputInContacyUsPage;

    @FindBy(name = "submit")
    public WebElement submitButtonOnContactUsPage;

    @FindBy(css = "[type='file']")
    public WebElement chooseFileButtonOnContactUsPage;

    @ FindBy(xpath= "//*[text()='Success! Your details have been submitted successfully.']")
    public WebElement successMessageOnContactUsPage;

    @FindBy(xpath = "(//*[text()=' Home'])[2]")
    public WebElement homeButtonOnContactUsPage;
}
