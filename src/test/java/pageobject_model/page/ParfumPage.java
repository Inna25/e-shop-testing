package pageobject_model.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ParfumPage extends BasePage{
    private static final String MENU_ITEM_PARFUM_FEMME = "//div[@class='row category-page-main-container']//a[@title = 'Parfum Femme']";
    @FindBy(xpath = MENU_ITEM_PARFUM_FEMME)
    private WebElement menuItemParfumFemme;

    public ParfumPage(WebDriver driver) {
        super(driver);
    }

    public ParfumFemmePage gotoParfumFemmePage(){
        waitForElementVisibleBy(driver, By.xpath(MENU_ITEM_PARFUM_FEMME));
        menuItemParfumFemme.click();
        return new ParfumFemmePage(driver);
    }
}
