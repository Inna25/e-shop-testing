package pageobject_model.page;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    private static final String HOMEPAGE_URL = "https://www.marionnaud.fr/";
    private WebDriver driver;

    @FindBy(xpath = "//*[@id='top-bar-search-text']//*[@name='text']")
    private WebElement searchInput;

    @FindBy(xpath = "//*[@id='top-bar-search-text']//button")
    private WebElement searchButton;

    @FindBy (xpath = "//div[@class='nav-produit sub-nav sub-nav-active']//a[@title = 'Parfum']")
    private WebElement menuItemParfum;
//    @FindBy(id = "onetrust-accept-btn-handler")
//    private WebElement bannerCloseButton;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public HomePage openPage(){
        driver.get(HOMEPAGE_URL);
        //I can't create this wait method!!!
       // new WebDriverWait(driver, Duration.ofSeconds(10)).until(CustomConditions.jQueryAJAXCompleted());
        return this;
    }

    public SearchByTermsResultsPage searchForTerm(String term){
        searchInput.sendKeys(term);
        searchButton.click();
        return new SearchByTermsResultsPage(driver, term);
    }

    public ParfumPage gotoParfumPage(){
        menuItemParfum.click();
        return new ParfumPage(driver);
    }

    public HomePage closeBanner() {
        if (waitForElementVisibleBy(driver, By.id("onetrust-accept-btn-handler"))) {
            WebElement bannerCloseButton = driver.findElement(By.id("onetrust-accept-btn-handler"));
            bannerCloseButton.click();
        }
        return this;
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
