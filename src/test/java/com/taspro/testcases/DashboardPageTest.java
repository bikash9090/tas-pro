package com.taspro.testcases;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.taspro.base.TestBase;
import com.taspro.pages.DashboardPage;
import com.taspro.pages.LoginPage;
import com.taspro.utility.PropertiesUtil;



public class DashboardPageTest extends TestBase {
	
	LoginPage LoginPageObj;
	PropertiesUtil PropertiesUtilObj;
	DashboardPage DashboardPageObj;

	/*------------------------------------------------BeforClass initialization----------------------------------------------*/
	@BeforeMethod
	public void initialization() {
		launchWebSite();
	 LoginPageObj = new LoginPage(driver);
	 PropertiesUtilObj = new PropertiesUtil();
	 DashboardPageObj = new DashboardPage(driver);
	}
	
	/*------------------------------------------------Closing the browser after the test ----------------------------------------------*/
	@AfterMethod
	public void close() {
		tearDown();
	}
	/*------------------------------------------------TESTCASES----------------------------------------------*/
	
	@Test
	public void ToVerifyTheLogedUser() {
		 LoginPageObj.loginToUserAccount(PropertiesUtilObj.getemail(), PropertiesUtilObj.getpassword());
		 DashboardPageObj.clickOnProfileIconIcon();
		 String username = DashboardPageObj.getUsername();
		 Assert.assertEquals("Dipak bhagat", username);
		
	}
	
	@Test
	public void ToVerifyCheckInbutton() {
	
		 LoginPageObj.loginToUserAccount(PropertiesUtilObj.getemail(), PropertiesUtilObj.getpassword());
	   
		  Map<String, String> result = DashboardPageObj.clickCheckInButton();
		 
		// Assertion
	        String beforeClickText = result.get("beforeClick");
	        String afterClickText = result.get("afterClick");
	        
	        
	        System.out.println("Before Click Text: " + beforeClickText);
	        System.out.println("After Click Text: " + afterClickText);

	        // Example assertion, modify it based on your actual use case
	        Assert.assertNotEquals(beforeClickText, afterClickText, "Check-in button text should change after clicking");
		  
		 
		 
		
	}
	
	
	
	
	
}
	
	
