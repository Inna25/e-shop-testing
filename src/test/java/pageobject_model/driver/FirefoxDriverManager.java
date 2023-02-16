package pageobject_model.driver;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxDriverService;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.GeckoDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;

public class FirefoxDriverManager extends DriverManager{
    private FirefoxDriverService ffService;
    @Override
    protected void startService() {
        if (null == ffService) {
            try {
                ffService = new GeckoDriverService.Builder()
                        .usingAnyFreePort()
                        .build();
                ffService.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    protected void stopService() {
        if (null != ffService && ffService.isRunning())
            ffService.stop();
    }

    @Override
    protected void createDriver() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName("firefox");
        FirefoxOptions options = new FirefoxOptions();
        options.merge(capabilities);
        driver = new FirefoxDriver(ffService, options);
    }
}
