package pageobject_model.test;

import pageobject_model.driver.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    protected WebDriver driver;
    @BeforeMethod
    public void setUp()
    {
        driver = DriverSingleton.getDriver();     //"chrome"  firefox
    }

    @AfterMethod(alwaysRun = true)
    protected void browserTearDown() {
        DriverSingleton.closeDriver();
    }
}
