package listener;

import io.qameta.allure.Attachment;
import logger.MyLogger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.*;
import webdriver.DriverWrapper;


public class Listener implements ITestListener, IInvokedMethodListener {

    @Override
    public void onTestStart(ITestResult result) {
        MyLogger.getLogger().info("\n Test: [{}] is started!!!", result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        MyLogger.getLogger().info("Test: [{}] PASSED.", result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        MyLogger.getLogger().info("Test: [{}] FAILURE.", result.getName());
        saveScreenshotPNG(DriverWrapper.getDriver());
    }

    @Override
    public void onStart(ITestContext context) {
        MyLogger.getLogger().info("Test class {}.", context.getName());
    }

    @Override
    public void onFinish(ITestContext context) {
        MyLogger.getLogger().info("\nTests: {} PASSED.\nTests: {} SKIPPED.\nTests: {} FAILURE.", context.getPassedTests().getAllMethods(), context.getSkippedTests(), context.getFailedTests());
    }

    @Attachment(value = "Page screenshot", type = "image/png")
    public byte[] saveScreenshotPNG (WebDriver driver) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }
}
