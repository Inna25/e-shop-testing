package pageobject_model.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchByTermsResultsPage extends BasePage{

    @FindBy (xpath = "//*[@class = 'product-listing product-grid']/li")
    private List<WebElement> generalSearchResults;

    public SearchByTermsResultsPage(WebDriver driver) {
        super(driver);
    }
    public int countSearchResults(){
        System.out.println("Search results number for requested term: "+ generalSearchResults.size());
        return generalSearchResults.size();
    }
}
