package com.webappsecurity.zero.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class TransferFundsPage {
	@FindBy(id="tf_fromAccountId")
	private WebElement fromAccount;
	
	@FindBy(id="tf_toAccountId")
	private WebElement toAccount;
	
	@FindBy(id="tf_amount")
	private WebElement amt;
	
	@FindBy(id="tf_description")
	private WebElement desc;
	
	@FindBy(id="btn_submit")
	private WebElement contbut;
	
	public TransferFundsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void fundTrasnfer(String Amount, String Description) {
		Select fa = new Select(fromAccount);
		fa.selectByIndex(1);
		
		Select ta = new Select(toAccount);
		ta.selectByIndex(2);
		
		amt.sendKeys(Amount);
		desc.sendKeys(Description);
		contbut.click();
		
	}
}
