package com.webappsecurity.zero.MavenPro;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TrasnferFundsVerifyPage {
	
	@FindBy(id="btn_submit")
	private WebElement submit;
	
	 public TrasnferFundsVerifyPage(WebDriver driver) {
	    	PageFactory.initElements(driver, this);
	    }
	
	public void clciksubmit() {
		submit.click();
	}

}
