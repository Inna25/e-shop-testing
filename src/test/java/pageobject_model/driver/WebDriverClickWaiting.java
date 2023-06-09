package pageobject_model.driver;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Interactive;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Collection;
import java.util.List;
import java.util.Set;

public class WebDriverClickWaiting implements WebDriver, TakesScreenshot, Interactive, JavascriptExecutor {

    private WebDriver webDriver;

    public WebDriverClickWaiting(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    @Override
    public void get(String url) {
        webDriver.get(url);
    }

    @Override
    public String getCurrentUrl() {
        return webDriver.getCurrentUrl();
    }

    @Override
    public String getTitle() {
        return webDriver.getTitle();
    }

    @Override
    public List<WebElement> findElements(By by) {

        return webDriver.findElements(by);
    }

    @Override
    public WebElement findElement(By by) {
        WebElement element = webDriver.findElement(by);
        WebDriverUtils.waitForElementClickableBy(webDriver, by);
        return element;
    }

    @Override
    public String getPageSource() {

        return webDriver.getPageSource();
    }

    @Override
    public void close() {
        webDriver.close();
    }

    @Override
    public void quit() {
        webDriver.quit();
    }

    @Override
    public Set<String> getWindowHandles() {
        return webDriver.getWindowHandles();
    }

    @Override
    public String getWindowHandle() {
        return webDriver.getWindowHandle();
    }

    @Override
    public TargetLocator switchTo() {
        return webDriver.switchTo();
    }

    @Override
    public Navigation navigate() {
        return webDriver.navigate();
    }

    @Override
    public Options manage() {
        return webDriver.manage();
    }

    @Override
    public <X> X getScreenshotAs(OutputType<X> target) throws WebDriverException {
        return ((TakesScreenshot)webDriver).getScreenshotAs(target);
    }

    @Override
    public void perform(Collection<Sequence> actions) {
        ((Interactive)webDriver).perform(actions);
    }

    @Override
    public void resetInputState() {
        ((Interactive)webDriver).resetInputState();
    }

    @Override
    public Object executeScript(String script, Object... args) {
        return ((JavascriptExecutor)webDriver).executeScript(script, args);
    }

    @Override
    public Object executeAsyncScript(String script, Object... args) {
        return ((JavascriptExecutor)webDriver).executeScript(script, args);
    }
}
