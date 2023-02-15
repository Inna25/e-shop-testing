package pageobject_model.driver;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WebDriverUtils {
    public static boolean waitForElementClickableBy(WebDriver driver, By by) {
        try {
            new WebDriverWait(driver, Duration.ofSeconds(1)).until(ExpectedConditions.elementToBeClickable(by));
            return true;
        } catch (TimeoutException exp) {
            return false;
        }
    }
}
