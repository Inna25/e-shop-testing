package pageobject_model.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ParfumPage extends BasePage{
    private static final String MENU_ITEM_PARFUM_FEMME = "//div[@class='row category-page-main-container']//a[@title = 'Parfum Femme']";
    private final Logger logger = LogManager.getRootLogger();

    @FindBy(xpath = MENU_ITEM_PARFUM_FEMME)
    private WebElement menuItemParfumFemme;

    public ParfumPage(WebDriver driver) {
        super(driver);
    }

    public ParfumFemmePage gotoParfumFemmePage(){
        menuItemParfumFemme.click();
        logger.info("Switched to the Parfum Femme page");
        return new ParfumFemmePage(driver);
    }
}
