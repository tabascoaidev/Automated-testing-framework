package tests.regression;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import pages.CartPage;
import pages.ProductPage;
import tests.BaseTest;

public class CartRegressionTest extends BaseTest {

    @Test
    void shouldAddProductToCart() {
        ProductPage productPage = homePage.loadHomePage().openFeaturedProduct();
        CartPage cartPage = productPage.addProductToCart(1).openCart();
        assertTrue(cartPage.getCartItemCount() > 0, "Cart should contain the product that was added.");
    }

    @Test
    void shouldRemoveProductFromCart() {
        ProductPage productPage = homePage.loadHomePage().openFeaturedProduct();
        CartPage cartPage = productPage.addProductToCart(1).openCart();
        boolean empty = cartPage.removeFirstItem().isEmptyStateVisible();
        assertTrue(empty, "Removing the product should show the empty cart state.");
    }

    @Test
    void shouldValidateCartPriceCalculations() {
        ProductPage productPage = homePage.loadHomePage().openFeaturedProduct();
        double unitPrice = productPage.getDisplayedPrice();
        CartPage cartPage = productPage.addProductToCart(2).openCart();
        double subtotal = cartPage.getSubtotal();
        assertEquals(unitPrice * 2, subtotal, 0.01, "Subtotal should equal quantity multiplied by unit price.");
    }
}
