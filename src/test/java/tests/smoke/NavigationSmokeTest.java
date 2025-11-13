package tests.smoke;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import pages.CartPage;
import pages.ProductPage;
import tests.BaseTest;

public class NavigationSmokeTest extends BaseTest {

    @Test
    void shouldOpenFeaturedProductFromHome() {
        ProductPage productPage = homePage.loadHomePage().openFeaturedProduct();
        boolean productLoaded = productPage.isLoaded();
        assertTrue(productLoaded, "Clicking a featured product should open its detail page.");
    }

    @Test
    void shouldOpenCartFromHeaderShortcut() {
        CartPage cartPage = homePage.loadHomePage().openCartFromHeader();
        boolean cartLoaded = cartPage.isLoaded();
        assertTrue(cartLoaded, "Cart should open from the header shortcut.");
    }
}
