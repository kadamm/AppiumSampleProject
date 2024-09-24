package step_definitions;

import io.appium.java_client.AppiumDriver;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import managers.DriverManager;
import page_objects.Checkout;
import page_objects.PaymentMethodScreen;
import utilities.ReadPropertiesFiles;

import java.util.List;
import java.util.Map;

public class PaymentMethodSteps {
    AppiumDriver driver;

    PaymentMethodScreen paymentMethodScreen;

    public PaymentMethodSteps() {
        this.driver = DriverManager.getAppiumDriver();
        this.paymentMethodScreen =  new PaymentMethodScreen(this.driver);
    }
    @And("I proceed with payment with below details")
    public void iProceedWithPaymentWithBelowDetails(DataTable dataTable) {
        String fullName = null, cardNumber = null, expiryDate = null, secureCode = null;
        List<Map<String, String>> paymentDetails =  dataTable.asMaps(String.class, String.class);

        for (Map<String, String> details : paymentDetails) {
            fullName = details.get("Full_Name");
            cardNumber = details.get("Card_Number");
            expiryDate = details.get("Expiry_date");
            secureCode = details.get("Secure_code");
        }

        this.paymentMethodScreen.enterFullName(fullName);
        this.paymentMethodScreen.enterCardNumber(cardNumber);
        this.paymentMethodScreen.enterExpiryDate(expiryDate);
        this.paymentMethodScreen.enterSecureCode(secureCode);

        this.paymentMethodScreen.tapOnReviewOrderButton();
    }
}
