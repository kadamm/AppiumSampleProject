package step_definitions;

import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import managers.DriverManager;
import org.testng.Assert;
import page_objects.HomeScreen;
import utilities.ReadPropertiesFiles;

public class HomeSteps {
    private HomeScreen homeScreen;
    AppiumDriver driver;

    ReadPropertiesFiles readPropertiesFiles;

    public HomeSteps() {
        this.driver = DriverManager.getAppiumDriver();
        this.homeScreen =  new HomeScreen(this.driver);
        this.readPropertiesFiles = ReadPropertiesFiles.getPropertyFileInstance();

    }

    @When("I select {string} product and add it to the Cart")
    public void iSelectProductAndAddItToTheCart(String productName) {
        this.homeScreen.navigateToProductScreen();
        this.homeScreen.tapOnProduct(productName);
        this.homeScreen.tapOnAddToCartButton();
        this.homeScreen.tapOnCartButton();
    }

    @Then("I verify {string} is visible in my cart")
    public void iVerifyIsVisibleInMyCart(String productName) {
        Assert.assertEquals(this.homeScreen.getMyCartProductName(), productName);
    }

    @Given("I am on application login screen")
    public void iAmOnApplicationLoginScreen() {
        this.homeScreen.logoutFromTheApp();
    }

    @When("I tap on the Proceed to check button")
    public void iTapOnTheProceedToCheckButton() {
        this.homeScreen.tapOnProceedToCheckoutButton();
    }
}
