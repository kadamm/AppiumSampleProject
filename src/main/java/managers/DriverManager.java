package managers;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.Platform;
import exception.PlatformNotSupportedException;

public class DriverManager {

    protected static ThreadLocal<AppiumDriver> appiumDriver = new ThreadLocal<>();

    public static AppiumDriver getAppiumDriver(){
        return appiumDriver.get();
    }

    public static void quitAppiumDriver(){
        if (appiumDriver.get() != null){
            appiumDriver.get().quit();
        }
    }

    protected Platform getPlatform(String platform){
        try {
            return Platform.valueOf(platform.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new PlatformNotSupportedException("Platform invalid: valid values are android,iOS");
        }
    }
}
