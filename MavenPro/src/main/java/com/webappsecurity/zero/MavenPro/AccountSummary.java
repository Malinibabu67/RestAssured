package com.webappsecurity.zero.MavenPro;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountSummary {
	@FindBy(linkText="Transfer Funds")
	private WebElement tfunds;
	
	 public AccountSummary(WebDriver driver) {
	    	PageFactory.initElements(driver, this);
	    }
	    
	public void clickTransferFunds() {
		tfunds.click();
	}
    
	public boolean  istransferlinkavailable() {
		boolean transferlinkpresent = tfunds.isDisplayed();
		return transferlinkpresent;
	
	}
}
