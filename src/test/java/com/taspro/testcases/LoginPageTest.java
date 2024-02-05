package com.taspro.testcases;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.taspro.base.TestBase;
import com.taspro.pages.LoginPage;

public class LoginPageTest extends TestBase {
	LoginPage lpagloginpageObj;
	
	
	
	
	
	/*------------------------------------------------BeforClass initialization----------------------------------------------*/
	@BeforeClass
	public void initilization() {
		launchWebSite();
		lpagloginpageObj = new LoginPage(driver);
	}
	/*------------------------------------------------Closing the browser after the test ----------------------------------------------*/
	@AfterClass
	public void close() {
		tearDown();
	}
	/*------------------------------------------------TESTCASES----------------------------------------------*/
	@Test
	public void loginFunTest() {

		lpagloginpageObj.loginToUserAccount(readpropobj.getemail(), readpropobj.getpassword());
	}

	@Test
	public void validateforgotpasswordlink() {
		lpagloginpageObj.clickOnForgotPassword();
	}
	
	
	
	

//	@Test
//	public void readexcel () {
//		ExcelUtil obj = new ExcelUtil();
//		String a[][]= obj.readExcel("empSheet");
//		for(int i=0;i<a.length;i++) {
//			for(int j=0;j<a[i].length;j++) {
//				System.out.print(a[i][j]+" ");
//			}
//			System.out.println();
//		}
//		
//	}
}