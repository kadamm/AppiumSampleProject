package runners;

import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        tags = ("@smoke"),
        features = "src/test/resources/features",
        glue = "step_definitions",
        plugin = {
                "summary",
                "pretty",
                "json:target/cucumber-reports/JsonReports.json",
                "html:target/cucumber-reports/Reports.html"
        },
monochrome = true
)
public class RegressionRunner extends BaseRunner {
}
