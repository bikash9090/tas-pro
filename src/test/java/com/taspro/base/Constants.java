package com.taspro.base;

public class Constants {
	
	
	
	public static final String USER_DIR = System.getProperty("user.dir");
	public static final String SCREENSHOT_DIR = USER_DIR+"\\Screenshots\\";
	public static final String EXCEL_PATH = USER_DIR+"\\src\\test\\resources\\TAS-2_Employee_data.xlsx";
	public static final String PROPERTIES_FILE_PATH = USER_DIR+"\\src\\test\\resources\\config.properties";
	public static final long IMPLICIT_WAIT = 30;
	public static final long EXPLICIT_WAIT=20;
	public static final String REPORT_OUTPUT_FOLDER = ".\\reports\\";
	public static final String REPORT_NAME = "TAS-Pro-test-report";
	
	//----------------------Report initialization data------------------------//
	public static final String DOCUMENT_TITLE = "TAS-Pro Automation report";
	public static final String CUSTOMER_NAME = "American Client";
	public static final String APPLICATION = "TAS-Pro";
	public static final String OPERATING_SYSTEM = System.getProperty("os.name");
	public static final String USER_NAME = System.getProperty("user.name");
	public static final String ENVIRONMENT = "QA";
	public static final String BUILD = "1.0";
	public static final String TEAM = "TAS-Pro Automation Team";

}
