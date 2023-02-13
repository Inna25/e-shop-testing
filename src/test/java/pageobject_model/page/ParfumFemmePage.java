package pageobject_model.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageobject_model.model.Product;

public class ParfumFemmePage extends BasePage{
    private static final String FULL_BRANDS_LIST = "//div[@class='facet Marque']//li[text()='Voir tout']";

    private final Logger logger = LogManager.getRootLogger();

    @FindBy(xpath = FULL_BRANDS_LIST)
    private WebElement fullBrandsListButton;

    public ParfumFemmePage(WebDriver driver) {
        super(driver);
    }

    public SearchedProductPage gotoSearchedProductPage(Product searchedProduct) {
        String productNameXpath = searchedProduct.getNameXpath();
        logger.info("Name of driver class: " + driver.getClass().getName());

        fullBrandsListButton.click();
        logger.info("Full list of brands expanded");

        WebElement productBrand = driver.findElement(By.xpath(searchedProduct.getBrandXpath()));
        logger.info("Name of brand: " + productBrand.getText());
        productBrand.click();

        driver.findElement(By.xpath(productNameXpath)).click();
        logger.info("Searched product selected");

        return new SearchedProductPage(driver);
    }
}
