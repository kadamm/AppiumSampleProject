package helpers;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MobileHelper {
    private AppiumDriver driver;
    private long timeoutInSeconds;

    private Wait wait;

    public MobileHelper(AppiumDriver driver) {
        this.driver = driver;
        this.timeoutInSeconds = 10;
    }

    public MobileHelper(AppiumDriver driver, long timeoutInSeconds) {
        this.driver = driver;
        this.timeoutInSeconds = timeoutInSeconds;
        this.wait =new WebDriverWait(this.driver, Duration.ofSeconds(this.timeoutInSeconds));
    }

    public boolean isEnabled(WebElement element) {
        return element.isEnabled();
    }

    public boolean isSelected(WebElement element) {
        return element.isSelected();
    }

    public boolean isElementVisible(WebElement element){
        return element.isDisplayed();
    }

    public void waitForElementToVisible(WebElement element) {
        this.wait.until(ExpectedConditions.elementToBeClickable(element));
    }
}
