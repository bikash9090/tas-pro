package com.taspro.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.taspro.base.TestBase;
import com.taspro.pages.LoginPage;
import com.taspro.utility.PropertiesUtil;

public class LoginPageTest extends TestBase {

	LoginPage lpagloginpageObj;


	@BeforeMethod
	public void openBrowser() {
		initiDriver();
		lpagloginpageObj = new LoginPage(driver);
		
		
	}
	
	@AfterMethod
	public void closeBrowser() {
		driver.quit();
	}

	@Test
	public void loginFunTest() {
		lpagloginpageObj.loginToUserAccount(readpropobj.getemail(),readpropobj.getpassword());
	}

	@Test
	public void validateforgotpasswordlink() {
		lpagloginpageObj.clickOnForgotPassword();
	}
	

}
