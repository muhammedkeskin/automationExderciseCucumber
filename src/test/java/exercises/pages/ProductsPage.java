package exercises.pages;

import exercises.utils.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductsPage {

    public ProductsPage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(xpath = "//h2[contains(text(),'Blue Top')]")
    public WebElement ProductName;

    @FindBy(xpath = "//p[contains(text(),'Category')]")
    public WebElement Category;

    @FindBy(xpath = "//span[contains(text(),'Rs. 500')]")
    public WebElement Price;

    @FindBy(xpath = "//b[contains(text(),'Availability:')]")
    public WebElement Availability;

    @FindBy(xpath = "//b[contains(text(),'Condition')]")
    public WebElement Condition;

    @FindBy (xpath = "//b[contains(text(),'Brand')]")
    public WebElement Brand;

    @FindBy(xpath="//input[@id='search_product']")
    public WebElement searchProductInput;

    @FindBy(xpath = "//i[@class= 'fa fa-search']")
    public WebElement searchButtonOnProductPage;

    @FindBy(xpath="//h2[@class='title text-center']")
    public WebElement searchedProductsText;

    @FindBy(xpath = "//*[contains(text(),'Subscription')]")
    public WebElement subciptionText;

    @FindBy( id = "susbscribe_email")
    public WebElement susbscribeEmailInput;

    @FindBy( id = "subscribe")
    public WebElement susbscribeArrowButton;

    @FindBy( id =  "success-subscribe")
    public WebElement susbscribeSuccessMessage;
}
