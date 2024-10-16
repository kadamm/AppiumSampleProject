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
    @iOSXCUITFindBy(xpath = "//*[@name='Sauce Labs Backpack']")
    private WebElement backPackProduct;

    @AndroidFindBy(accessibility = "open menu")
    @iOSXCUITFindBy(id = "tab bar option menu")
    private WebElement openMenu;

    @AndroidFindBy(accessibility = "menu item log out")
    @iOSXCUITFindBy(id = "menu item log out")
    private WebElement logoutButton;

    @AndroidFindBy(xpath = "//*[@resource-id='android:id/button1']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Log Out']")
    private WebElement logoutConfirmationButton;

    @AndroidFindBy(xpath = "//*[@resource-id='android:id/button1']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='OK']")
    private WebElement dismissSuccessAlertButton;

    @AndroidFindBy(accessibility = "Add To Cart button")
    @iOSXCUITFindBy(id = "Add To Cart button")
    private WebElement addToCartButton;

    @AndroidFindBy(accessibility = "cart badge")
    @iOSXCUITFindBy(accessibility = "tab bar option cart")
    private WebElement cartButton;

    @AndroidFindBy(accessibility = "Proceed To Checkout button")
    @iOSXCUITFindBy(id = "Proceed To Checkout button")
    private WebElement proceedToCheckOutButton;

    @AndroidFindBy(accessibility = "product label")
    @iOSXCUITFindBy(id = "product label")
    private WebElement myCartProductName;

    @AndroidFindBy(accessibility = "menu item catalog")
    @iOSXCUITFindBy(id = "tab bar option catalog")
    private WebElement catalog;

    public void tapOnProduct(String productName) {
        this.backPackProduct.click();
    }
    public void tapOnAddToCartButton() {
        this.addToCartButton.click();
    }
    public void tapOnCartButton() {
        this.cartButton.click();
        if (this.driver.getCapabilities().getPlatformName().toString().equalsIgnoreCase("iOS")) {
            this.cartButton.click();
        }
    }

    public String getMyCartProductName() {
        return this.myCartProductName.getText();
    }

    public void tapOnCatalogButton() {
        this.catalog.click();
    }

    public void navigateToProductScreen() {
        if (this.driver.getCapabilities().getPlatformName().toString().equalsIgnoreCase("Android")) {
            this.mobileHelper.waitForElementToVisible(this.openMenu);
            this.openMenu.click();
        }
        this.mobileHelper.waitForElementToVisible(this.catalog);
        this.catalog.click();
    }

    public void logoutFromTheApp() {
        this.openMenu.click();
        this.logoutButton.click();
        this.mobileHelper.waitForElementToVisible(this.logoutConfirmationButton);
        this.logoutConfirmationButton.click();
        this.mobileHelper.waitForElementToVisible(this.dismissSuccessAlertButton);
        this.dismissSuccessAlertButton.click();
    }

    public void tapOnProceedToCheckoutButton(){
        this.proceedToCheckOutButton.click();
    }

}
