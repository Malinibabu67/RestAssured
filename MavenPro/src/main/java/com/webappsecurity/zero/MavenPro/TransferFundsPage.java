package com.webappsecurity.zero.MavenPro;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class TransferFundsPage {
	
	@FindBy(id="tf_fromAccountId")
	private WebElement fromaccount;
	
	@FindBy(id="tf_toAccountId")
	private WebElement toaccount;
	
	@FindBy(id="tf_amount")
	private WebElement amt;
	
	@FindBy(id="tf_description")
	private WebElement descr;
	
	@FindBy(id="btn_submit")
	private WebElement continuebutton;
	
	 public TransferFundsPage(WebDriver driver) {
	    	PageFactory.initElements(driver, this);
	    }
	
	public void transferFunds(String amount, String description) {
		Select facc = new Select(fromaccount);
		facc.selectByIndex(2);
		
		Select tacc = new Select(toaccount);
		tacc.deselectByIndex(3);
		
		amt.sendKeys(amount);
		descr.sendKeys(description);
		
		continuebutton.click();
	}
	

}
