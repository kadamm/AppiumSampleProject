package page_objects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class SuccessScreen {

    private AppiumDriver driver;
    public SuccessScreen(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(this.driver, Duration.ofSeconds(10)), this);
    }

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Checkout Complete']")
    @iOSXCUITFindBy(accessibility = "Checkout Complete")
    private WebElement checkoutCompletedMessage;

    @AndroidFindBy(accessibility = "Continue Shopping button")
    @iOSXCUITFindBy(accessibility = "Continue Shopping button")
    private WebElement continueShoppingButton;

    public String getCheckSuccessMessage() {
        return this.checkoutCompletedMessage.getText();
    }
}
