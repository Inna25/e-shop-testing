package pageobject_model.test;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import pageobject_model.page.HomePage;
import pageobject_model.page.SearchedProductPage;

import java.net.MalformedURLException;
import java.net.URL;

public class MarionnaudTest {
    private WebDriver driver;

    private final static String SEARCHED_PRODUCT_NAME = "Eau de parfum intense";
    private final static String SEARCHED_PRODUCT_RANGE_NAME = "LIBRE";
    private final static String SEARCHED_PRODUCT_RANGE_NON_EXISTENT_NAME = "LIBRE NON EXISTENT";
    private HomePage homePage;

    public void browserSetup(String browserName) {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setPlatform(Platform.WIN10);
        caps.setBrowserName(browserName);
        switch (browserName) {
            case "chrome":
                chromeIncognitoMode(caps);
                break;
            case "firefox":
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.addArguments("-private");
                caps.setCapability("moz:firefoxOptions", firefoxOptions);
                break;
            default:
                chromeIncognitoMode(caps);
                break;
        }
        try {
            driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), caps);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        driver.manage().window().maximize();
        homePage = new HomePage(driver).openPage().closeBanner();
    }

    private void chromeIncognitoMode(DesiredCapabilities caps) {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("incognito");
        caps.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
    }

    @Test(description = "Some products contained 'Libre' in the name were found while using a mouse")
    public void searchProductResultsNotEmptyTest() {
        browserSetup("chrome"); //firefox
        int searchResultsNumber = homePage
                .searchForTermUsingMouse(SEARCHED_PRODUCT_RANGE_NAME)
                .countSearchResults();
        Assert.assertTrue(searchResultsNumber > 0, "Search result is empty!");
    }

    @Test(description = "Some products contained 'Libre' in the name were found while using the keyboard")
    public void searchProductResultsNotEmptyUsingKeyboardTest() {
        browserSetup("chrome");
        int searchResultsNumber = homePage
                .searchForTermUsingKeyboard(SEARCHED_PRODUCT_RANGE_NAME)
                .countSearchResults();
        Assert.assertTrue(searchResultsNumber > 0, "Search result is empty!");
    }

    @Test(description = "Make sure that specified product is out")
    public void certainProductIsOutTest() {
        browserSetup("firefox");
        int searchResultsNumber = homePage
                .searchForTermUsingMouse(SEARCHED_PRODUCT_RANGE_NON_EXISTENT_NAME)
                .countSearchResults();
        Assert.assertTrue(searchResultsNumber == 0, "Products were found ");
    }

    @Test(description = "Search for a certain product using menu")
    public void searchForCertainProductUsingMenuTest() {
        browserSetup("chrome");
        SearchedProductPage searchedProductPage = homePage.gotoParfumPage()
                .gotoParfumFemmePage()
                .gotoSearchedProductPage();
        Assert.assertEquals(searchedProductPage.getProductName(), SEARCHED_PRODUCT_NAME);
        Assert.assertEquals(searchedProductPage.getProductRangeName(), SEARCHED_PRODUCT_RANGE_NAME);
    }

    @Test
    public void appearsSubmenuForParfumMenuItem() {
        browserSetup("chrome");
        Assert.assertTrue(homePage.hoverOverMenuItemParfum());
    }

    @AfterMethod(alwaysRun = true)
    public void browserTearDown() {
        driver.quit();
        driver = null;
    }
}
