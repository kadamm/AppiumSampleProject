package page_objects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class PaymentMethodScreen {
    private AppiumDriver driver;
    public PaymentMethodScreen(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(this.driver), this);
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
