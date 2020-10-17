package demo1;

import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ScreenShot {

	WebDriver driver;
	@BeforeTest	
	public void openApplication() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver =new ChromeDriver();
		driver.get("http://zero.webappsecurity.com/login.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	@Test
	public void verifyFundTransfer() throws IOException {
		try {
			driver.findElement(By.id("user_login")).sendKeys("username1");
			driver.findElement(By.id("user_password")).sendKeys("password");
			driver.findElement(By.name("submit")).click();
			driver.findElement(By.linkText("Transfer Funds")).click();
			driver.findElement(By.id("tf_amount")).sendKeys("1000");
			driver.findElement(By.id("btn_submit")).click();
			driver.findElement(By.id("btn_submit")).click();
			String actualSuccess= driver.findElement(By.cssSelector("#transfer_funds_content > div > div > div.alert.alert-success")).getText();
			String expectedsuccess = "You successfully submitted your transaction.";
			Assert.assertEquals(actualSuccess, expectedsuccess);
		}
		catch (Exception ex) {
			takeScreenshot();
			Assert.fail("Test failed :" + ex);
		}
	}
	private void takeScreenshot() throws IOException {
		File ss = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(ss, new File("D:\\sel\\screenshot"+(new Random().nextInt())+".jpg"));
	}

	@AfterTest
	public void closeApplication() {
		driver.close();
	}
}
