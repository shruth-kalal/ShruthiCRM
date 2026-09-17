package co.qa.ExtentReportListner;

import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;


public class ExtentReportListner implements ITestListener
          {
	ExtentReports extent;
    ExtentTest test;

    public void onStart(org.testng.ITestContext context)
    {
        ExtentSparkReporter rp = new ExtentSparkReporter("ExtentReport.html");

        extent = new ExtentReports();
        extent.attachReporter(rp);
    }

    public void onTestStart(ITestResult result)
    {
        test = extent.createTest(result.getName());
    }

    
    public void onTestSuccess(ITestResult result)
    {
        test.pass("Test Passed");
    }

    
    public void onTestFailure(ITestResult result)
    {
        test.fail(result.getThrowable());
    }
    

    public void onTestSkipped(ITestResult result)
    {
        test.skip("Test Skipped");
    }

    // ADD THIS
    public void onConfigurationFailure(ITestResult result)
    {
        test = extent.createTest(result.getTestClass().getName() + " - Configuration");
        test.fail(result.getThrowable());
    }

    // ADD THIS
    public void onConfigurationSuccess(ITestResult result)
    {
        // Configuration passed
    }

    public void onFinish(org.testng.ITestContext context)
    {
        extent.flush();
    }
}