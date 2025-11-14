package tests.smoke;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import pages.HomePage;
import tests.BaseTest;

public class HomeSmokeTest extends BaseTest {

    @Test
    void shouldLoadHomePage() {
        HomePage page = homePage;
        boolean isLoaded = page.loadHomePage().isHeroBannerVisible();
        assertTrue(isLoaded, "Home page hero banner should render when the site is available.");
    }

    @Test
    void shouldDisplayMainUiElements() {
        HomePage page = homePage;
        boolean visible = page.loadHomePage().areCriticalElementsVisible();
        assertTrue(visible, "Navigation, hero, and cart controls must be present on load.");
    }
}
