package pageobject_model.driver;

import org.openqa.selenium.WebDriver;

public abstract class DriverManager {
    protected WebDriver driver;
    protected abstract void startService();
    protected abstract void stopService();
    protected abstract void createDriver();

    public void quitDriver() {
        if (null != driver) {
            stopService();
            driver = null;
        }
    }
    public WebDriver getDriver() {
        if (null == driver) {
            startService();
            createDriver();
        }
        driver = new WebDriverClickWaiting(driver);
        driver.manage().window().maximize();
        return driver;
    }
}
