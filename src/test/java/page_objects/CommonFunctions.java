package page_objects;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;

import java.time.Duration;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static java.time.Duration.ZERO;

public class CommonFunctions {

    public static void closeKeypad(AppiumDriver driver) {
        if (driver.getCapabilities().getPlatformName().toString().equalsIgnoreCase("Android")) {
            ((AndroidDriver) driver).hideKeyboard();
        }else {
            ((IOSDriver) driver).hideKeyboard();
        }
    }

    public static void tap(AppiumDriver driver, WebElement element){
        Point elementCenterLocation = getCenterOfElement(element);
        PointerInput finger1 = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
        Sequence sequence = new Sequence(finger1, 1)
                .addAction(finger1.createPointerMove(ZERO, PointerInput.Origin.viewport(), elementCenterLocation))
                .addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(new Pause(finger1,Duration.ofMillis(200)))
                .addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(Collections.singletonList(sequence));
    }

    public static void tap(AppiumDriver driver, String text){
        WebElement element = driver.findElement(By.xpath("//*[@text='"+text+"'] | //*[@label='"+text+"'] | //*[@name='"+text+"']"));
        Point elementCenterLocation = getCenterOfElement(element);
        PointerInput finger1 = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
        Sequence sequence = new Sequence(finger1, 1)
                .addAction(finger1.createPointerMove(ZERO, PointerInput.Origin.viewport(), elementCenterLocation))
                .addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(new Pause(finger1,Duration.ofMillis(200)))
                .addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(Collections.singletonList(sequence));
    }

    private static Point getCenterOfElement(WebElement element){
        Point location = element.getLocation();
        Dimension size = element.getSize();
        return new Point(location.getX() + size.getWidth() / 2, location.getY() + size.getHeight() / 2);
    }

    public static void swipe(AppiumDriver driver, WebElement element){
        Dimension size = driver.manage().window().getSize();
        int start_x = size.getWidth() / 2;
        int start_y = size.getHeight() / 2;
        int end_x = start_x;
        int end_y = (int) (size.getWidth() * 0.30);

        PointerInput finger1 = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
        Sequence sequence = new Sequence(finger1, 1)
                .addAction(finger1.createPointerMove(ZERO, PointerInput.Origin.viewport(),start_x, start_y))
                .addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(new Pause(finger1, Duration.ofMillis(500)))
                .addAction(finger1.createPointerMove(ZERO,PointerInput.Origin.viewport(), end_x, end_y))
                .addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(Collections.singletonList(sequence));
    }

    public static void swipe(AppiumDriver driver) {
        Map<String, Object> args = new HashMap<>();
        args.put("direction", "up");
        driver.executeScript("mobile: swipe", args);
    }

    public static void tapOnVisibleButtonText(AppiumDriver driver, String buttonVisibleText) {
        Map<String, Object> params = new HashMap<>();
        params.put("text", buttonVisibleText);
        params.put("action", "tap");
        //params.put("ignorecase", true);
        driver.executeScript("mobile:ocr:tapText", params);
    }

    public static void scroll(AppiumDriver driver) {
        Map<String, Object> params = new HashMap<>();
        params.put("direction", "down");
        //params.put("element", "elementId");
        driver.executeScript("mobile: scroll", params);
    }

    public void swipeByScript(AppiumDriver driver) {
        Map<String, Object> params = new HashMap<>();
        params.put("direction", "left");
        params.put("startX", 100);
        params.put("startY", 100);
        params.put("endX", 200);
        params.put("endY", 200);
        driver.executeScript("mobile: swipe", params);
    }

    public void clear(AppiumDriver driver) {
        Map<String, Object> params = new HashMap<>();
        params.put("element", "elementId");
        driver.executeScript("mobile: clear", params);
    }

    public void sendKeys(AppiumDriver driver) {
        Map<String, Object> params = new HashMap<>();
        params.put("element", "elementId");
        params.put("value", "Your Text");
        driver.executeScript("mobile: sendKeys", params);
    }

    public void enterText(AppiumDriver driver, WebElement element, String text) throws InterruptedException {
        if (driver.getCapabilities().getPlatformName().toString().equalsIgnoreCase("Android")) {
            element.sendKeys(text);
        }else {
            element.click();
            Thread.sleep(4000);
            element.sendKeys(text);
            driver.findElement(new AppiumBy.ByAccessibilityId("Return")).click();
        }
    }


}
