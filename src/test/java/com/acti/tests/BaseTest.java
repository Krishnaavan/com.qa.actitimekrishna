package com.acti.tests;

import java.io.IOException;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

import com.acti.base.DriverScript;
import com.acti.pages.EnterTimePage;
import com.acti.pages.LoginPage;
import com.acti.pages.TaskListPage;
import com.acti.utis.ExcelLib;
import com.acti.utis.Helper;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;


public class BaseTest extends DriverScript
{
	LoginPage lp;
	EnterTimePage etp;
	TaskListPage tlp;
	ExtentReports report;
	ExtentTest logger;
	
	@BeforeSuite
	public void setReport()
	{
		report = new ExtentReports();
		ExtentHtmlReporter extent = new ExtentHtmlReporter("./atreports/actiindex.html");
		report.attachReporter(extent);
	}
	
	@BeforeMethod
	public void setUp()
	{
		initApplication();
		lp = new LoginPage();
		etp = new EnterTimePage();
		tlp = new TaskListPage();
	}
	
	@AfterMethod
	public void tearDown(ITestResult result) throws IOException
	{
		if(result.getStatus()==ITestResult.FAILURE)
		{
			logger.fail("Failed at this step", 
					MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
		}
		quitDriver();
		Helper.FnSleep();
		report.flush();
	}
	
	@DataProvider(name = "actiData")
	public Object testData()
	{
		ExcelLib lib = new ExcelLib("./atdata/actidata.xlsx");
		int rows = lib.getRowCount(0);
		Object[][] data = new Object[rows][2];
		for (int i=0; i<rows; i++)
		{
			data[i][0] = lib.getCellData(0, i, 0);
			data[i][1] = lib.getCellData(0, i, 1);
		}
		return data;
	}
}
