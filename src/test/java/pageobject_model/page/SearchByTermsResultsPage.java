package pageobject_model.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchByTermsResultsPage extends BasePage{
    private final Logger logger = LogManager.getRootLogger();

    @FindBy (xpath = "//*[@class = 'product-listing product-grid']/li")
    private List<WebElement> generalSearchResults;

    public SearchByTermsResultsPage(WebDriver driver) {
        super(driver);
    }
    public int countSearchResults(){
        logger.info("Search results number for requested term: " + generalSearchResults.size());

        return generalSearchResults.size();
    }
}
