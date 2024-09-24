package step_definitions;

import io.appium.java_client.AppiumDriver;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import managers.DriverManager;
import org.testng.asserts.SoftAssert;
import page_objects.ReviewYourOrderScreen;
import utilities.ReadPropertiesFiles;

import java.util.List;
import java.util.Map;

public class ReviewYourOrderSteps {
    AppiumDriver driver;
    ReviewYourOrderScreen reviewYourOrderScreen;
    ReadPropertiesFiles readPropertiesFiles;
    public ReviewYourOrderSteps() {
        this.driver = DriverManager.getAppiumDriver();
        this.readPropertiesFiles = ReadPropertiesFiles.getPropertyFileInstance();
        this.reviewYourOrderScreen = new ReviewYourOrderScreen(this.driver);
    }

    @Then("I verify the details on Review your order screen matches to below details")
    public void iVerifyTheDetailsOnReviewYourOrderScreen(DataTable dataTable) {
        String fullName = null, addressLine1 = null, addressLine2 = null, city = null, cardNumber = null, productName = null;
        List<Map<String, String>> checkoutDetails =  dataTable.asMaps(String.class, String.class);

        for (Map<String, String> details : checkoutDetails) {
            fullName = details.get("Full_Name");
            addressLine1 = details.get("Address_Line_1");
            addressLine2 = details.get("Address_Line_2");
            city = details.get("City");
            productName = details.get("Product_Name");
            cardNumber = details.get("Card_Number");
        }

        SoftAssert sa = new SoftAssert();
        sa.assertEquals(this.reviewYourOrderScreen.getProductName(), productName );
        sa.assertEquals(this.reviewYourOrderScreen.getAddressLine1(), addressLine1);
        sa.assertEquals(this.reviewYourOrderScreen.getCity(), city);

        sa.assertEquals(this.reviewYourOrderScreen.getFullName(), fullName);
        sa.assertEquals(this.reviewYourOrderScreen.getCardNumber(), cardNumber);

        sa.assertAll();
    }

    @When("I tap on the place order button")
    public void iTapOnThePlaceOrderButton() {
        this.reviewYourOrderScreen.proceedToCheckoutButton();
    }
}
