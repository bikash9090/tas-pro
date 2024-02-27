package com.taspro.testcases;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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
	
//	@Test
//	public void ToVerifyCheckInbutton() throws InterruptedException {
//	    LoginPageObj.loginToUserAccount(PropertiesUtilObj.getemail(), PropertiesUtilObj.getpassword());
//	    Thread.sleep(5000);
//
//	    // Find the element first
//	    WebElement checkin = driver.findElement(By.cssSelector(".scrollto.btn.btn-checkin.checkin.ng-star-inserted"));
//        WebElement checkout = driver.findElement(By.cssSelector(".scrollto.btn.btn-checkin.CheckOut.ng-star-inserted"));
//	    // Click on the element to trigger any necessary actions
//	    //element.click();
//	    //Thread.sleep(5000);
//
//	    // Use the element in getComputedStyle
//	    String script = "return window.getComputedStyle(arguments[0],'::before').getPropertyValue('content')";
//	    
//	    JavascriptExecutor js = (JavascriptExecutor) driver;
//	    String content = (String) js.executeScript(script, element);
//	    
//	    System.out.println(content);
//	    
//	}
	
	@Test
	public void clickandcheck() throws InterruptedException {
		LoginPageObj.loginToUserAccount(PropertiesUtilObj.getemail(), PropertiesUtilObj.getpassword());
		Thread.sleep(5000);
		
		System.out.println(DashboardPageObj.initalText());
		System.out.println(DashboardPageObj.finalText());
		
		
		
	
		
	}



	}


	   
		 
	        	
	
	 
	
	
	
	

	
	
