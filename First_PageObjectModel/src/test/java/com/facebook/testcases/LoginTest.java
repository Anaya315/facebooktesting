package com.facebook.testcases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.facebook.pagefunctionality.BaseClass;
import com.facebook.pagefunctionality.LoginPageFunction;
import com.facebook.utility.BrowserFactory;
import com.facebook.utility.ExcelDataReader;
import com.facebook.utility.Screenshortgeter;

public class LoginTest extends BaseClass {
	
	
	
	@Test
	public void BrowserTest() throws IOException 
	{
		logger = report.createTest("login to facebook");
		LoginPageFunction loginpage = PageFactory.initElements(driver,LoginPageFunction.class);
		logger.info("stating the application");
		loginpage.LoginFeature(excel.getstringdata("loginsheet", 0, 0), excel.getstringdata("loginsheet", 0, 1));
		Screenshortgeter.gttingscreenshot(driver);
		logger.pass("login success");
		
		
		
		/*
		without extent report we have to write only this line...
		LoginPageFunction loginpage = PageFactory.initElements(driver,LoginPageFunction.class);
		loginpage.LoginFeature(excel.getstringdata("loginsheet", 0, 0), excel.getstringdata("loginsheet", 0, 1));
		Screenshortgeter.gttingscreenshot(driver);
		
		 */
	}
	
	
}
