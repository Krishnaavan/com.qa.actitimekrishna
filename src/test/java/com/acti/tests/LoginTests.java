package com.acti.tests;

import org.testng.annotations.Test;

import com.acti.utis.Helper;

public class LoginTests extends BaseTest
{
	@Test(dataProvider="actiData", priority=1)
	public void testLogin(String username, String password) 
	{
		logger = report.createTest("Validate Login Function");
		lp.enterUsername(username);
		logger.pass("Entered User name");
		lp.enterPassword(password);
		logger.pass("Entered Password");
		lp.clickLogin();
		logger.pass("Clicked Login button");
		String actualUsr = etp.verifyUserLogged();
		System.out.println(actualUsr);
		etp.clickLogout();
		logger.pass("Clicked Logout");
		Helper.FnSleep();
	}
	
//	@Test
//	public void testLoginFail() 
//	{
//		logger = report.createTest("Validate Login Function");
//		lp.enterUsername("admin");
//		logger.pass("Entered User name");
//		lp.enterPassword("manager");
//		logger.pass("Entered Password");
//		lp.clickLogin();
//		logger.pass("Clicked Login button");
//		String actualUsr = etp.verifyUserLogged();
//		Assert.assertTrue(actualUsr.contains("Krishna"));
//		etp.clickLogout();
//		logger.pass("Clicked Logout");
//		Helper.FnSleep();
//	}
	
//	@Test(priority=2)
//	public void testValidateForgotPwdLink() 
//	{
//		Boolean flag  = lp.verifyLinkForgotPassword();
//		System.out.println(flag);
//		Helper.FnSleep();
//	}

}
