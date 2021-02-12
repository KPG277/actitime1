package com.orangehrm.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
@FindBy(id="txtUsername")
private WebElement untbx;

@FindBy(id="txtPassword")
private WebElement pwtbx;

@FindBy(id="btnLogin")
private WebElement lgbtn;

public LoginPage(WebDriver driver) {
	PageFactory.initElements(driver, this);
}
public void setLoginPage(String un, String pwd) {
	untbx.clear();
	pwtbx.clear();
	untbx.sendKeys(un);
	pwtbx.sendKeys(pwd);
	lgbtn.click();
}
}


