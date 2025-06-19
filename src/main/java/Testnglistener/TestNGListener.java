package Testnglistener;

import Utils.AllureUtils.AllureClass;
import Utils.ClassesUtils.ClassUtil;
import Utils.FileUtils.FileClass;
import Utils.LogUtils.LogClass;
import org.testng.*;

import java.io.File;

import static Utils.CustomAssert.CustomAssertClass.customAssertAll;
import static Utils.DataUtil.ReadPropertiesData.loadProperties;

public class TestNGListener implements IExecutionListener, ITestListener, IInvokedMethodListener {
    File allureFiles = new File("test-outputs/target/allure-results/");
    File screenFiles = new File("test-outputs/screenshots/");
    File logFiles = new File("test-outputs/Logs/");
    File allureReport = new File("test-outputs/allureReport/");

    @Override
    public void onExecutionStart() {
        LogClass.info("Execution started");

        loadProperties();
        LogClass.info("Properties file loaded");

        FileClass.cleanFolder(allureFiles);
        LogClass.info("Previous Allure files deleted");

        FileClass.cleanFolder(screenFiles);
        LogClass.info("Previous Screenshots deleted");

        FileClass.cleanFolder(logFiles);
        LogClass.info("Previous Logs deleted");

        FileClass.cleanFolder(allureReport);
        LogClass.info("Previous Allure Report deleted");


    }

    @Override
    public void onExecutionFinish() {
        //generate report
        AllureClass.generateReport();

        //open report
        AllureClass.openReport();

        LogClass.info("Execution finished");
    }

    @Override
    public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
        if (method.isTestMethod()) {
            customAssertAll(testResult);
            switch (testResult.getStatus()) {
                case ITestResult.SUCCESS ->
                        ClassUtil.takeScreenshot("Passed -" + testResult.getMethod().getMethodName());
                case ITestResult.FAILURE ->
                        ClassUtil.takeScreenshot("Failed -" + testResult.getMethod().getMethodName());
                case ITestResult.SKIP ->
                        ClassUtil.takeScreenshot("Skipped -" + testResult.getMethod().getMethodName());
            }

            AllureClass.addLogs();
        }

    }

    @Override
    public void onTestStart(ITestResult result) {
        LogClass.info("Test Case", result.getMethod().getMethodName(), "started");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        LogClass.info("Test Case", result.getMethod().getMethodName(), "passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        LogClass.error("Test Case", result.getMethod().getMethodName(), "failed");
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        LogClass.debug("Test Case", result.getMethod().getMethodName(), "skipped");
    }


    @Override
    public void onStart(ITestContext context) {
        LogClass.info("Test Suite", context.getName(), "started");
    }

    @Override
    public void onFinish(ITestContext context) {
        LogClass.info("Test Suite", context.getName(), "finished");
    }


}
