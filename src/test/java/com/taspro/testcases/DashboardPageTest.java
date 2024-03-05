package com.taspro.testcases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
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
	Logger log;

	/*----------------------------------------BeforClass initialization----------------------------------------------*/
	@BeforeClass
	public void initialization() {
		launchWebSite();
		loginPage = new LoginPage(driver);
		propertiesUtil = new PropertiesUtil();
		dashboardPage = new DashboardPage(driver);
		 log  = LogManager.getLogger(ForgotPasswordTest.class.getName());
	}

	/*------------------------------------Closing the browser after the test ----------------------------------------*/
	@AfterClass
	public void close() {
		// tearDown();
	}
	/*--------------------------------------------TESTCASES----------------------------------------------*/

	@Test(testName = "Employee log in to account", priority=0)
	public void employeeLoginTest() {
		loginPage.loginToUserAccount(propertiesUtil.getemail(), propertiesUtil.getpassword());
		log.info("User logged in to Dashboard");
		dashboardPage.clickOnProfileIconIcon();
		log.info("User clicked on the profile icon");
		String username = dashboardPage.getUsername();
		log.info("Go the name of the logged user");
		Assert.assertEquals(username, "Dipak Bhagat");
		
		
	}

	@Test(testName = "employee Check In",priority=1)
	public void employeeAttendanceCheckInTest() {
		//loginPage.loginToUserAccount(propertiesUtil.getemail(), propertiesUtil.getpassword());
		dashboardPage.clickCheckInBtn();
		log.info("clicked the checkin button");
	}
	
	@Test(testName = "employee Check Out", priority=2)
	public void employeeAttendanceCheckOutTest() {
		//loginPage.loginToUserAccount(propertiesUtil.getemail(), propertiesUtil.getpassword());
		dashboardPage.clickCheckOutBtn();
		log.info("clicked the checkout button");
	}

}
