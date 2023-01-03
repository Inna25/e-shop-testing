package pageobject_model.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ParfumPage {
    private WebDriver driver;

    @FindBy(xpath = "//div[@class='row category-page-main-container']//a[@title = 'Parfum Femme']")
    private WebElement menuItemParfumFemme;

    public ParfumPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public ParfumFemmePage gotoParfumFemmePage(){
        menuItemParfumFemme.click();
        return new ParfumFemmePage(driver);
    }
}
