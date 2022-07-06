package com.acti.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.acti.base.DriverScript;

public class EnterTimePage extends DriverScript
{
	//Creating object references for Page elements
	@FindBy(xpath = "//a[@class='userProfileLink username ']") WebElement txtLnkUsrName;
	@FindBy(id = "logoutLink") WebElement lnkLogout;
	@FindBy(xpath="//a[@class='content tasks']") WebElement menuTask;
	
	//Constructor
	public EnterTimePage()
	{
		PageFactory.initElements(driver, this);
		System.out.println("test for pushing from local to remote git");
		System.out.println("test2 for pushing from local to remote git");
	}
	
	//methods
	public void clickTask()
	{
		menuTask.click();
	}
	
	public void clickLogout()
	{
		lnkLogout.click();
	}
	
	public String verifyUserLogged()
	{
		return txtLnkUsrName.getText();
	}
}
