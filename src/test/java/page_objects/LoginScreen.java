package page_objects;

import helpers.MobileHelper;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class LoginScreen {

    private AppiumDriver driver;
    private MobileHelper mobileHelper;
    public LoginScreen(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(this.driver, Duration.ofSeconds(10)), this);
        this.mobileHelper = new MobileHelper(this.driver, 10);
    }

    @AndroidFindBy(accessibility = "Username input field")
    @iOSXCUITFindBy(id = "Username input field")
    private WebElement emailField;

    @AndroidFindBy(accessibility = "Password input field")
    @iOSXCUITFindBy(id = "Password input field")
    private WebElement passwordField;

    @AndroidFindBy(accessibility = "Login button")
    @iOSXCUITFindBy(id = "Login button")
    private WebElement signInButton;

    public void enterEmail(String emailId) throws InterruptedException {
        this.mobileHelper.waitForElementToVisible(this.emailField);
        this.emailField.sendKeys(emailId);
    }

    public void enterPassword(String password) {
        this.passwordField.sendKeys(password);
        if (driver.getCapabilities().getPlatformName().toString().equalsIgnoreCase("iOS")) {
            this.driver.findElement(new AppiumBy.ByAccessibilityId("Return")).click();
        }
    }

    public void tapSignInButton() {
        CommonFunctions.tapOnVisibleButtonText(this.driver, "Login");
        this.signInButton.click();
    }
}
