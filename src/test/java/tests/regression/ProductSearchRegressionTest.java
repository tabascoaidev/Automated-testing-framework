package tests.regression;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import pages.ProductPage;
import tests.BaseTest;
import utils.TestData;

public class ProductSearchRegressionTest extends BaseTest {

    @Test
    void shouldReturnProductsForKeywordSearch() {
        homePage.loadHomePage().searchForProduct(TestData.DEFAULT_SEARCH_KEYWORD);
        ProductPage productPage = homePage.openFirstSearchResult();
        assertTrue(productPage.isAddToCartVisible(), "Search result product page should expose Add to Cart.");
    }
}
