package com.taspro.listeners;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.taspro.base.Constants;

public class ExtentReportManager {
	
	public static ExtentReports extentReport;
	
	public static ExtentReports initReport() {

		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date()); // Formating the date stamp.
		Path path = Paths.get(Constants.REPORT_OUTPUT_FOLDER); // Set up output folder for report file generation.
		String reportName = Constants.REPORT_NAME + timeStamp + ".html"; // Unique report name on every run of test script.

		if (!Files.exists(path)) {
			try {
				Files.createDirectories(path);
			} catch (IOException e) {
				System.out.println("Failed! to create directory.");
				e.printStackTrace();
			}
		}

		extentReport = new ExtentReports();
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter(Constants.REPORT_OUTPUT_FOLDER + reportName);
		sparkReporter.config().setDocumentTitle(Constants.REPORT_NAME);
		sparkReporter.config().setTheme(Theme.DARK);

		extentReport.attachReporter(sparkReporter);
		extentReport.setSystemInfo("Customer Name", Constants.CUSTOMER_NAME);
		extentReport.setSystemInfo("Application", Constants.APPLICATION);
		extentReport.setSystemInfo("Operating System", Constants.OPERATING_SYSTEM);
		extentReport.setSystemInfo("User Name", Constants.USER_NAME);
		extentReport.setSystemInfo("Environemnt", Constants.ENVIRONMENT);
		extentReport.setSystemInfo("Build#", Constants.BUILD);
		extentReport.setSystemInfo("Team", Constants.TEAM);

		return extentReport;
	}
}
