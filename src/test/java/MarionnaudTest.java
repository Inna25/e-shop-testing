import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.SQLOutput;
import java.time.Duration;
import java.util.List;

public class MarionnaudTest {
    @Test
    public void searchProductResultsNotEmptyTest() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.marionnaud.fr/");
        //I can't create this wait method!!!
        //new WebDriverWait(driver, Duration.ofSeconds(10)).until(CustomConditions.jQueryAJAXCompleted());

        WebElement bannerCloseButton = waitForElementLocatedBy(driver, By.id("onetrust-accept-btn-handler"));
        if (bannerCloseButton.isDisplayed()) bannerCloseButton.click(); //I am not sure that it will work when won't be banner

        //search input
        WebElement searchInput = driver.findElement(By.xpath("//*[@id='top-bar-search-text']//*[@name='text']"));
        searchInput.sendKeys("Libre"); //intense

        //search button
        List<WebElement> searchButton = driver.findElements(By.xpath("//*[@id='top-bar-search-text']//button"));
        searchButton.get(0).click();
        //risky point - точка возможного перехода на другую страницу или глобального обновления страницы
        // ждём появления результатов поиск - мне не надо, не знаю, как искать
       // new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.presenceOfAllElementsLocatedBy())

        List<WebElement> searchResults = driver.findElements(By.xpath("//*[@class = 'product-listing product-grid']/li"));
        System.out.println("Search results number for requested term: "+ searchResults.size());

        Assert.assertTrue(searchResults.size()>0, "Search result is empty!");
        driver.quit();
    }

    private static WebElement waitForElementLocatedBy(WebDriver driver, By by) {

        WebElement bannerCloseButton = new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.presenceOfElementLocated(by));
        return bannerCloseButton;

    }
}
