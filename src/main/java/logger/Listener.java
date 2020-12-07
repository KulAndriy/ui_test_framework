package logger;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listener implements ITestListener {
    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("\n");
        MyLogger.getLogger().info("\n");
        MyLogger.getLogger().info("Test: [{}] is started!!!", result.getName());
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
        MyLogger.getLogger().info("///////////////////////////////////////////////////////////////////////");
    }

    @Override
    public void onFinish(ITestContext context) {
        MyLogger.getLogger().info("\nTests: {} PASSED.\nTests: {} SKIPPED.\nTests: {} FAILURE.", context.getPassedTests().getAllMethods(), context.getSkippedTests(), context.getFailedTests());
    }
}
