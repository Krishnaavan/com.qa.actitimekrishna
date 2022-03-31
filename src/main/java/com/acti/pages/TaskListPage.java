package com.acti.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.acti.base.DriverScript;
/*
 * Developed By: Krishna
 * Reviewed By: Santosh
 * LastModified Date: 03-28-2022
 */
public class TaskListPage extends DriverScript
{
	//Creating object references for Page elements
	@FindBy(xpath="//div[text()='Add New']") WebElement btnAddNew;
	@FindBy(xpath="//div[@class='item createNewCustomer']") WebElement optNewCustomer;
	@FindBy(xpath ="//input[@class='inputFieldWithPlaceholder newNameField inputNameField']") WebElement txtCustName;
	@FindBy(xpath="//textarea[@placeholder='Enter Customer Description']") WebElement txtAreaCustDescription;
	@FindBy(xpath="//div[text()='Create Customer']") WebElement btnCreateCustomer;
	@FindBy(xpath="//span[@class='innerHtml']") WebElement tstmsgCustomerCreated;
	
	@FindBy(xpath="//input[@placeholder='Start typing name ...'][1]") WebElement txtSearchCustomer;
	@FindBy(xpath="//span[@class='highlightToken']") WebElement lnkCustomer;
	@FindBy(xpath="//div[@class='titleEditButtonContainer']//div[@class='editButton']") WebElement iconSettings;
	@FindBy(xpath="//div[@class='editCustomerPanelHeader']//div[@class='action'][normalize-space()='ACTIONS']") WebElement btnActions;
	@FindBy(xpath="//div[@class='taskManagement_customerPanel']//div[@class='title'][normalize-space()='Delete']") WebElement btnDelete;
	@FindBy(xpath="//span[normalize-space()='Delete permanently']") WebElement btnDeletePermanently;
	
//	@FindBy(xpath="//span[@class='innerHtml']") WebElement tstmsgCustomerDeleted;
	
	//Constructor
	public TaskListPage()
	{
		PageFactory.initElements(driver, this);
	}
		
	//methods
	public void clickAddNew()
	{
		btnAddNew.click();
	}
	public void selectNewCustomer()
	{
		optNewCustomer.click();
	}
	public void enterCustomerName(String CustomerName)
	{
		txtCustName.sendKeys(CustomerName);
	}
	public void enterCustDesc(String CustomerDesc)
	{
		txtAreaCustDescription.sendKeys(CustomerDesc);
	}
	public void createCustomer()
	{
		btnCreateCustomer.click();
	}
	public String customerCreatedConfirmationMsg()
	{
		return tstmsgCustomerCreated.getText();
	}
	public boolean isCustomerCreated()
	{
		return tstmsgCustomerCreated.isDisplayed();
	}
	
	public void searchCustomer(String customer)
	{
		txtSearchCustomer.sendKeys(customer);
	}
	public void clickCustomer()
	{
		lnkCustomer.click();
	}
	public void clickSettings()
	{
		iconSettings.click();
	}
	public void clickActions()
	{
		btnActions.click();
	}
	public void clickDelete()
	{
		btnDelete.click();
	}
	public void clickDeletePermanently()
	{
		btnDeletePermanently.click();
	}
}
