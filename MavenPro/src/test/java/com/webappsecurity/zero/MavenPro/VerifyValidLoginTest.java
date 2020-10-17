package com.webappsecurity.zero.MavenPro;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



public class VerifyValidLoginTest extends BaseClass {
	
    @Test
    public void verifyValidLogin() {
    	Login lg = new Login(driver);
    	AccountSummary acc = new AccountSummary(driver);
   
    	lg.applicationLogin("username","password");
    	boolean istransferpresent= acc.istransferlinkavailable();
    	Assert.assertTrue(istransferpresent);
    }

}