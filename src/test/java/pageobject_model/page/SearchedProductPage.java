package pageobject_model.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchedProductPage extends BasePage{

    @FindBy(xpath = "//span[@class='producRangeName']")
    private WebElement productRangeName;

    @FindBy(xpath = "//span[@class='productName']")
    private WebElement productName;

    public SearchedProductPage(WebDriver driver) {
        super(driver);
    }

    public String getProductRangeName() {
        return productRangeName.getText();
    }

    public String getProductName() {
        return productName.getText();
    }

}
