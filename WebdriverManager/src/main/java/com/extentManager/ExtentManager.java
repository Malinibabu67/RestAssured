package com.extentManager;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {

	public static ExtentSparkReporter sparkReporter;
	public static ExtentReports extent;       
	public static ExtentTest test; 


	public static void setExtent() {

		sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir")+"/test-output/ExtentReport/MyReport.html");
		sparkReporter.config().setDocumentTitle("Automation Test Report");
		sparkReporter.config().setReportName("OrangeHRM Test Automation Report");
		sparkReporter.config().setTheme(Theme.DARK);

		extent = new ExtentReports();
		extent.attachReporter(sparkReporter);
		extent.setSystemInfo("HostName", "My host name");
		extent.setSystemInfo("OS", "Windows10");
		extent.setSystemInfo("TesterName", "Malini");
		extent.setSystemInfo("ProjectName", "OrangeHRM");
		extent.setSystemInfo("Browser", "Chrome");
	}

	public static void endReport() {
		extent.flush();
	}
}
