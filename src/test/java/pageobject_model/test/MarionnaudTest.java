package pageobject_model.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobject_model.page.HomePage;
import pageobject_model.page.SearchedProductPage;

public class MarionnaudTest {
    private WebDriver driver;

    private final static String SEARCHED_PRODUCT_NAME = "Eau de parfum intense";
    private final static String SEARCHED_PRODUCT_RANGE_NAME = "LIBRE";
    private final static String SEARCHED_PRODUCT_RANGE_NON_EXISTENT_NAME = "LIBRE NON EXISTENT";

    @BeforeMethod(alwaysRun = true)
    public void browserSetup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test(description = "There are some products contained 'Libre' in the name")
    public void searchProductResultsNotEmptyTest() {
        HomePage homePage = new HomePage(driver).openPage().closeBanner();
        int searchResultsNumber = homePage
                .searchForTerm(SEARCHED_PRODUCT_RANGE_NAME)
                .countSearchResults();
        Assert.assertTrue(searchResultsNumber > 0, "Search result is empty!");
    }

    @Test(description = "Make sure that specified product is out")
    public void certainProductIsOutTest() {
        HomePage homePage = new HomePage(driver).openPage().closeBanner();
        int searchResultsNumber = homePage
                .searchForTerm(SEARCHED_PRODUCT_RANGE_NON_EXISTENT_NAME)
                .countSearchResults();
        Assert.assertTrue(searchResultsNumber == 0, "Products were found ");
    }

    @Test(description = "Search for a certain product using menu")
    public void searchForCertainProductUsingMenuTest() {
        HomePage homePage = new HomePage(driver).openPage().closeBanner();
        SearchedProductPage searchedProductPage = homePage.gotoParfumPage()
                .gotoParfumFemmePage()
                .gotoSearchedProductPage();
        Assert.assertEquals(searchedProductPage.getProductName(), SEARCHED_PRODUCT_NAME);
        Assert.assertEquals(searchedProductPage.getProductRangeName(), SEARCHED_PRODUCT_RANGE_NAME);
    }

    @AfterMethod(alwaysRun = true)
    public void browserTearDown() {
        driver.quit();
        driver = null;
    }
}
