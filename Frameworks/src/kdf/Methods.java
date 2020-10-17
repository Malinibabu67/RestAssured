package kdf;

import java.util.concurrent.TimeUnit;

import javax.xml.crypto.Data;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Methods {
	
	WebDriver driver;
	public void openBrowser() {
		driver = new ChromeDriver();
	}
    
	public void maxBrowserWindow() {
		driver.manage().window().maximize();
		
	}
	
	public void implicitwait() {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	public void navigateToApplicationURL (String url) {
		driver.get(url);
		
	}
	
	public void enterUserId(String locatorvalue, String Userid) {
		driver.findElement(By.id(locatorvalue)).sendKeys(Userid);
	}
	
	public void enterpassword (String locatorvalue, String pwd) {
		driver.findElement(By.id(locatorvalue)).sendKeys(pwd);
	}
	
	public void clickbutton(String locator, String locatorvalue) {
		if(locator.equals("name")) {
		driver.findElement(By.name(locatorvalue)).click();
		}
		else if(locator.equals("xpath")) {
		driver.findElement(By.xpath(locatorvalue)).click();	
		}
	}
	
	public String verifyerrormsg(String locator, String locatorValue) {
		String msg = null;
		if(locator.equals("cssSelector")) {
		msg = driver.findElement(By.cssSelector(locatorValue)).getText();
		}
		else if(locator.equals("id")) { 
		msg = driver.findElement(By.id(locatorValue)).getText();	
		}
		return msg;
	}
	
	public void closeBrowser() {
		driver.close();
	}
}
