package managers;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class LocalDriverManager extends  DriverManager {

    public AppiumDriver createAppiumDriver(String appiumServerURL, String deviceName, String platform, String platformVersion, String appPackage, String appActivity) throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("appium:deviceName", deviceName);
        capabilities.setCapability("appium:platformVersion", platformVersion);

        switch (getPlatform(platform)) {
            case ANDROID:
                capabilities.setCapability("appium:platformName", "Android");
                capabilities.setCapability("appium:appActivity", appActivity);
                capabilities.setCapability("appium:appPackage", appPackage);
                capabilities.setCapability("appium:automationName", "UiAutomator2");
                appiumDriver.set(new AndroidDriver(new URL(appiumServerURL), capabilities));
                break;
            case IOS:
                capabilities.setCapability("appium:platformName", "iOS");
                capabilities.setCapability("appium:bundleId", appPackage);
                capabilities.setCapability("appium:automationName", "XCUITest");
                capabilities.setCapability("appium:userAppiumHybrid", true);
                capabilities.setCapability("appium:locationServiceAuthorized", false);
                capabilities.setCapability("appium:useAppiumForHybrid", true);
                appiumDriver.set(new IOSDriver(new URL(appiumServerURL), capabilities));
        }
        return appiumDriver.get();
    }
}
