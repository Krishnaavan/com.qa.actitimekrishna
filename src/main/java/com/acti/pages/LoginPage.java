package com.acti.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.acti.base.DriverScript;

//Made LogInPage as a child to the "DriverScript" class by using "extends"
public class LoginPage extends DriverScript
{
	//************Page Elements****************
	//	located and stored the page elements using FindBy annotation
	@FindBy(id="username") WebElement txtUName;
	@FindBy(name = "pwd") WebElement txtPwd;
	@FindBy(xpath = "//div[text()='Login ']") WebElement btnLogin;
	@FindBy(id = "toPasswordRecoveryPageLink") WebElement linkForgotPwd;
	
	//************Page Initialization**********
	//	Constructor
	public LoginPage()
	{
		//	Used the PageFactory to initialize the elements in the page
		PageFactory.initElements(driver, this);
	}
	//************Page Methods****************
	public void enterUsername(String username)
	{
		txtUName.sendKeys(username);
	}
	
	public void enterPassword(String password)
	{
		txtPwd.sendKeys(password);
	}
	
	public void clickLogin()
	{
		btnLogin.click();
	}
	
	public boolean verifyLinkForgotPassword()
	{
		return linkForgotPwd.isDisplayed();
	}

}
