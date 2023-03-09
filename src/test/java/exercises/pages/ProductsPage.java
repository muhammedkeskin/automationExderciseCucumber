package exercises.pages;

import exercises.utils.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

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

    @FindBy(xpath = "//*[@class='btn btn-success close-modal btn-block']")
    public WebElement continueShoppingButtonOnProductPage;

    @FindBy(xpath = " (//div[@class='productinfo text-center'])[1]")
    public WebElement firstProduct;

    @FindBy(xpath = "(//*[@class='btn btn-default add-to-cart'])[2]")
    public WebElement addToCartButton;

    @FindBy(xpath = " (//div[@class='productinfo text-center'])[2]")
    public WebElement secondProduct;

    @FindBy(linkText = "View Cart")
    public WebElement viewCartButtonProduct;

    @FindBy(xpath = "//*[@class='cart_description']")
    public List<WebElement> productsInCart;

    @FindBy(xpath = "(//*[@class='cart_price'])[1]")
    public WebElement firstPrice;

    @FindBy(xpath = "(//*[@class='cart_price'])[2]")
    public WebElement secondPrice;

    @FindBy(xpath = "(//*[@class='cart_total_price'])[1]")
    public WebElement firstTotolPrice;

    @FindBy(xpath = "(//*[@class='cart_total_price'])[2]")
    public WebElement secondTotolPrice;

    @FindBy(xpath = "(//*[@class='disabled'])[1]")
    public WebElement firstQuantity;

    @FindBy(xpath = "(//*[@class='disabled'])[2]")
    public WebElement secondQuantity;

    @FindBy(xpath = "//h2[@class='title text-center']")
    public WebElement productText;
}
