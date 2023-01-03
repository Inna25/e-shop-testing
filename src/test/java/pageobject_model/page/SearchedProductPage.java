package pageobject_model.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchedProductPage {
    private WebDriver driver;

    @FindBy(xpath = "//span[@class='producRangeName' and text()='LIBRE']")
    private WebElement productRangeName;

    @FindBy(xpath = "//span[@class='productName' and text()='Eau de parfum intense']")
    private WebElement productName;

    public SearchedProductPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean productFound(){
        if (productName != null && productRangeName != null) {
            return true;
        } else {
            return false;
        }
    }
}
