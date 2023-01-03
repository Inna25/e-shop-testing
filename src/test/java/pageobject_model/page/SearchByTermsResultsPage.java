package pageobject_model.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SearchByTermsResultsPage {

    private final String splitRegex = "\\s"; // ????? probably don't need
    private WebDriver driver;
    private String searchTerm;

    private String defaultLocator = "//*[@class = 'product-listing product-grid']/li";
    private String containsPart = " and contains(.,'%s')";       // ????? probably don't need

    @FindBy (xpath = "//*[@class = 'product-listing product-grid']/li")
    private List<WebElement> generalSearchResults;

    public SearchByTermsResultsPage(WebDriver driver, String searchTerm) {
        this.driver = driver;
        this.searchTerm = searchTerm;
        PageFactory.initElements(driver, this);
    }
    public int countSearchResults(){
        System.out.println("Search results number for requested term: "+ generalSearchResults.size());
        return generalSearchResults.size();
    }

//    public int countRefinedSearchResults(){
//        List<WebElement> searchResults = driver.findElements(By.xpath("//*[@class = 'product-listing product-grid']/li"));
//
//    }
    //_____________________________________________________________
    //risky point - точка возможного перехода на другую страницу или глобального обновления страницы
    // ждём появления результатов поиска
//        new WebDriverWait(driver, Duration.ofSeconds(10))
//            .until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//*[@class = 'product-listing product-grid']/li")));

}
