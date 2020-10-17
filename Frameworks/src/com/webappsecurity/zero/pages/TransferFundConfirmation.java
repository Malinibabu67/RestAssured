package com.webappsecurity.zero.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TransferFundConfirmation {
	
	@FindBy(css="#transfer_funds_content > div > div > div.alert.alert-success")
	private WebElement transmsg;
	
	@FindBy(css="#settingsBox > ul > li:nth-child(3) > a")
	private WebElement uname;
	
	@FindBy(id="logout_link")
	private WebElement logout;
	
	public TransferFundConfirmation(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public String getmesssage() {
		String transuccessmessage = transmsg.getText();
		return transuccessmessage;
	}
	
	public void logoutfromApplication() {
		uname.click();
		logout.click();
	}

}
