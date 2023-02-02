package pageobject_model.test;

import org.testng.annotations.Listeners;
import pageobject_model.driver.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pageobject_model.util.TestListener;

@Listeners({TestListener.class})
public class BaseTest {
    protected WebDriver driver;
    @BeforeMethod
    public void setUp()
    {
        driver = DriverSingleton.getDriver();
    }

    @AfterMethod(alwaysRun = true)
    protected void browserTearDown() {
        DriverSingleton.closeDriver();
    }
}
