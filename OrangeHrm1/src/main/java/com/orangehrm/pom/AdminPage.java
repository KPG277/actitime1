package com.orangehrm.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.orangehrm.generic.BaseClass;

public class AdminPage{
	
	
	@FindBy(id="menu_admin_Organization")
	private WebElement orgnizationDropDown;
	
	@FindBy(id="menu_admin_viewOrganizationGeneralInformation")
	private WebElement InfOrgnization;
	
	@FindBy(id="btnSaveGenInfo")
	private WebElement editbtn;
	
	@FindBy(id="organization_name")
	private WebElement OrganizationTbx;
	
	@FindBy(id="organization_email")
	private WebElement emailTbx;
	
	@FindBy(id="btnSaveGenInfo")
	private WebElement saveBtn;
	
	public  AdminPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getOrgnizationDropDown() {
		return orgnizationDropDown;
	}

	public WebElement getInfOrgnization() {
		return InfOrgnization;
	}
public WebElement getEditBtn() {
	return editbtn;
}
	public WebElement getOrgnizationTbx() {
		return OrganizationTbx;
	}
	public WebElement getEmailTbx() {
		return emailTbx;
	}

	public WebElement getSavebtn() {
		return saveBtn;
	}
}
