package tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import pages.HomePage;
import utils.DriverFactory;

public abstract class BaseTest {

    protected WebDriver driver;
    protected HomePage homePage;

    @BeforeEach
    void setUp() {
        DriverFactory.initDriver();
        driver = DriverFactory.getDriver();
        homePage = new HomePage(driver);
    }

    @AfterEach
    void tearDown() {
        DriverFactory.quitDriver();
    }
}
