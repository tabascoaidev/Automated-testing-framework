package pages;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.AppConfig;
import utils.TestData;
import utils.WaitUtils;

public class CheckoutPage extends BasePage {

    private final By checkoutForm = By.cssSelector("form.checkout");
    private final By firstNameInput = By.cssSelector("#billing_first_name, input[name='billing_first_name']");
    private final By lastNameInput = By.cssSelector("#billing_last_name, input[name='billing_last_name']");
    private final By addressInput = By.cssSelector("#billing_address_1, input[name='billing_address_1']");
    private final By cityInput = By.cssSelector("#billing_city, input[name='billing_city']");
    private final By postalCodeInput = By.cssSelector("#billing_postcode, input[name='billing_postcode']");
    private final By countryInput = By.cssSelector("#billing_country, select[name='billing_country']");
    private final By phoneInput = By.cssSelector("#billing_phone, input[name='billing_phone']");
    private final By emailInput = By.cssSelector("#billing_email, input[name='billing_email']");
    private final By termsCheckbox = By.cssSelector("#terms, input[name='terms']");
    private final By placeOrderButton = By.cssSelector("#place_order, button.place-order");
    private final By errorBanner = By.cssSelector(".woocommerce-error, .alert-danger");
    private final By confirmationSection = By.cssSelector(".woocommerce-order, .order-confirmation, .woocommerce-thankyou-order-received");
    private final By totalLabel = By.cssSelector(".order-total .amount, #order_total");

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public CheckoutPage loadCheckoutPage() {
        open(AppConfig.CHECKOUT_URL);
        return this;
    }

    public CheckoutPage fillBillingDetails(TestData.BillingInfo info) {
        type(firstNameInput, info.getFirstName());
        type(lastNameInput, info.getLastName());
        type(addressInput, info.getAddress());
        type(cityInput, info.getCity());
        type(postalCodeInput, info.getPostalCode());
        type(countryInput, info.getCountry());
        type(phoneInput, info.getPhone());
        type(emailInput, info.getEmail());
        return this;
    }

    public CheckoutPage submitOrder() {
        acceptTermsIfPresent();
        click(placeOrderButton);
        WaitUtils.waitForPageLoad(driver);
        return this;
    }

    public boolean isValidationErrorDisplayed() {
        return isDisplayed(errorBanner);
    }

    public boolean isOrderConfirmationDisplayed() {
        return isDisplayed(confirmationSection);
    }

    public double getOrderTotal() {
        return parseCurrency(readText(totalLabel));
    }

    public CheckoutPage acceptTermsIfPresent() {
        List<WebElement> elements = driver.findElements(termsCheckbox);
        if (!elements.isEmpty()) {
            WebElement checkbox = elements.get(0);
            if (!checkbox.isSelected()) {
                checkbox.click();
            }
        }
        return this;
    }

    public boolean isCheckoutFormVisible() {
        return isDisplayed(checkoutForm);
    }
}
