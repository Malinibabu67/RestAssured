package com.webappsecurity.zero.MavenPro;

import org.testng.Assert;
import org.testng.annotations.Test;



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