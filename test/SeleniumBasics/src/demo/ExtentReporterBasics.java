package ExtentReports;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterBasics {
	public static WebDriver driver;

	public static void main(String[] args) {

		ExtentSparkReporter Spark = new ExtentSparkReporter(System.getProperty("usr.dir") + "Sparks.html");

		// Create ExtentReports and attach reporter(s)

		ExtentReports extent = new ExtentReports();
		extent.attachReporter(Spark);

		//Create a toggle for given test, add all log events under test

		ExtentTest test = extent.createTest("GoogleSearch Test one", "This is a test to validate Google functionality");

		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		test.log(Status.INFO, "Test case starting");

		driver.get("https://www.google.com/");
		test.pass("Navigated to Google.com");

		driver.findElement(By.name("q")).sendKeys("Automation");
		test.pass("Entered in searchBox");
		driver.findElement(By.name("btnK")).click();
		test.pass("Pressed Entered key");

		driver.close();
		driver.quit();
		test.pass("Close the Browser");
		test.info("Test completed");

		extent.flush();


	}
}
