package com.orangehrm.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	@FindBy(xpath="//a[contains(text),'Welcome']")
	private WebElement userlogoutElement;
	
	@FindBy(xpath="//a[@href='/index.php/auth/logout']")
	private WebElement logoutlinkElement;
	
	@FindBy(xpath="//b[.='Admin']")
	private WebElement adminMenu;
	
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void setlogout() {
		
		userlogoutElement.click();
		
		logoutlinkElement.click();
	}
	
	public WebElement getAdminDropDown() {
		return adminMenu;
	}

}
