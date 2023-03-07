package pageobject_model.util;

import com.epam.reportportal.message.ReportPortalMessage;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import pageobject_model.driver.DriverManagerFactory;

import java.io.File;
import java.io.IOException;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class TestListener implements ITestListener {
    private Logger logger = LogManager.getRootLogger();

    public void onTestStart(ITestResult iTestResult) {
        logger.info("on test method " + getTestMethodName(iTestResult) + " start");
    }

    public void onTestSuccess(ITestResult iTestResult) {
        logger.info("on test method " + getTestMethodName(iTestResult) + " success");
        saveScreenshot();
    }

    public void onTestFailure(ITestResult iTestResult) {
        logger.info("on test method " + getTestMethodName(iTestResult) + " failure");
        saveScreenshot();
    }

    public void onTestSkipped(ITestResult iTestResult) {

    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    public void onStart(ITestContext iTestContext) {

    }

    public void onFinish(ITestContext iTestContext) {

    }

    private void saveScreenshot(){
        String message = "Screenshot was saved in ";
        File screenCapture = ((TakesScreenshot) DriverManagerFactory.getManager().getDriver())
                .getScreenshotAs(OutputType.FILE);
//        try {
//            ReportPortalMessage rp_message = new ReportPortalMessage(screenCapture, message);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
        try {
            File screenCaptureInScreenshotsFolder = new File(
                    ".//target/screenshots/"
                            + getCurrentTimeAsString() +
                            ".png");
            FileUtils.copyFile(screenCapture, screenCaptureInScreenshotsFolder);
            ReportPortalMessage rp_message = new ReportPortalMessage(screenCapture, message);
            logger.info(message + System.getProperty("user.dir") +
                    screenCaptureInScreenshotsFolder.getPath().substring(1));
            logger.info(rp_message);
        } catch (IOException e) {
            logger.error("Failed to save screenshot: " + e.getLocalizedMessage());
        }
    }

    private String getCurrentTimeAsString(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern( "uuuu-MM-dd_HH-mm-ss" );
        return ZonedDateTime.now().format(formatter);
    }
    private static String getTestMethodName(ITestResult result) {
        return result.getMethod().getConstructorOrMethod().getName();
    }
}
