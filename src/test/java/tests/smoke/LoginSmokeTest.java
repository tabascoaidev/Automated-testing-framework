package tests.smoke;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import pages.LoginPage;
import tests.BaseTest;
import utils.AppConfig;

public class LoginSmokeTest extends BaseTest {

    @Test
    void shouldOpenLoginPage() {
        LoginPage loginPage = homePage.loadHomePage().openLogin();
        boolean loaded = loginPage.isLoaded();
        assertTrue(loaded, "Login form should render after navigating from the header.");
    }

    @Test
    void shouldLoginWithValidCredentials() {
        LoginPage loginPage = homePage.loadHomePage().openLogin();
        boolean isLoggedIn = loginPage.loginWith(AppConfig.DEFAULT_USERNAME, AppConfig.DEFAULT_PASSWORD);
        assertTrue(isLoggedIn, "Valid credentials should land the user on their dashboard.");
    }
}
