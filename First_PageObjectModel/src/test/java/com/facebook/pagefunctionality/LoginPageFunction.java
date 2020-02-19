package com.facebook.pagefunctionality;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPageFunction 
{
	WebDriver driver;
	
	public LoginPageFunction(WebDriver ldriver)
	{
		this.driver=ldriver;
	}
	
	@FindBy(id="email") WebElement username;
	@FindBy(id = "pass") WebElement password;
	@FindBy(xpath ="//input[@type='submit']") WebElement login;
	
	public void LoginFeature(String uname, String Passwordfb)
	{
		username.sendKeys(uname);
		password.sendKeys(Passwordfb);
		login.click();
		
	}
}
