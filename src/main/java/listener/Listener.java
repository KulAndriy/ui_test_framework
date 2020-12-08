package listener;

import logger.MyLogger;
import org.testng.*;

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
    }

    @Override
    public void onStart(ITestContext context) {
        MyLogger.getLogger().info("Test class {}.", context.getName());
    }

    @Override
    public void onFinish(ITestContext context) {
        MyLogger.getLogger().info("\nTests: {} PASSED.\nTests: {} SKIPPED.\nTests: {} FAILURE.", context.getPassedTests().getAllMethods(), context.getSkippedTests(), context.getFailedTests());
    }
}
