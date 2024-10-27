package managers;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
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

    public AppiumDriver createAppiumDriver1(String appiumServerURL, String deviceName, String platform, String platformVersion, String appPackage, String appActivity) throws MalformedURLException {
        switch (getPlatform(platform)) {
            case ANDROID:
                UiAutomator2Options uiAutomator2Options = new UiAutomator2Options();
                uiAutomator2Options.setPlatformName("Android");
                uiAutomator2Options.setDeviceName(deviceName);
                uiAutomator2Options.setPlatformVersion(platformVersion);
                uiAutomator2Options.setAppPackage(appPackage);
                uiAutomator2Options.setAppActivity(appActivity);
                uiAutomator2Options.setAutomationName("UiAutomator2");
                appiumDriver.set(new AndroidDriver(new URL(appiumServerURL), uiAutomator2Options));
                break;
            case IOS:
                XCUITestOptions xcuiTestOptions = new XCUITestOptions();
                xcuiTestOptions.setPlatformName("iOS");
                xcuiTestOptions.setDeviceName(deviceName);
                xcuiTestOptions.setPlatformVersion(platformVersion);
                xcuiTestOptions.setBundleId(appPackage);
                xcuiTestOptions.setForceSimulatorSoftwareKeyboardPresence(true);
                appiumDriver.set(new IOSDriver(new URL(appiumServerURL), xcuiTestOptions));
        }
        return appiumDriver.get();
    }
}
