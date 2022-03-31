package com.acti.utis;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import com.acti.base.DriverScript;

public class Helper extends DriverScript 
{
	public static void FnSleep() 
	{
		try
		{
		Thread.sleep(3000);
		}
		catch(InterruptedException e)
		{
			e.printStackTrace();
		}
	}
	
	public static String captureScreenshot(WebDriver driver)
	{
		//1. Typecast the takesscreenshot to webdriver type.
		//2. Give the path where you want to screenshotnto be present.
		//3. Copy src to dest using FileHandler from Selenium
		//4. Return the path of the screenshot 
				
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String screenPath = "C:\\Datas\\Krishna\\Academic\\Jobprep2021\\SeleniumJava-H2kinfosys\\Workspace\\com.qa.actitime\\atreports\\screenshots\\screen.png";
		try
		{
			FileHandler.copy(src, new File(screenPath));
		
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		return screenPath;
	}
}
