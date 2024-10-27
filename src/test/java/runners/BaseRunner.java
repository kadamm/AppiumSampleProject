package runners;

import io.appium.java_client.AppiumDriver;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import managers.LocalDriverManager;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import utilities.ReadPropertiesFiles;

import java.net.MalformedURLException;

public class BaseRunner extends AbstractTestNGCucumberTests {
    private LocalDriverManager localDriverManager;
    AppiumDriver driver;
    ReadPropertiesFiles readPropertiesFiles;
    public BaseRunner() {
        this.localDriverManager = new LocalDriverManager();
        this.readPropertiesFiles = new ReadPropertiesFiles();
    }

    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() { return  super.scenarios(); }

    @BeforeMethod
    @Parameters({"deviceName", "platformName", "platformVersion"})
    public void setup (String deviceName, String platformName, String platformVersion) throws MalformedURLException {
        if (LocalDriverManager.getAppiumDriver() == null){
            this.driver = localDriverManager.createAppiumDriver(readPropertiesFiles.getConfigurationProperty("appium.url"), deviceName, platformName,platformVersion,readPropertiesFiles.getConfigurationProperty("app.package"), readPropertiesFiles.getConfigurationProperty("app.activity"));
        }
    }

    @AfterTest
    public void cleanup(){
        LocalDriverManager.quitAppiumDriver();
    }
}
