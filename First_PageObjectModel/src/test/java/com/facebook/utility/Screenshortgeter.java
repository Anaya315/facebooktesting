package com.facebook.utility;
import java.io.*;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.apache.commons.*;

public class Screenshortgeter {
	
	public static String gttingscreenshot(WebDriver driver)
	{
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String screenshotpath = System.getProperty("user.dir") + "/Screenshort/facebook_"+ dateformate() + ".png";
		try {
			
	
		FileHandler.copy(src, new File(screenshotpath));
		}
		catch(Exception e)
		{
			System.out.println("status has been failiuer");
		}
		
		return screenshotpath;
	}
	
	public static String dateformate()
	{
		DateFormat customedateformate = new SimpleDateFormat("MM-dd-yyyy-HH-mm-ss");
		Date currentdateformate = new Date();
		return customedateformate.format(currentdateformate);
		
	}


}
