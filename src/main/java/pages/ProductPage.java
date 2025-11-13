package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductPage extends BasePage {

    private final By productTitle = By.cssSelector("h1.product_title, .product_title");
    private final By priceLabel = By.cssSelector(".summary .price, span.price");
    private final By quantityInput = By.cssSelector("input.qty, input[name='quantity']");
    private final By addToCartButton = By.cssSelector("button.single_add_to_cart_button, button[name='add-to-cart']");
    private final By confirmationBanner = By.cssSelector(".woocommerce-message, .alert-success");
    private final By miniCartLink = By.cssSelector("a[href*='cart'], .cart-contents");

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public boolean isLoaded() {
        return isDisplayed(productTitle);
    }

    public String getProductName() {
        return readText(productTitle);
    }

    public double getDisplayedPrice() {
        return parseCurrency(readText(priceLabel));
    }

    public ProductPage setQuantity(int quantity) {
        WebElement input = waitAndFind(quantityInput);
        input.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        input.sendKeys(String.valueOf(quantity));
        return this;
    }

    public ProductPage addProductToCart(int quantity) {
        if (quantity > 0) {
            setQuantity(quantity);
        }
        click(addToCartButton);
        waitForConfirmation();
        return this;
    }

    public ProductPage waitForConfirmation() {
        waitAndFind(confirmationBanner);
        return this;
    }

    public CartPage openCart() {
        click(miniCartLink);
        return new CartPage(driver);
    }

    public boolean isAddToCartVisible() {
        return isDisplayed(addToCartButton);
    }
}
