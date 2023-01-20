package pageobject_model.test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;

public class BaseTest {
    protected WebDriver driver;

    @AfterMethod
    protected void browserTearDown() {
        driver.quit();
        driver = null;
    }
}
