package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.AppConfig;

public class HomePage extends BasePage {

    private final By heroBanner = By.cssSelector("section.hero, .wp-block-cover, header.site-header");
    private final By loginLink = By.cssSelector("a[href*='account'], a[href*='login']");
    private final By searchInput = By.cssSelector("form[role='search'] input[type='search'], input.search-field");
    private final By searchButton = By.cssSelector("form[role='search'] button[type='submit'], button.search-submit");
    private final By navigationMenu = By.cssSelector("nav, .main-navigation");
    private final By featuredProductCard = By.cssSelector(".products .product:first-of-type a.woocommerce-LoopProduct-link");
    private final By firstSearchResult = By.cssSelector(".products .product:first-of-type a.woocommerce-LoopProduct-link");
    private final By cartIcon = By.cssSelector("a[href*='cart'], .cart-contents");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public HomePage loadHomePage() {
        open(AppConfig.BASE_URL);
        return this;
    }

    public boolean isHeroBannerVisible() {
        return isDisplayed(heroBanner);
    }

    public boolean areCriticalElementsVisible() {
        return isHeroBannerVisible() && isNavigationVisible() && isCartIconVisible();
    }

    public boolean isNavigationVisible() {
        return isDisplayed(navigationMenu);
    }

    public LoginPage openLogin() {
        click(loginLink);
        return new LoginPage(driver);
    }

    public HomePage searchForProduct(String keyword) {
        type(searchInput, keyword);
        click(searchButton);
        return this;
    }

    public ProductPage openFirstSearchResult() {
        click(firstSearchResult);
        return new ProductPage(driver);
    }

    public ProductPage openFeaturedProduct() {
        click(featuredProductCard);
        return new ProductPage(driver);
    }

    public CartPage openCartFromHeader() {
        click(cartIcon);
        return new CartPage(driver);
    }

    private boolean isCartIconVisible() {
        return isDisplayed(cartIcon);
    }
}
