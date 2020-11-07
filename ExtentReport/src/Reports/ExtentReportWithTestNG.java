package Reports;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportWithTestNG {
	
	ExtentSparkReporter Spark ;
	ExtentReports reports;
	
	
    WebDriver driver;

	@BeforeSuite
	public void setUp() {
		ExtentSparkReporter Spark = new ExtentSparkReporter(System.getProperty("user.dir") + "/test-output/extentreports.html");
		ExtentReports reports = new ExtentReports();
		reports.attachReporter(Spark);
	}
	@BeforeTest
	
	public void setUpTest() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver =new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
	}
	@Test
	public void test1() throws Exception {
		ExtentTest test = reports.createTest("MyFirstTest", "Test Deatils");
		driver.get("https://www.google.com/");
		test.pass("Navigated to Google.com");
		driver.findElement(By.name("q")).sendKeys("Automation");
		test.pass("Entered in searchBox");
		driver.findElement(By.name("btnK")).submit();
		test.pass("Pressed Entered key");
		test.log(Status.INFO, "This steps shows usage of log(Status, details)");
		test.info("This steps shows usage of info(details)");
		test.fail("details", MediaEntityBuilder.createScreenCaptureFromPath("Screenshot.png").build());
		test.addScreenCaptureFromPath("Screenshot.png");
	}
	public void test2() throws Exception {
		ExtentTest test2 = reports.createTest("My FIRST Test", "Test Deatils");
		test2.log(Status.INFO, "This steps shows usage of log(Status, details)");
		test2.info("This steps shows usage of info(details)");
		test2.pass("details", MediaEntityBuilder.createScreenCaptureFromPath("Screenshot.png").build());
		test2.addScreenCaptureFromPath("Screenshot.png");	
	}
	@AfterTest
	
	public void tearDownTest() {
		driver.close();
		driver.quit();
	}
	@AfterSuite
	public void tearDown() {
		reports.flush();

	}

}
