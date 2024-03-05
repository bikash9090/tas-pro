package com.taspro.listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.taspro.base.DriverFactory;
import com.taspro.utility.ScreenShotUtil;

public class ReportListners implements ITestListener {

	private static ExtentReports report = ExtentReportManager.initReport();
	public static ExtentTest test;
	ScreenShotUtil scrUtil;

	@Override
	public synchronized void onTestStart(ITestResult result) {
		test = report.createTest(result.getMethod().getMethodName());
		test.assignCategory(result.getTestContext().getSuite().getName());
	}

	@Override
	public synchronized void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, "Test passed.");
	}

	@Override
	public synchronized void onTestFailure(ITestResult result) {
		scrUtil = new ScreenShotUtil(DriverFactory.getDriverFactoryInstance().getDriver());

		test.addScreenCaptureFromPath(scrUtil.takeScreenShot(result.getMethod().getMethodName()));
		test.log(Status.FAIL, "Test Failed.");
		test.log(Status.FAIL, result.getThrowable());
		
	}

	@Override
	public synchronized void onTestSkipped(ITestResult result) {
		scrUtil = new ScreenShotUtil(DriverFactory.getDriverFactoryInstance().getDriver());

		test.addScreenCaptureFromPath(scrUtil.takeScreenShot(result.getMethod().getMethodName()));
		test.log(Status.SKIP, "Test skipped.");
		test.log(Status.SKIP, result.getThrowable());
	}

	@Override
	public synchronized void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		scrUtil = new ScreenShotUtil(DriverFactory.getDriverFactoryInstance().getDriver());

		test.addScreenCaptureFromPath(scrUtil.takeScreenShot(result.getMethod().getMethodName()));
		test.log(Status.FAIL, "Test Failed with percentage");
		test.log(Status.FAIL, result.getThrowable().getMessage());
	}

	@Override
	public synchronized void onTestFailedWithTimeout(ITestResult result) {
		scrUtil = new ScreenShotUtil(DriverFactory.getDriverFactoryInstance().getDriver());

		test.addScreenCaptureFromPath(scrUtil.takeScreenShot(result.getMethod().getMethodName()));
		test.log(Status.FAIL, "Test Failed with TimeOut");
		test.log(Status.FAIL, result.getThrowable().getMessage());
	}

	@Override
	public synchronized void onStart(ITestContext context) {

	}

	@Override
	public synchronized void onFinish(ITestContext context) {
		report.flush();
	}

}
