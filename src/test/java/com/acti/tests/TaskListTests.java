package com.acti.tests;

import org.testng.annotations.Test;

import com.acti.utis.Helper;

public class TaskListTests extends BaseTest
{
	@Test(priority=1)
	public void testCreateCustomer()
	{
		logger = report.createTest("Validate Create Customer");
		lp.enterUsername("admin");
		logger.pass("Entered User name");
		lp.enterPassword("manager");
		logger.pass("Entered Password");
		lp.clickLogin();
		logger.pass("Clicked Login button");
		etp.clickTask();
		logger.pass("Clicked Task menu item");
		tlp.clickAddNew();
		logger.pass("Clicked Add New");
		tlp.selectNewCustomer();
		logger.pass("Selected option New Customer");
		tlp.enterCustomerName("TestNameKrishna");
		logger.pass("Entered Customer Name");
		tlp.enterCustDesc("Test DescKrishna");
		logger.pass("Entered Customer Description");
		tlp.createCustomer();
		logger.pass("Clicked Create Customer button");
		Helper.FnSleep();
		System.out.println(tlp.customerCreatedConfirmationMsg());
		logger.pass("Customer Created Toast message displayed?");
		etp.clickLogout();
		logger.pass("Clicked Logout");
	}
	
	@Test(priority=2)
	public void testDeleteCustomer()
	{
		lp.enterUsername("admin");
		lp.enterPassword("manager");
		lp.clickLogin();
		etp.clickTask();
		tlp.searchCustomer("TestNameKrishna");
		tlp.clickCustomer();
		tlp.clickSettings();
		Helper.FnSleep();
		tlp.clickActions();
		tlp.clickDelete();
		tlp.clickDeletePermanently();
		Helper.FnSleep();
		etp.clickLogout();
	}
}
