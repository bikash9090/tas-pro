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
	public void onTestStart(ITestResult result) {
		
		ITestListener.super.onTestStart(result);
		
		test = report.createTest("Test Method", result.getMethod().getDescription());
		test.assignCategory(result.getTestContext().getSuite().getName());
		test.log(Status.PASS, "Test started");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println(result.getMethod()+" Test passes...");
		ITestListener.super.onTestSuccess(result);
	}

	@Override
	public void onTestFailure(ITestResult result) {
		scrUtil = new ScreenShotUtil(DriverFactory.getDriverFactoryInstance().getDriver());
		scrUtil.takeScreenShot();
		ITestListener.super.onTestFailure(result);
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSkipped(result);
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedWithTimeout(result);
	}

	@Override
	public void onStart(ITestContext context) {
		ITestListener.super.onStart(context);
	}

	@Override
	public void onFinish(ITestContext context) {
		report.flush();
		ITestListener.super.onFinish(context);
	}

}
