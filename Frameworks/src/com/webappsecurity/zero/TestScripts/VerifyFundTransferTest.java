package com.webappsecurity.zero.TestScripts;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.webappsecurity.zero.pages.AccountSummary;
import com.webappsecurity.zero.pages.Login;
import com.webappsecurity.zero.pages.TransferFundConfirmation;
import com.webappsecurity.zero.pages.TransferFundsPage;
import com.webappsecurity.zero.pages.TransferFundsVerify;

import Utilis.GenericMethods;

public class VerifyFundTransferTest {
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
	public void verifyFundTrasnfer() throws IOException {
		Login lg = new Login(driver);
		AccountSummary acc = new AccountSummary(driver);
		TransferFundsPage tf = new TransferFundsPage(driver);
		TransferFundsVerify tfv = new TransferFundsVerify(driver);
		TransferFundConfirmation tfc = new TransferFundConfirmation(driver);
			
		String[][] data = GenericMethods.getData("C:\\Users\\Malini\\Desktop\\Selenium\\TestData\\Testdata_sample.xlsx", "Sheet1");
		
		for (int i=1;i<data.length;i++) {
		
		lg.applicationLogin(data[i][0], data[i][1]);
		acc.clickTransferFunds();
		tf.fundTrasnfer(data[i][2], data[i][3]);
		tfv.clickSubmit();
		String actualMessage = tfc.getmesssage();
		String expectedMessage =data[i][4];
		Assert.assertEquals(actualMessage, expectedMessage);
		tfc.logoutfromApplication();
		driver.get("http://zero.webappsecurity.com/login.html");
		}
	}
	
}
