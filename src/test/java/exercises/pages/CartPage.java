package exercises.pages;

import exercises.utils.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CartPage {

    public CartPage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(xpath = "//a[@class='btn btn-default add-to-cart']")
    public WebElement addFirstProductToCart;

    @FindBy(xpath = "//button[text()='Continue Shopping']")
    public WebElement continueShoppingButton;

    @FindBy(xpath = "//a[@href='/view_cart']")
    public WebElement viewCartButtonProduct;

    @FindBy(xpath = "//*[@class='cart_description']")
    public List<WebElement> productsInCart;

    @FindBy (xpath = "//*[@class='btn btn-default check_out']")
    public WebElement proceedToCheckoutButton;

    @FindBy (css = ".address_firstname.address_lastname")
    public WebElement nameOnCheckoutPage;

    @FindBy (css = ".address_address1.address_address2")
    public WebElement companyOnCheckoutPage;

    @FindBy (xpath = "(//li[@class='address_address1 address_address2'])[2]")
    public WebElement addressOnCheckoutPage;

    @FindBy (css = ".address_city.address_state_name.address_postcode")
    public WebElement cityStateZipcodeOnCheckoutPage;

    @FindBy (css = ".address_country_name")
    public WebElement countryOnCheckoutPage;

    @FindBy (css = ".address_phone")
    public WebElement mobilePhoneNumber;

    @FindBy (xpath = "//p/a[@href = '/login']")
    public WebElement registerLoginButtonOnCartPage;

    @FindBy (css = ".form-control")
    public WebElement commentArea;

    @FindBy (xpath = "//a[text()='Place Order']")
    public WebElement placeOrderButton;

    @FindBy (xpath = "//input[@name='name_on_card']")
    public WebElement nameOnCartArea;

    @FindBy (xpath = "//input[@name='card_number']")
    public WebElement cardNumberArea;

    @FindBy (xpath = "//input[@name='cvc']")
    public WebElement CVCNumberArea;

    @FindBy (xpath = "//input[@name='expiry_month']")
    public WebElement expirationMonthArea;

    @FindBy (xpath = "//input[@name='expiry_year']")
    public WebElement expirationYearArea;

    @FindBy (xpath = "//button[text()='Pay and Confirm Order']")
    public WebElement payAndConfirmButton;

    @FindBy (css = ".btn.btn-default.check_out")
    public WebElement downloadInvoiceButton;






}


