import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.sql.SQLOutput;
import java.time.Duration;
import java.util.List;

public class MarionnaudTest {
    private WebDriver driver;

    @BeforeMethod (alwaysRun = true)
    public void browser(){
        driver = new ChromeDriver();
    }
    @Test (description = "There are some products contained 'Libre' in the name")
    public void searchProductResultsNotEmptyTest() {

        driver.get("https://www.marionnaud.fr/");
        //I can't create this wait method!!!
        //new WebDriverWait(driver, Duration.ofSeconds(10)).until(CustomConditions.jQueryAJAXCompleted());

        if (waitForElementVisibleBy(driver, By.id("onetrust-accept-btn-handler"))) {
            WebElement bannerCloseButton = driver.findElement(By.id("onetrust-accept-btn-handler"));
            bannerCloseButton.click();
        }

        WebElement searchInput = driver.findElement(By.xpath("//*[@id='top-bar-search-text']//*[@name='text']"));
        searchInput.sendKeys("Libre"); //intense

        List<WebElement> searchButton = driver.findElements(By.xpath("//*[@id='top-bar-search-text']//button"));
        searchButton.get(0).click();
        //risky point
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//*[@class = 'product-listing product-grid']/li")));

        List<WebElement> searchResults = driver.findElements(By.xpath("//*[@class = 'product-listing product-grid']/li"));
        System.out.println("Search results number for requested term: "+ searchResults.size());

        Assert.assertTrue(searchResults.size()>0, "Search result is empty!");

    }
    @AfterMethod (alwaysRun = true)
    public void browserTearDown(){
        driver.quit();
        driver=null;
    }

    private static boolean waitForElementVisibleBy(WebDriver driver, By by){
        try {
            new WebDriverWait(driver, Duration.ofSeconds(1)).until(ExpectedConditions.presenceOfElementLocated(by));
            return true;
        } catch (TimeoutException exp){
            return false;
        }
    }
}
