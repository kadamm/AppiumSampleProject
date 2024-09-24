package page_objects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class Checkout {

    private AppiumDriver driver;
    public Checkout(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(this.driver), this);
    }

    @AndroidFindBy(accessibility = "Full Name* input field")
    @iOSXCUITFindBy(id = "TBU")
    private WebElement fullNameInputField;

    @AndroidFindBy(accessibility = "Address Line 1* input field")
    @iOSXCUITFindBy(id = "TBU")
    private WebElement addressLine1InputField;

    @AndroidFindBy(accessibility = "Address Line 2 input field")
    @iOSXCUITFindBy(id = "TBU")
    private WebElement addressLine2InputField;

    @AndroidFindBy(accessibility = "City* input field")
    @iOSXCUITFindBy(id = "TBU")
    private WebElement cityInputField;

    @AndroidFindBy(accessibility = "State/Region input field")
    @iOSXCUITFindBy(id = "TBU")
    private WebElement stateInputField;

    @AndroidFindBy(accessibility = "Zip Code* input field")
    @iOSXCUITFindBy(id = "TBU")
    private WebElement zipInputField;

    @AndroidFindBy(accessibility = "Country* input field")
    @iOSXCUITFindBy(id = "TBU")
    private WebElement countryInputField;

    @AndroidFindBy(accessibility = "To Payment button")
    @iOSXCUITFindBy(id = "TBU")
    private WebElement toPaymentButton;

    public void enterFullName(String fullName) {
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
