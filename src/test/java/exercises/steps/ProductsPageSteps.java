package exercises.steps;

import exercises.pages.HomePage;
import exercises.pages.ProductsPage;
import exercises.utils.ConfigurationReader;
import exercises.utils.Driver;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ProductsPageSteps extends ProductsPage {

    List<WebElement> productsList;
    int count=0;

    private int lastClickedBrandIndex = -1;
    private Random rd = new Random();


    public void verifyThatNavigatedToProductsPage() {
        HomePage homePage=new HomePage();
        HomePageSteps homePageSteps=new HomePageSteps();

        try {
            if (homePage.dismissPopupButton.isDisplayed()) {
                homePageSteps.dismissPopupAfterClickingContinueButton();
            }
        } catch (NoSuchElementException e) {
        }

        Assert.assertEquals(Driver.get().getTitle(), "Automation Exercise - All Products");
    }

    public void verifyProductListIsVisibleOnProductPage() {
        productsList=Driver.get().findElements(By.xpath("//section//div[@class='col-sm-4']"));
        Assert.assertTrue(productsList.size()==34);
    }

    public void clickOnGivenProduct(int productNumber) {
        Driver.get().findElement(By.xpath("//a[@href='/product_details/"+productNumber+"']"))
                .click();;
    }

    public void verifyThatNavigatedToProductDetailPage() {

        HomePage homePage=new HomePage();
        HomePageSteps homePageSteps=new HomePageSteps();
        try {
            if (homePage.dismissPopupButton.isDisplayed()) {
                homePageSteps.dismissPopupAfterClickingContinueButton();
            }
        } catch (NoSuchElementException e) {
        }

        if(Driver.get().findElement(By.xpath("//*[@id='dismiss-button']")).isDisplayed()) {
            Driver.get().findElement(By.xpath("//*[@id='dismiss-button']")).click();
        }
            Assert.assertEquals("Automation Exercise - Product Details", Driver.get().getTitle());
    }

    public void verifyDetailsOnProductPage(List<String> details) {
        for(int i=0;i<details.size();i++) {
            if (details.get(i).equals("product name")) {
                verifyProductName();
            } else if (details.get(i).equals("category")) {
                verifyCategory();
            } else if (details.get(i).equals("price")) {
                verifyPrice();
            } else if (details.get(i).equals("availability")) {
                verifyAvailability();
            } else if (details.get(i).equals("condition")) {
                verifyCondition();
            }else if (details.get(i).equals("brand")) {
                verifyBrand();
            }
        }
    }
    private void verifyProductName() {
        Assert.assertTrue(ProductName.isDisplayed());
    }

    private void verifyCategory() {
        Assert.assertTrue(Category.isDisplayed());
    }

    private void verifyPrice() {
        Assert.assertTrue(Price.isDisplayed());
    }

    private void verifyAvailability() {
        Assert.assertTrue(Availability.isDisplayed());
    }

    private void verifyCondition() {
        Assert.assertTrue(Condition.isDisplayed());
    }

    private void verifyBrand() {
        Assert.assertTrue(Brand.isDisplayed());
    }

    public ProductsPageSteps enterProductNameOnProductPage(String pName) {
        searchProductInput.sendKeys(pName);
        return this;
    }

    public ProductsPageSteps clickSearchButtonOnProductPage() {
        searchButtonOnProductPage.click();
        return this;
    }

    public void verifySearchedProductIsVisible() {
        Assert.assertTrue(searchedProductsText.isDisplayed());
    }

    public void verifyAllProductsAreRelatedToSearch(String searchedWord) {
        List<WebElement> productsAfterSearch=Driver.get().findElements(By.xpath("//div[@class='col-sm-4']//p"));

        List<String> textOfProducts=new ArrayList<String>();

        for (WebElement element:productsAfterSearch) {
            textOfProducts.add(element.getText());
            Assert.assertTrue(textOfProducts.contains(searchedWord));
        }
    }

   public void scrollDownOfThePageByJs() {
        JavascriptExecutor je = (JavascriptExecutor) Driver.get();
        je.executeScript("window.scrollTo(0,document.body.scrollHeight)");
    }

    /* scroll down to specific element
        JavascriptExecutor je = (JavascriptExecutor) Driver.get();
        WebElement element = Driver.get().findElement(By.id("element-id"));
        je.executeScript("arguments[0].scrollIntoView(true);", element);
    */

    /*scroll down with specific size
    JavascriptExecutor je = (JavascriptExecutor)driver;
    je.executeScript("window.scrollBy(0,500)");
    je.executeScript("window.scrollBy(0,-500)");
    */

    public void veifyTextSubscription() {
        Assert.assertTrue(subciptionText.isDisplayed());
    }

    public void enterEmailAddressToSubscriptionInput() {
        susbscribeEmailInput.sendKeys(ConfigurationReader.get("email"));
        susbscribeArrowButton.click();
    }

    public void verifySuccessMessageIsAvailableAboutSubscription() {
        Assert.assertTrue(susbscribeSuccessMessage.isDisplayed());
    }

    public void clickContinueShoppingButtonOnProductPage() {
        continueShoppingButtonOnProductPage.click();
    }


    //how to create action object?
    //passing driver as a constructor
    public ProductsPageSteps hoverOverFirstProductOnProductPage() {
        Actions actions = new Actions(Driver.get());
        actions.moveToElement(firstProduct).perform();
        return this;
    }

    public ProductsPageSteps clickOnAddToCartButtonOnProductPage() {
        count++;
        addToCartButton.click();
        return this;
    }

    public ProductsPageSteps hoverOverSecondProductOnProductPage() {
        Actions actions = new Actions(Driver.get());
        actions.moveToElement(secondProduct).perform();
        return this;
    }

    public void clickOnCartButtonOnProductPage() {
        viewCartButtonProduct.click();
    }

    public void verifySizeOfProductsInCart() {
        Assert.assertEquals(count, productsInCart.size());
    }

    public void verifyProductsCrittersInCart() {

        //verifying by int value:
        int firstPriceInt = Integer.parseInt(firstPrice.getText().replaceAll("Rs. ", ""));
        int secondPriceInt = Integer.parseInt(secondPrice.getText().replaceAll("Rs. ", ""));

        //verifying by String value:
        String firstTotalPrice = firstTotolPrice.getText().replaceAll("Rs. ", "");
        String secondTotalPrice = secondTotolPrice.getText().replaceAll("Rs. ", "");

        Assert.assertEquals(500, firstPriceInt);
        Assert.assertEquals(400, secondPriceInt);
        Assert.assertEquals("1", firstQuantity.getText());
        Assert.assertEquals("1", secondQuantity.getText());
        Assert.assertEquals("500", firstTotalPrice);
        Assert.assertEquals("400", secondTotalPrice);

    }

    public void verifyBrandsOnProductPage() {
        List <WebElement> brands = Driver.get().findElements(By.xpath("(//div[@class='brands-name']//li)"));
        Assert.assertTrue(brands.size()==8);
    }

    public void clickRandomBrandOnProductPage() {
        List<WebElement> brands = Driver.get().findElements(By.xpath("//div[@class='brands-name']//li"));
        int i = brands.size();

        int newBrandIndex  = rd.nextInt(i);
        while (newBrandIndex == lastClickedBrandIndex) {
            newBrandIndex = rd.nextInt(i);
        }

        lastClickedBrandIndex = newBrandIndex;
        brands.get(newBrandIndex).click();
    }

    public void verifyNavigatedToBrandPage() {
        Assert.assertTrue(productText.isDisplayed());
    }

}