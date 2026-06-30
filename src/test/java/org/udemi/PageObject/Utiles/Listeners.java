package org.udemi.PageObject.Utiles;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import io.appium.java_client.AppiumDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.ITestContext;

import java.io.IOException;

public class Listeners extends AppiumUtilsCommon implements ITestListener {
ExtentReports extent= Extentreport.config();
    ExtentTest test;
    AppiumDriver driver;
    // fires when a test STARTS
    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("Test started: " + result.getName());
         test= extent.createTest(result.getMethod().getMethodName());
    }

    // fires when a test PASSES ✅
    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("Test passed: " + result.getName());
        test.log(Status.PASS,"test Passed");
    }

    // fires when a test FAILS ❌
    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("Test failed: " + result.getName());
   test.fail(result.getThrowable());
        try {
            driver = (AppiumDriver) result.getTestClass()
                    .getRealClass()
                    .getField("driver")
                    .get(result.getInstance());
        } catch (Exception e1) {
            e1.printStackTrace();
        }
   try{
       test.addScreenCaptureFromPath(getScreenshotPath(result.getMethod().getMethodName(),driver),result.getMethod().getMethodName());
   }catch (IOException e){
       e.printStackTrace();
   }


    }

    // fires when a test is SKIPPED ⚠️
    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("Test skipped : " + result.getName());
    }

    // fires before ANY test in the suite runs
    @Override
    public void onStart(ITestContext context) {
        System.out.println("Suite started :  " + context.getName());
    }

    // fires after ALL tests in the suite finish
    @Override
    public void onFinish(ITestContext context) {
        System.out.println("Suite finished : " + context.getName());
        extent.flush();
    }
}