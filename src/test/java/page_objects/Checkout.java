package page_objects;

import helpers.MobileHelper;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class Checkout {

    private AppiumDriver driver;
    private MobileHelper mobileHelper;
    public Checkout(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(this.driver, Duration.ofSeconds(10)), this);
        this.mobileHelper = new MobileHelper(this.driver, 10);
    }

    @AndroidFindBy(accessibility = "Full Name* input field")
    @iOSXCUITFindBy(id = "Full Name* input field")
    private WebElement fullNameInputField;

    @AndroidFindBy(accessibility = "Address Line 1* input field")
    @iOSXCUITFindBy(id = "Address Line 1* input field")
    private WebElement addressLine1InputField;

    @AndroidFindBy(accessibility = "Address Line 2 input field")
    @iOSXCUITFindBy(id = "Address Line 2 input field")
    private WebElement addressLine2InputField;

    @AndroidFindBy(accessibility = "City* input field")
    @iOSXCUITFindBy(id = "City* input field")
    private WebElement cityInputField;

    @AndroidFindBy(accessibility = "State/Region input field")
    @iOSXCUITFindBy(id = "State/Region input field")
    private WebElement stateInputField;

    @AndroidFindBy(accessibility = "Zip Code* input field")
    @iOSXCUITFindBy(id = "Zip Code* input field")
    private WebElement zipInputField;

    @AndroidFindBy(accessibility = "Country* input field")
    @iOSXCUITFindBy(id = "Country* input field")
    private WebElement countryInputField;

    @AndroidFindBy(accessibility = "To Payment button")
    @iOSXCUITFindBy(id = "To Payment button")
    private WebElement toPaymentButton;

    public void enterFullName(String fullName) {
        this.mobileHelper.waitForElementToVisible(this.fullNameInputField);
        this.fullNameInputField.sendKeys(fullName);
    }

    public void enterAddressLine1(String address) {
        this.addressLine1InputField.sendKeys(address);
    }

    public void enterAddressLine2(String address) {
        this.addressLine2InputField.sendKeys(address);
    }

    public void enterCity(String city) {
        this.cityInputField.sendKeys(city);
    }

    public void enterState(String state) {
        this.stateInputField.sendKeys(state);
    }

    public void enterZipCode(String code) {
        this.zipInputField.sendKeys(code);
    }

    public void enterCountry(String country) {
        this.countryInputField.sendKeys(country);
    }

    public void tapOnPaymentButton() {
        this.toPaymentButton.click();
    }
}
