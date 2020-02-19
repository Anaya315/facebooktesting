package com.facebook.pagefunctionality;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.facebook.utility.BrowserFactory;
import com.facebook.utility.ConfigDataReader;
import com.facebook.utility.ExcelDataReader;
import com.facebook.utility.Screenshortgeter;


public class BaseClass {
	
	public static WebDriver driver;
	public ExcelDataReader excel;
	public static ConfigDataReader config;
	public static ExtentReports report;
	public static ExtentTest logger;
	
	@BeforeSuite
	public void setupSuite() throws IOException 
	{
		Reporter.log("aplication try to launch the browser", true);
		 excel = new ExcelDataReader();
		 config = new ConfigDataReader();
		 ExtentHtmlReporter extent = new  ExtentHtmlReporter(new File(System.getProperty("user.dir") + "/Repoert/facebook+"+ Screenshortgeter.dateformate() +".html"));
		 report = new ExtentReports();
		 report.attachReporter(extent);
		 Reporter.log("aplication geting launch ", true);
	}
	
	@Parameters({"Browser" , "Url"})
	
	
	@BeforeClass
	public static void setup(String browser , String url)
	{
		Reporter.log("aplication try to start", true);
		//driver = BrowserFactory.startapplication(driver, config.getbrowserstring(), config.geturlstring());
		
		driver = BrowserFactory.startapplication(driver, browser, url);
		Reporter.log("aplication is strat", true);
	}
	
	@AfterClass
	public static void teardown()
	{
		BrowserFactory.closebrowser(driver);
	}

	@AfterMethod
	public static void teardownsetup(ITestResult result) throws IOException
	{
		if(result.getStatus()==ITestResult.FAILURE)
		{
			logger.fail("Test fail", MediaEntityBuilder.createScreenCaptureFromPath(Screenshortgeter.gttingscreenshot(driver)).build());
		}
		else if(result.getStatus()==ITestResult.SUCCESS)
		{
			logger.pass("Test pass", MediaEntityBuilder.createScreenCaptureFromPath(Screenshortgeter.gttingscreenshot(driver)).build());
		}
		
		report.flush();
	}
}
