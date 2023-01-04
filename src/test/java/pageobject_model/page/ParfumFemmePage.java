package pageobject_model.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ParfumFemmePage extends BasePage{
    private static final String FULL_BRANDS_LIST = "//div[@class='facet Marque']//li[text()='Voir tout']";
    private static final String FILTER_BY_BRAND = "//label[contains(text(),'Yves saint')]/..";
    private static final String SEARCHED_PRODUCT = "//*[@title = 'Eau de parfum intense']";

    @FindBy(xpath = FULL_BRANDS_LIST)
    private WebElement fullBrandsListButton;

    @FindBy(xpath = FILTER_BY_BRAND)
    private WebElement filterByBrand;

    @FindBy(xpath = SEARCHED_PRODUCT)
    private WebElement searchedProduct;

    public ParfumFemmePage(WebDriver driver) {
        super(driver);
    }

    public SearchedProductPage gotoSearchedProductPage() {
        waitForElementClickableBy(By.xpath(FULL_BRANDS_LIST));
        fullBrandsListButton.click();
        waitForElementClickableBy(By.xpath(FILTER_BY_BRAND));
        filterByBrand.click();
        waitForElementClickableBy(By.xpath(SEARCHED_PRODUCT));
        searchedProduct.click();
        return new SearchedProductPage(driver);
    }
}
