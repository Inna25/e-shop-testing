package pageobject_model.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{
    private static final String HOMEPAGE_URL = "https://www.marionnaud.fr/";
    private static final String BANNER_CLOSE_BUTTON_ID = "onetrust-accept-btn-handler";
    private static final String MENU_ITEM_PARFUM_FEMME_XPATH = "//li[@class='yCmsComponent dropdown']/a[@title='Parfum Femme']";

    private final Logger logger = LogManager.getRootLogger();

    @FindBy(xpath = "//*[@id='top-bar-search-text']//*[@name='text']")
    private WebElement searchInput;

    @FindBy(xpath = "//*[@id='top-bar-search-text']//button")
    private WebElement searchButton;

    @FindBy (xpath = "//div[@class='nav-produit sub-nav sub-nav-active']//a[@title = 'Parfum']")
    private WebElement menuItemParfum;

    @FindBy(xpath = MENU_ITEM_PARFUM_FEMME_XPATH)
    private WebElement menuItemParfumFemme;

    @FindBy(id = BANNER_CLOSE_BUTTON_ID)
    private WebElement bannerCloseButton;

    @FindBy(xpath = "//a[@href='/brandslist' and @data-href='.nav-marques']")
    private WebElement menuItemBrand;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public HomePage openPage(){
        driver.get(HOMEPAGE_URL);
        ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
        logger.info("Home page is opened");
        return this;
    }

    public SearchByTermsResultsPage searchForTermUsingSearchButtonClick(String term){
        searchInput.sendKeys(term);
        searchButton.click();
        logger.info("Search query is entered");
        return new SearchByTermsResultsPage(driver);
    }

    public SearchByTermsResultsPage searchForTermUsingKeyboard(String term){
        searchInput.sendKeys(term);
        Actions builder = new Actions(driver);
        builder.sendKeys(Keys.RETURN).build().perform();
        logger.info("Search query is entered");
        return new SearchByTermsResultsPage(driver);
    }

    public ParfumPage gotoParfumPage(){
        menuItemParfum.click();
        logger.info("Switched to the Parfum page");
        return new ParfumPage(driver);
    }

    public boolean hoverOverMenuItemParfum(){
        Actions builder = new Actions(driver);
        builder.moveToElement(menuItemParfum).build().perform();
        waitForElementClickableBy(By.xpath(MENU_ITEM_PARFUM_FEMME_XPATH));
        logger.info("Parfum Femme menu item is displayed");
        return menuItemParfumFemme.isDisplayed();
    }

    public HomePage closeBanner() {
        if (waitForElementClickableBy(By.id(BANNER_CLOSE_BUTTON_ID))) {
            bannerCloseButton.click();
            logger.info("Banner is closed");
        }
        return this;
    }
}
