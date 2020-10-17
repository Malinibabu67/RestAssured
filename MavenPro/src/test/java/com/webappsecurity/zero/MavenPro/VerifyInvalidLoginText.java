package com.webappsecurity.zero.MavenPro;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



public class VerifyInvalidLoginText extends BaseClass {
		
	    @Test
	    public void verifyInValidLogin() {
	    	Login inval = new Login(driver);
	    	
	    	inval.applicationLogin("user11","pass11");
	    	String actualError = inval.invaliderror();
	    	String ExpectedError = "Login and/or password are wrong.";
	    	Assert.assertEquals(actualError, ExpectedError);
	   	}

}
