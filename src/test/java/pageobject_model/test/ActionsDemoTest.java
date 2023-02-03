package pageobject_model.test;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobject_model.page.ActionsDemoPage;

public class ActionsDemoTest extends BaseTest{
    private ActionsDemoPage actionsDemoPage;

    @Test(description = "'High Tatras' picture is deleted and then restored by using Actions tool")
    public void deleteAndRestorePictureUsingActionsTest() {
        actionsDemoPage = new ActionsDemoPage(driver).openPage();
        actionsDemoPage.dragAndDropElement();
        Assert.assertTrue(actionsDemoPage.pictureIsInTrash());
        Assert.assertTrue(actionsDemoPage.restorePicture());
    }

    @Test(description = "'High Tatras' picture is deleted and then restored by using JavaScript Executor tool")
    public void deleteAndRestorePictureUsingJSExecutorTest() {
        actionsDemoPage = new ActionsDemoPage(driver).openPage();
        actionsDemoPage.deletePicture();
        Assert.assertTrue(actionsDemoPage.pictureIsInTrash());
        Assert.assertTrue(actionsDemoPage.restorePicture());
    }
}
