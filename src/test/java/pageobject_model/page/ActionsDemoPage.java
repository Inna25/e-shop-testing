package pageobject_model.page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class ActionsDemoPage extends BasePage {
    private static final String ACTION_DEMO_PAGE_URL = "https://www.globalsqa.com/demo-site/draganddrop/";
    private static final String PICTURE = "//*[@class='ui-widget-header' and text()='High Tatras']";
    private static final String PICTURE_TO_TRASH_BUTTON =
            "//*[@class='ui-widget-header' and text()='High Tatras']/../a[@title='Delete this image']";
    public static final String PICTURE_IN_TRASH = "//div[@id='trash'] //*[@class='ui-widget-header' and text()='High Tatras']/..";
    public static final String PICTURE_RESTORE_FROM_TRASH_BUTTON = "//div[@id='trash']//a[@title='Recycle this image']";
    public static final String FRAME = "iframe[class='demo-frame lazyloaded']";

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

    public ActionsDemoPage(WebDriver driver) {
        super(driver);
    }

    public ActionsDemoPage openPage() {
        driver.get(ACTION_DEMO_PAGE_URL);
        return this;
    }

    public void dragAndDropElement() {
        driver.switchTo().frame(driver.findElement(By.cssSelector(FRAME)));
        Actions builder = new Actions(driver);
        builder.dragAndDrop(picture, trash).perform();
    }

    public boolean pictureIsInTrash(){
        waitForElementClickableBy(By.xpath(PICTURE_IN_TRASH));
        return pictureInTrash.isEnabled();
    }

    public void deletePicture(){
        driver.switchTo().frame(driver.findElement(By.cssSelector(FRAME)));
        clickUsingJavascript(pictureToTrashButton, PICTURE_TO_TRASH_BUTTON, PICTURE_IN_TRASH);
    }
    public boolean restorePicture(){
        clickUsingJavascript(pictureRestoreFromTrashButton, PICTURE_RESTORE_FROM_TRASH_BUTTON, PICTURE);
        return picture.isDisplayed();
    }
    private void clickUsingJavascript(WebElement elementForClick, String locationBeforeClick, String locationAfterClick){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        waitForElementClickableBy(By.xpath(locationBeforeClick));
        js.executeScript("arguments[0].click();", elementForClick);
        waitForElementClickableBy(By.xpath(locationAfterClick));
    }
}
