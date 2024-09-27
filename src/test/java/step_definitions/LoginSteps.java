package step_definitions;

import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import managers.DriverManager;
import page_objects.LoginScreen;
import utilities.ReadPropertiesFiles;

public class LoginSteps {
    private LoginScreen loginScreen;
    AppiumDriver driver;

    ReadPropertiesFiles readPropertiesFiles;

    public LoginSteps() {
        this.driver = DriverManager.getAppiumDriver();
        this.loginScreen =  new LoginScreen(this.driver);
        this.readPropertiesFiles = ReadPropertiesFiles.getPropertyFileInstance();

    }

    @When("I am login into the application with valid credentials")
    public void IAmOnHomeScreenByLoginWithValidCredentials(){
        this.loginScreen.enterEmail(readPropertiesFiles.getConfigurationProperty("username"));
        this.loginScreen.enterPassword(readPropertiesFiles.getConfigurationProperty("password"));
        this.loginScreen.tapSignInButton();
    }
}
