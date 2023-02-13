package pageobject_model.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import pageobject_model.driver.WebDriverClickWaiting;

public class ActionsDemoPage extends BasePage {
    private static final String ACTION_DEMO_PAGE_URL = "https://www.globalsqa.com/demo-site/draganddrop/";
    private static final String PICTURE = "//*[@class='ui-widget-header' and text()='High Tatras']";
    private static final String PICTURE_TO_TRASH_BUTTON =
            "//*[@class='ui-widget-header' and text()='High Tatras']/../a[@title='Delete this image']";
    public static final String PICTURE_IN_TRASH = "//div[@id='trash'] //*[@class='ui-widget-header' and text()='High Tatras']/..";
    public static final String PICTURE_RESTORE_FROM_TRASH_BUTTON = "//div[@id='trash']//a[@title='Recycle this image']";
    public static final String FRAME = "iframe[class='demo-frame lazyloaded']";
    private final Logger logger = LogManager.getRootLogger();

    @FindBy(xpath = PICTURE)
    private WebElement picture;

    @FindBy(id = "trash")
    private WebElement trash;

    @FindBy(xpath = PICTURE_TO_TRASH_BUTTON)
    private WebElement pictureToTrashButton;

    @FindBy(xpath = PICTURE_IN_TRASH)
    private WebElement pictureInTrash;

    @FindBy(xpath = PICTURE_RESTORE_FROM_TRASH_BUTTON)
    private WebElement pictureRestoreFromTrashButton;

    public ActionsDemoPage(WebDriver driver) {          //public ActionsDemoPage(WebDriver driver) {
        super(driver);
    }

    public ActionsDemoPage openPage() {
        driver.get(ACTION_DEMO_PAGE_URL);
        logger.info("Page for drag and drop demonstration is opened");
        return this;
    }

    public void dragAndDropElement() {
        driver.switchTo().frame(driver.findElement(By.cssSelector(FRAME)));
        Actions builder = new Actions(driver);
        builder.dragAndDrop(picture, trash).perform();
        logger.info("Picture is moved to trash");
    }

    public boolean pictureIsInTrash(){
     //   waitForElementClickableBy(By.xpath(PICTURE_IN_TRASH));
        logger.info("Picture is in trash");
        return pictureInTrash.isEnabled();
    }

    public void deletePicture(){
        driver.switchTo().frame(driver.findElement(By.cssSelector(FRAME)));
        clickUsingJavascript(pictureToTrashButton, By.xpath(PICTURE_TO_TRASH_BUTTON), By.xpath(PICTURE_IN_TRASH));
        logger.info("Picture is moved to trash");
    }
    public boolean restorePicture(){
        clickUsingJavascript(pictureRestoreFromTrashButton, By.xpath(PICTURE_RESTORE_FROM_TRASH_BUTTON), By.xpath(PICTURE));
        logger.info("Picture restored");
        return picture.isDisplayed();
    }
    private void clickUsingJavascript(WebElement elementForClick, By locationBeforeClick, By locationAfterClick){
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        waitForElementClickableBy(locationBeforeClick);
//        js.executeScript("arguments[0].click();", elementForClick);
//        waitForElementClickableBy(locationAfterClick);
    }
}
