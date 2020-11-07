package Reports;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportDemo {
	private static WebDriver driver;

	public static void main(String[] args) {

		ExtentSparkReporter SparkTest = new ExtentSparkReporter(System.getProperty("user.dir") + "/test-output/extentreports.html");

		// Create ExtentReports and attach reporter(s)

		ExtentReports extent = new ExtentReports();
		extent.attachReporter(SparkTest);

		//Create a toggle for given test, add all log events under test

		ExtentTest test = extent.createTest("GoogleSearch Test one", "This is a test to validate Google functionality");

		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		test.log(com.aventstack.extentreports.Status.INFO, "Test case Starting");

		driver.get("https://www.google.com/");
		test.pass("Navigated to Google.com");

		driver.findElement(By.name("q")).sendKeys("Automation");
		test.pass("Entered in searchBox");
		driver.findElement(By.name("btnK")).submit();
		test.pass("Pressed Entered key");

		driver.close();
		driver.quit();
		test.pass("Close the Browser");
		test.info("Test completed");

		extent.flush();


	}
}
