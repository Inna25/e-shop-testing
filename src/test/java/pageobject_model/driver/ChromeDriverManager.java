package pageobject_model.driver;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Platform;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.IOException;

public class ChromeDriverManager extends DriverManager{
    private ChromeDriverService chService;

    @Override
    protected void startService() {
        if (null == chService) {
            try {
                chService = new ChromeDriverService.Builder()
                        .usingAnyFreePort()
                        .build();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        try {
            chService.start();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void stopService() {
        if (null != chService && chService.isRunning())
            chService.stop();
    }

    @Override
    protected void createDriver() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setPlatform(Platform.WIN10);
        capabilities.setBrowserName("chrome");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("test-type");
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        driver = new ChromeDriver(chService, options);
    }
}
