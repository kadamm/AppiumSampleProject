package step_definitions;

import io.appium.java_client.AppiumDriver;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import managers.DriverManager;
import page_objects.Checkout;
import page_objects.LoginScreen;
import utilities.ReadPropertiesFiles;

import java.util.List;
import java.util.Map;

public class CheckoutSteps {
    private Checkout checkout;
    AppiumDriver driver;

    ReadPropertiesFiles readPropertiesFiles;

    public CheckoutSteps() {
        this.driver = DriverManager.getAppiumDriver();
        this.checkout =  new Checkout(this.driver);
        this.readPropertiesFiles = ReadPropertiesFiles.getPropertyFileInstance();
    }

    @And("I started the checkout process with below details")
    public void iStartedTheCheckoutProcessWithBelowDetails(DataTable dataTable) {
        String fullName = null, addressLine1 = null, addressLine2 = null, city = null, state = null, zipCode = null, country = null;
        List<Map<String, String>> checkoutDetails =  dataTable.asMaps(String.class, String.class);

        for (Map<String, String> details : checkoutDetails) {
            fullName = details.get("Full_Name");
            addressLine1 = details.get("Address_Line_1");
            addressLine2 = details.get("Address_Line_2");
            city = details.get("City");
            state = details.get("State");
            zipCode = details.get("Zip_Code");
            country = details.get("Country");
        }
        
        this.checkout.enterFullName(fullName);
        this.checkout.enterAddressLine1(addressLine1);
        this.checkout.enterCity(city);
        this.checkout.enterZipCode(zipCode);
        this.checkout.enterCountry(country);

        this.checkout.tapOnPaymentButton();
    }
}
