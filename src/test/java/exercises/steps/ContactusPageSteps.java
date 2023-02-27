package exercises.steps;

import exercises.pages.ContactUsPage;
import exercises.utils.Driver;
import org.junit.Assert;

public class ContactusPageSteps extends ContactUsPage {

    public void getInTouchIsVisible() {
        Assert.assertTrue(getInTouchText.isDisplayed());
    }

    public ContactusPageSteps enterNameOnContactUsPage() {
        nameInputInContacyUsPage.sendKeys("name1");
        return this;
    }

    public ContactusPageSteps enterEmailOnContactUsPage() {
        emailInputInContacyUsPage.sendKeys("johndoe1000@gmail.com");
        return this;
    }

    public ContactusPageSteps enterSubjectOnContactUsPage() {
        subjectInputInContacyUsPage.sendKeys("example subject");
        return this;

    }

    public ContactusPageSteps enterMessageOnContactUsPage() {
        messageInputInContacyUsPage.sendKeys("example message");
        return this;
    }

    public void uploadFileOnContactUsPage() {
        chooseFileButtonOnContactUsPage.sendKeys("C:\\Users\\MuhammedKeskin\\IdeaProjects\\automationExderciseCucumber\\src\\test\\resources\\test4.xlsx");
    }

    public void clickSubmitButtonOnContactUsPage() {
        submitButtonOnContactUsPage.click();
    }

    public void clickOkButtonOnContactUsPage() {
        Driver.get().switchTo().alert().accept();
    }

    public void verifySuccessMessageOnContactUsPage() {
        String actualMessage=successMessageOnContactUsPage.getText();
        String expectedMessage="Success! Your details have been submitted successfully.";
        Assert.assertEquals(expectedMessage,actualMessage);

        Assert.assertTrue(successMessageOnContactUsPage.isDisplayed());
    }

    public ContactusPageSteps clickHomePageButtonOnContactUsPage() {
        homeButtonOnContactUsPage.click();
        return this;
    }

    public ContactusPageSteps verifyLandedToHomePage() {
        String pageTitle = Driver.get().getTitle();
        Assert.assertEquals("automationexercise", pageTitle);
        return this;
    }
}


/*steps: file upload:
-resources altında altında yeni file oluşturalım: adı file.txt olsun
-içine yazı yazabildiğimiz bir text oluşturmuş olduk
*resources'in yeri önemli java ile aynı seviyede olmalı!
oluşturduğumuz textfile.txt ue sağtık-copy path-absolute path yap
sonra ekrana yapıştır
*/