package com.facebook.pagefunctionality;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PagefunctionWithout_Framework
{
	static WebDriver driver;
	
	@BeforeMethod
	public static void setup()
	{
		System.setProperty("webdriver.chrome.driver","E:\\madhavi\\MukeshOtwani\\First_PageObjectModel\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.get("https://www.facebook.com/");
		
	}
	
	@Test
	public static void loginTest()
	{
		driver.findElement(By.id("email")).sendKeys("ektapripatel315@gmail.com");
		driver.findElement(By.id("pass")).sendKeys("test123456");
		driver.findElement(By.id("u_0_2")).click();
	}

	@AfterMethod
	public static void teardown()
	{
		driver.close();
	}
}
