package pageobject_model.test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobject_model.page.ActionsDemoPage;

public class ActionsDemoTest extends BaseTest{
    private ActionsDemoPage actionsDemoPage;

    @BeforeMethod(alwaysRun = true)
    public void browserSetup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        actionsDemoPage = new ActionsDemoPage(driver).openPage();
    }

    @Test(description = "'High Tatras' picture is deleted and then restored by using Actions tool")
    public void deleteAndRestorePictureUsingActionsTest() {
        actionsDemoPage.dragAndDropElement();
        Assert.assertTrue(actionsDemoPage.pictureIsInTrash());
        Assert.assertTrue(actionsDemoPage.restorePicture());
    }

    @Test(description = "'High Tatras' picture is deleted and then restored by using JavaScript Executor tool")
    public void deleteAndRestorePictureUsingJSExecutorTest() {
        actionsDemoPage.deletePicture();
        Assert.assertTrue(actionsDemoPage.pictureIsInTrash());
        Assert.assertTrue(actionsDemoPage.restorePicture());
    }
}
