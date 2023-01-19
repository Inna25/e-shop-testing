package pageobject_model.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobject_model.page.ActionsDemoPage;

import java.time.Duration;

public class ActionsDemoTest {
    private WebDriver driver;
    private ActionsDemoPage actionsDemoPage;

    @BeforeMethod(alwaysRun = true)
    public void browserSetup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        actionsDemoPage = new ActionsDemoPage(driver).openPage(); //create Page
        new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test(description = "'High Tatras' picture is deleted and then restored by using Actions tool")
    public void deleteAndRestorePictureUsingActionsTest() {

        Assert.assertTrue(actionsDemoPage.dragAndDropElement());
        Assert.assertTrue(actionsDemoPage.restorePicture());

    }

    @Test(description = "'High Tatras' picture is deleted and then restored by using JavaScript Executor tool")
    public void deleteAndRestorePictureUsingJSExecutorTest() {
        Assert.assertTrue(actionsDemoPage.deletePicture());
        Assert.assertTrue(actionsDemoPage.restorePicture());
    }

    @AfterMethod(alwaysRun = true)
    public void browserTearDown() {
        driver.quit();
        driver = null;
    }
}
