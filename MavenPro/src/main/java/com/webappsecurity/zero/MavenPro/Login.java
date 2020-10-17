package com.webappsecurity.zero.MavenPro;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {
	
    @FindBy(id="user_login")
    private WebElement uname;
    
    @FindBy(id="user_password")
    private WebElement pass;
    
    @FindBy(name="submit")
    private WebElement signin;
    
    @FindBy(css="#login_form > div.alert.alert-error")
    private WebElement invalid;
    
    public Login(WebDriver driver) {
    	PageFactory.initElements(driver, this);
    }
    
    public void applicationLogin(String Loginname, String Logpass) {
    	uname.sendKeys(Loginname);
    	pass.sendKeys(Logpass);
    	signin.click();
    }
    
    public String invaliderror() {
    	String errormsg = invalid.getText();
    	return errormsg;
    }
}

