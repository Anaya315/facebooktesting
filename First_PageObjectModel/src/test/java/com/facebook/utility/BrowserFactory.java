package com.facebook.utility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BrowserFactory {
	
	public static WebDriver startapplication(WebDriver driver , String browsername , String url)
	{
		if(browsername.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver","E:\\madhavi\\MukeshOtwani\\First_PageObjectModel\\Drivers\\chromedriver.exe");
			driver = new ChromeDriver();
			
		}
		else if (browsername.equals("FireFox"))
		{
			System.setProperty("webdriver.gecko.driver","E:\\madhavi\\MukeshOtwani\\First_PageObjectModel\\Drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
			
		}
		else if(browsername.equals("InternetExplorer"))
		{
			System.setProperty("webdriver.ie.driver","E:\\madhavi\\MukeshOtwani\\First_PageObjectModel\\Drivers\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			
		}
		else
		{
			System.out.println("We can not support this browser");
		}
		driver.manage().window().maximize();
		
		driver.get(url);
		return driver;
	}
	
	public static void closebrowser(WebDriver driver)
	{
		driver.close();
	}

}
