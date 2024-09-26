package page_objects;

import helpers.MobileHelper;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class PaymentMethodScreen {
    private AppiumDriver driver;
    private MobileHelper mobileHelper;
    public PaymentMethodScreen(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(this.driver, Duration.ofSeconds(10)), this);
        this.mobileHelper = new MobileHelper(this.driver, 10);
    }

    @AndroidFindBy(accessibility = "Full Name* input field")
    @iOSXCUITFindBy(id = "TBU")
    private WebElement fullNameInputField;

    @AndroidFindBy(accessibility = "Card Number* input field")
    @iOSXCUITFindBy(id = "TBU")
    private WebElement cardNumberInputField;

    @AndroidFindBy(accessibility = "Expiration Date* input field")
    @iOSXCUITFindBy(id = "TBU")
    private WebElement expiryDateInputField;

    @AndroidFindBy(accessibility = "Security Code* input field")
    @iOSXCUITFindBy(id = "TBU")
    private WebElement secureCodeInputField;

    @AndroidFindBy(accessibility = "Review Order button")
    @iOSXCUITFindBy(id = "TBU")
    private WebElement reviewOrderButton;


    public void enterFullName(String name) {
        this.mobileHelper.waitForElementToVisible(this.fullNameInputField);
        this.fullNameInputField.sendKeys(name);
    }

    public void enterCardNumber(String cardNumber) {
        this.cardNumberInputField.sendKeys(cardNumber);
    }

    public void enterExpiryDate(String date) {
        this.expiryDateInputField.sendKeys(date);
    }

    public void enterSecureCode(String code) {
        this.secureCodeInputField.sendKeys(code);
    }

    public void tapOnReviewOrderButton() {
        this.reviewOrderButton.click();
    }
}
