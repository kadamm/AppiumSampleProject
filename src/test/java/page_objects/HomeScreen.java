package page_objects;

import helpers.MobileHelper;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class HomeScreen {

    private AppiumDriver driver;
    private MobileHelper mobileHelper;
    public HomeScreen(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(this.driver, Duration.ofSeconds(10)), this);
        this.mobileHelper = new MobileHelper(this.driver, 10);
    }

    @AndroidFindBy(xpath = "//*[@text='Sauce Labs Backpack']")
    @iOSXCUITFindBy(xpath = "//*[@label='Sauce Labs Backpack']")
    private WebElement backPackProduct;

    @AndroidFindBy(accessibility = "open menu")
    @iOSXCUITFindBy(xpath = "//*[@label='Sauce Labs Backpack']")
    private WebElement openMenu;

    @AndroidFindBy(accessibility = "menu item log out")
    @iOSXCUITFindBy(xpath = "//*[@label='Sauce Labs Backpack']")
    private WebElement logoutButton;

    @AndroidFindBy(xpath = "//*[@resource-id='android:id/button1']")
    @iOSXCUITFindBy(xpath = "//*[@label='Sauce Labs Backpack']")
    private WebElement logoutConfirmationButton;

    @AndroidFindBy(xpath = "//*[@resource-id='android:id/button1']")
    @iOSXCUITFindBy(xpath = "//*[@label='Sauce Labs Backpack']")
    private WebElement dismissSuccessAlertButton;

    @AndroidFindBy(accessibility = "Add To Cart button")
    @iOSXCUITFindBy(xpath = "//*[@label='Sauce Labs Backpack']")
    private WebElement addToCartButton;

    @AndroidFindBy(accessibility = "cart badge")
    @iOSXCUITFindBy(xpath = "//*[@label='Sauce Labs Backpack']")
    private WebElement cartButton;

    @AndroidFindBy(accessibility = "Proceed To Checkout button")
    @iOSXCUITFindBy(xpath = "//*[@label='Sauce Labs Backpack']")
    private WebElement proceedToCheckOutButton;

    @AndroidFindBy(accessibility = "product label")
    @iOSXCUITFindBy(xpath = "//*[@label='Sauce Labs Backpack']")
    private WebElement myCartProductName;

    @AndroidFindBy(accessibility = "menu item catalog")
    @iOSXCUITFindBy(xpath = "//*[@label='Sauce Labs Backpack']")
    private WebElement catalog;

    public void tapOnProduct(String productName) {
        this.backPackProduct.click();
    }
    public void tapOnAddToCartButton() {
        this.addToCartButton.click();
    }
    public void tapOnCartButton() {
        this.cartButton.click();
    }

    public String getMyCartProductName() {
        return this.myCartProductName.getText();
    }

    public void tapOnCatalogButton() {
        this.catalog.click();
    }

    public void navigateToProductScreen() {
        this.mobileHelper.waitForElementToVisible(this.openMenu);
        this.openMenu.click();
        this.mobileHelper.waitForElementToVisible(this.catalog);
        this.catalog.click();
    }

    public void logoutFromTheApp() {
        this.openMenu.click();
        this.logoutButton.click();
        this.logoutConfirmationButton.click();
        this.dismissSuccessAlertButton.click();
    }

    public void tapOnProceedToCheckoutButton(){
        this.proceedToCheckOutButton.click();
    }

}
