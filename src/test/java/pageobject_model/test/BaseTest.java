package pageobject_model.test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Listeners;
import pageobject_model.driver.DriverManager;
import pageobject_model.driver.DriverManagerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import pageobject_model.util.TestListener;

@Listeners({TestListener.class})
public class BaseTest {
    protected WebDriver driver;
    private DriverManager driverManager;

    @BeforeMethod
    public void setUp()
    {
        driverManager = DriverManagerFactory.getManager();
        driver = driverManager.getDriver();
    }

    @AfterMethod(alwaysRun = true)
    protected void browserTearDown() {
        driverManager.quitDriver();
    }

    @AfterClass
    protected void browserQuit() {
        driver.quit();
    }
}
