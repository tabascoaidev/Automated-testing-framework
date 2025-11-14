package tests.regression;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import pages.CartPage;
import pages.CheckoutPage;
import pages.ProductPage;
import tests.BaseTest;
import utils.TestData;

public class CheckoutRegressionTest extends BaseTest {

    @Test
    void shouldShowErrorsWhenCheckoutFormIsEmpty() {
        ProductPage productPage = homePage.loadHomePage().openFeaturedProduct();
        CartPage cartPage = productPage.addProductToCart(1).openCart();
        CheckoutPage checkoutPage = cartPage.proceedToCheckout();
        checkoutPage.submitOrder();
        boolean hasErrors = checkoutPage.isValidationErrorDisplayed();
        assertTrue(hasErrors, "Submitting an empty checkout form must display validation errors.");
    }

    @Test
    void shouldCompleteCheckoutFlowWithValidData() {
        ProductPage productPage = homePage.loadHomePage().openFeaturedProduct();
        CartPage cartPage = productPage.addProductToCart(1).openCart();
        CheckoutPage checkoutPage = cartPage.proceedToCheckout();
        checkoutPage.fillBillingDetails(TestData.defaultBillingInfo()).submitOrder();
        boolean confirmation = checkoutPage.isOrderConfirmationDisplayed();
        assertTrue(confirmation, "Valid checkout data should yield an order confirmation.");
    }
}
