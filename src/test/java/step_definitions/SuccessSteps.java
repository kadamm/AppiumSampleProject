package step_definitions;

import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.Then;
import managers.DriverManager;
import org.testng.Assert;
import page_objects.Checkout;
import page_objects.SuccessScreen;
import utilities.ReadPropertiesFiles;

public class SuccessSteps {
    AppiumDriver driver;
    SuccessScreen successScreen;
    ReadPropertiesFiles readPropertiesFiles;

    public SuccessSteps() {
        this.driver = DriverManager.getAppiumDriver();
        this.readPropertiesFiles = ReadPropertiesFiles.getPropertyFileInstance();
        this.successScreen = new SuccessScreen(this.driver);
    }

    @Then("I verify checkout complete success screen")
    public void iVerifyCheckoutCompleteSuccessScreen() {
        Assert.assertEquals(this.successScreen.getCheckSuccessMessage(), "Checkout Complete");
    }
}
