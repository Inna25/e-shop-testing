package pageobject_model.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ParfumFemmePage {
    private WebDriver driver;

    @FindBy(xpath = "//div[@class='facet Marque']//li[text()='Voir tout']")
    private WebElement fullBrandsListButton;

    @FindBy(xpath = "//label[contains(text(),'Yves')]")
    private WebElement filterByBrand;

    @FindBy(xpath = "//*[@class='primImg primaryImage_prodcat'][@title = 'Eau de parfum intense']" )
    private WebElement searchedProduct;

    public ParfumFemmePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public SearchedProductPage gotoSearchProductPage() throws InterruptedException {
        fullBrandsListButton.click();
        Thread.sleep(5000);
        filterByBrand.click();
        Thread.sleep(8000);
        searchedProduct.click();
        return new SearchedProductPage(driver);
    }
}
