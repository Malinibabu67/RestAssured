package com.webappsecurity.zero.Testscripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.webappsecurity.zero.pages.AccountSummary;
import com.webappsecurity.zero.pages.Login;
import com.webappsecurity.zero.pages.TransferFundsConfirmationPage;
import com.webappsecurity.zero.pages.TransferFundsPage;
import com.webappsecurity.zero.pages.TrasnferFundsVerifyPage;

public class verifyFundTransferTest extends BaseClass {

	@Test
    public void fundTransfer() {
    	Login log =new Login(driver);
    	AccountSummary accsum = new AccountSummary(driver);
    	TransferFundsPage tfp = new TransferFundsPage(driver);
    	TrasnferFundsVerifyPage tfpver = new TrasnferFundsVerifyPage(driver);
    	TransferFundsConfirmationPage tcpage = new TransferFundsConfirmationPage(driver);    	 	
    	
    	log.applicationLogin("username","password");
    	accsum.clickTransferFunds();
    	tfp.transferFunds("250", "For Test");
    	tfpver.clciksubmit();
    	String actualPage = tcpage.getconfig();
    	String expectedPage = "You successfully submitted your transaction.";
    	Assert.assertEquals(actualPage, expectedPage);
    }
	
}