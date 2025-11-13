package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.WaitUtils;

public abstract class BasePage {

    protected final WebDriver driver;

    protected BasePage(WebDriver driver) {
        this.driver = driver;
    }

    protected void open(String url) {
        driver.get(url);
        WaitUtils.waitForPageLoad(driver);
    }

    protected WebElement waitAndFind(By locator) {
        return WaitUtils.waitForVisible(driver, locator);
    }

    protected void click(By locator) {
        WaitUtils.waitForClickable(driver, locator).click();
    }

    protected void type(By locator, String text) {
        WebElement element = waitAndFind(locator);
        element.clear();
        element.sendKeys(text);
    }

    protected boolean isDisplayed(By locator) {
        try {
            return waitAndFind(locator).isDisplayed();
        } catch (TimeoutException ex) {
            return false;
        }
    }

    protected String readText(By locator) {
        return waitAndFind(locator).getText().trim();
    }

    protected void scrollIntoView(By locator) {
        WebElement element = waitAndFind(locator);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    protected double parseCurrency(String currencyText) {
        String digits = currencyText.replaceAll("[^0-9.,]", "").replace(",", ".");
        if (digits.isEmpty()) {
            return 0.0;
        }
        return Double.parseDouble(digits);
    }
}
