package pageobject_model.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class HomePage extends BasePage{
    private static final String HOMEPAGE_URL = "https://www.marionnaud.fr/";
    private static final String BANNER_CLOSE_BUTTON = "onetrust-accept-btn-handler";

    @FindBy(xpath = "//*[@id='top-bar-search-text']//*[@name='text']")
    private WebElement searchInput;

    @FindBy(xpath = "//*[@id='top-bar-search-text']//button")
    private WebElement searchButton;

    @FindBy (xpath = "//div[@class='nav-produit sub-nav sub-nav-active']//a[@title = 'Parfum']")
    private WebElement menuItemParfum;

    @FindBy(id = BANNER_CLOSE_BUTTON)
    private WebElement bannerCloseButton;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public HomePage openPage(){
        driver.get(HOMEPAGE_URL);
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
        if (waitForElementVisibleBy(driver, By.id(BANNER_CLOSE_BUTTON))) {
            bannerCloseButton.click();
        }
        return this;
    }
}
