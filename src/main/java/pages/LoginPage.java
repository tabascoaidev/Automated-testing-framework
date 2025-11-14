package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.AppConfig;

public class LoginPage extends BasePage {

    private final By loginForm = By.cssSelector("form.login, form#customer_login");
    private final By emailInput = By.cssSelector("input[type='email'], input#username, input[name='username']");
    private final By passwordInput = By.cssSelector("input[type='password'], input#password");
    private final By submitButton = By.cssSelector("button[type='submit'], button[name='login']");
    private final By successBanner = By.cssSelector(".woocommerce-MyAccount-navigation, .account-content, .logged-in");
    private final By errorBanner = By.cssSelector(".woocommerce-error, .alert-danger");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage loadLoginPage() {
        open(AppConfig.LOGIN_URL);
        return this;
    }

    public boolean isLoaded() {
        return isDisplayed(loginForm);
    }

    public LoginPage enterUsername(String username) {
        type(emailInput, username);
        return this;
    }

    public LoginPage enterPassword(String password) {
        type(passwordInput, password);
        return this;
    }

    public LoginPage submitLogin() {
        click(submitButton);
        return this;
    }

    public boolean loginWith(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        submitLogin();
        return isSuccessMessageVisible();
    }

    public boolean isSuccessMessageVisible() {
        return isDisplayed(successBanner);
    }

    public boolean isErrorDisplayed() {
        return isDisplayed(errorBanner);
    }
}
