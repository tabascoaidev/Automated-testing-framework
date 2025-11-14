package tests.regression;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import tests.BaseTest;

public class PostDeploymentRegressionTest extends BaseTest {

    @Test
    void shouldValidateCriticalElementsAfterDeployment() {
        homePage.loadHomePage();
        boolean stableUi = homePage.areCriticalElementsVisible();
        assertTrue(stableUi, "Critical UI elements must remain visible after new deployments.");
    }
}
