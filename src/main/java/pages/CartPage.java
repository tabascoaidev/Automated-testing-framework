package pages;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.WaitUtils;

public class CartPage extends BasePage {

    private final By cartTable = By.cssSelector(".shop_table, table.cart");
    private final By cartItems = By.cssSelector("tr.cart_item");
    private final By removeItemButton = By.cssSelector("tr.cart_item .remove");
    private final By subtotalLabel = By.cssSelector(".cart_totals .order-total .amount, tr.cart-subtotal td .amount, tr.cart-subtotal td");
    private final By checkoutButton = By.cssSelector("a.checkout-button, .checkout-button");
    private final By emptyCartNotice = By.cssSelector(".cart-empty, .woocommerce-message");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public boolean isLoaded() {
        return isDisplayed(cartTable) || isDisplayed(emptyCartNotice);
    }

    public int getCartItemCount() {
        List<WebElement> items = driver.findElements(cartItems);
        return items.size();
    }

    public CartPage removeFirstItem() {
        List<WebElement> removeButtons = driver.findElements(removeItemButton);
        if (!removeButtons.isEmpty()) {
            removeButtons.get(0).click();
            WaitUtils.waitForPageLoad(driver);
        }
        return this;
    }

    public double getSubtotal() {
        return parseCurrency(readText(subtotalLabel));
    }

    public CheckoutPage proceedToCheckout() {
        click(checkoutButton);
        return new CheckoutPage(driver);
    }

    public boolean isEmptyStateVisible() {
        return isDisplayed(emptyCartNotice);
    }
}
