package com.acti.base;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverScript 
{
	public static WebDriver driver;
	Properties prop;
	
//	constructor
	public DriverScript()
	{
		try
		{
			File fil = new File("./atconfig/config.properties");
			FileInputStream fis = new FileInputStream(fil);
			prop = new Properties();
			prop.load(fis);
		}
		catch(Exception e)
		{
			e.printStackTrace();
//			System.out.println("Unable to load the properties file. Please check." + e.getMessage());
			System.err.println("Unable to load the properties file. Please check." + e.getMessage());
		}
	}
	
	public void initApplication()
	{
		String browser = prop.getProperty("browser");
		
		if (browser.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "./atbrowser/chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("edge"))
		{
			System.setProperty("webdriver.edge.driver", "./atbrowser/msedgedriver.exe");
			driver =new EdgeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "./atbrowser/geckodriver.exe");
			driver = new FirefoxDriver();
		}
		else
		{
//			System.out.println("Please provide valid browser name");
			System.err.println("Please provide valid browser name");
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		launchURL();
	}
	
	public void launchURL()
	{
		String url = prop.getProperty("url");
		driver.get(url);
	}
	
	public static void quitDriver()
	{
		driver.quit();
	}
}