package pageobject_model.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobject_model.page.HomePage;

public class MarionnaudTest {
    private WebDriver driver;
    private final static String SEARCHED_PRODUCT = "Libre intense";
    @BeforeMethod (alwaysRun = true)
    public void browserSetup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test (description = "There are some products contained 'Libre' in the name")
    public void searchProductResultsNotEmptyTest() {
        HomePage homePage = new HomePage(driver).openPage().closeBanner();
        int searchResultsNumber = homePage
                .searchForTerm("Libre")
                .countSearchResults();
        Assert.assertTrue(searchResultsNumber>0, "Search result is empty!");
    }
    @Test (description = "Specified product is found")
    public void searchForSpecificProductTest() throws InterruptedException {
        HomePage homePage = new HomePage(driver).openPage().closeBanner();
       // int searchResultsNumber = homePage.searchForProduct(SEARCHED_PRODUCT);
        //Assert.assertTrue(homePage.searchForProduct(SEARCHED_PRODUCT), "Product not found");
        boolean productFounded = homePage.gotoParfumPage()
                                    .gotoParfumFemmePage()
                                    .gotoSearchProductPage()
                                    .productFound();
        Assert.assertTrue(productFounded, "Product not found");
    }
    @AfterMethod (alwaysRun = true)
    public void browserTearDown(){
        driver.quit();
        driver=null;
    }

}
