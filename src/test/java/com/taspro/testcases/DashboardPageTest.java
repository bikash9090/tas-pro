package com.taspro.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.taspro.base.TestBase;
import com.taspro.pages.DashboardPage;
import com.taspro.pages.LoginPage;
import com.taspro.utility.PropertiesUtil;

public class DashboardPageTest extends TestBase {

	LoginPage loginPage;
	PropertiesUtil propertiesUtil;
	DashboardPage dashboardPage;

	/*----------------------------------------BeforClass initialization----------------------------------------------*/
	@BeforeMethod
	public void initialization() {
		launchWebSite();
		loginPage = new LoginPage(driver);
		propertiesUtil = new PropertiesUtil();
		dashboardPage = new DashboardPage(driver);
	}

	/*------------------------------------Closing the browser after the test ----------------------------------------*/
	@AfterMethod
	public void close() {
		// tearDown();
	}
	/*--------------------------------------------TESTCASES----------------------------------------------*/

	@Test(testName = "Employee log in to account")
	public void employeeLoginTest() {
		loginPage.loginToUserAccount(propertiesUtil.getemail(), propertiesUtil.getpassword());
		dashboardPage.clickOnProfileIconIcon();
		String username = dashboardPage.getUsername();
		Assert.assertEquals("Dipak Bhagat", username);
	}

	@Test(testName = "employee Check In")
	public void employeeAttendanceCheckInTest() {
		loginPage.loginToUserAccount(propertiesUtil.getemail(), propertiesUtil.getpassword());
		dashboardPage.clickCheckInBtn();
	}
	
	@Test(testName = "employee Check Out")
	public void employeeAttendanceCheckOutTest() {
		loginPage.loginToUserAccount(propertiesUtil.getemail(), propertiesUtil.getpassword());
		dashboardPage.clickCheckOutBtn();
	}

}
