package helpers;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;

public class MobileHelper {
    private AppiumDriver driver;
    private long timeoutInSeconds;

    public MobileHelper(AppiumDriver driver) {
        this.driver = driver;
        this.timeoutInSeconds = 10;
    }

    public MobileHelper(AppiumDriver driver, long timeoutInSeconds) {
        this.driver = driver;
        this.timeoutInSeconds = timeoutInSeconds;
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
}
