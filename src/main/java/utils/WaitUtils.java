package utils;

import java.time.Duration;
import java.util.function.Function;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

public final class WaitUtils {

    private WaitUtils() {
    }

    private static FluentWait<WebDriver> getWait(WebDriver driver) {
        return new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(AppConfig.DEFAULT_TIMEOUT))
                .pollingEvery(Duration.ofMillis(500))
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class);
    }

    public static WebElement waitForVisible(WebDriver driver, By locator) {
        return getWait(driver).until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static WebElement waitForClickable(WebDriver driver, By locator) {
        return getWait(driver).until(ExpectedConditions.elementToBeClickable(locator));
    }

    public static void waitForText(WebDriver driver, By locator, String value) {
        getWait(driver).until(ExpectedConditions.textToBe(locator, value));
    }

    public static void waitForPageLoad(WebDriver driver) {
        getWait(driver).until((Function<WebDriver, Boolean>) d ->
                ((JavascriptExecutor) d).executeScript("return document.readyState").equals("complete"));
    }
}
