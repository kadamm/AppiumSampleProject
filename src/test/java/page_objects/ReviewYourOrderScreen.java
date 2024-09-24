package page_objects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class ReviewYourOrderScreen {

    private AppiumDriver driver;
    public ReviewYourOrderScreen(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(this.driver), this);
    }

    @AndroidFindBy(accessibility = "product label")
    @iOSXCUITFindBy(id = "TBU")
    private WebElement productName;

    @AndroidFindBy(accessibility = "product price")
    @iOSXCUITFindBy(id = "TBU")
    private WebElement productPrice;

    @AndroidFindBy(xpath = "//*[@content-desc='checkout delivery address']/child::android.widget.TextView[3]")
    @iOSXCUITFindBy(id = "TBU")
    private WebElement addressLine1;
    @AndroidFindBy(xpath = "//*[@content-desc='checkout delivery address']/child::android.widget.TextView[4]")
    @iOSXCUITFindBy(id = "TBU")
    private WebElement addressLine2;

    @AndroidFindBy(xpath = "//*[@content-desc='checkout delivery address']/child::android.widget.TextView[4]")
    @iOSXCUITFindBy(id = "TBU")
    private WebElement city;

    @AndroidFindBy(xpath = "//*[@content-desc='checkout delivery address']/child::android.widget.TextView[5]")
    @iOSXCUITFindBy(id = "TBU")
    private WebElement stateAndZipCode;

    @AndroidFindBy(xpath = "//*[@content-desc='checkout payment info']/child::android.widget.TextView[2]")
    @iOSXCUITFindBy(id = "TBU")
    private WebElement paymentFullName;

    @AndroidFindBy(xpath = "//*[@content-desc='checkout payment info']/child::android.widget.TextView[3]")
    @iOSXCUITFindBy(id = "TBU")
    private WebElement paymentCardNumber;

    @AndroidFindBy(xpath = "//*[@content-desc='checkout payment info']/child::android.widget.TextView[4]")
    @iOSXCUITFindBy(id = "TBU")
    private WebElement expiryDate;

    @AndroidFindBy(accessibility = "Place Order button")
    @iOSXCUITFindBy(id = "TBU")
    private WebElement placeOrderButton;


    public String getProductName() {
        return this.productName.getText();
    }

    public String getAddressLine1() {
        return this.addressLine1.getText();
    }

    public String getAddressLine2() {
        return this.addressLine2.getText();
    }

    public String getCity() {
        return this.city.getText();
    }

    public String getFullName() {
        return this.paymentFullName.getText();
    }

    public String getCardNumber() {
        return this.paymentCardNumber.getText();
    }

    public void proceedToCheckoutButton() {
        this.placeOrderButton.click();
    }

}
