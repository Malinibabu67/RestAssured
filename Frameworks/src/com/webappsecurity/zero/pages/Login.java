package com.webappsecurity.zero.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {
	@FindBy(id="user_login")
	private WebElement Uname;
	
	@FindBy(id="user_password")
	private WebElement pass ;
	
	@FindBy(name="submit")
	private WebElement SignIn;
	
	public Login(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void applicationLogin(String loginname,String password) {
		Uname.sendKeys(loginname);
		pass.sendKeys(password);
		SignIn.click();		
	}
}
