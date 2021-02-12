package com.orangehrm.testscripts;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.orangehrm.generic.BaseClass;
import com.orangehrm.generic.FileLib;
import com.orangehrm.pom.AdminPage;
import com.orangehrm.pom.HomePage;


@Listeners(com.orangehrm.generic.ListenerImplimentation.class)
public class OrganizationModule extends BaseClass {
@Test
public void testOrangeHrm() throws EncryptedDocumentException, IOException, InterruptedException, InvalidFormatException {
	Reporter.log("Edit Organization", true);
	Actions a=new Actions(driver);
	FileLib f=new FileLib();
	String OrganizationName = f.getExcelValue("EditOrgnization", 1, 1);
	Thread.sleep(1000);
	String email = f.getExcelValue("EditOrgnization", 2, 1);
	Thread.sleep(1000);
	HomePage hp=new HomePage(driver);
	AdminPage ap=new AdminPage(driver);
	//mouse hover to admin dropdown
	w.mouseHover(driver, hp.getAdminDropDown());
	//mouse hover to organization drop down
	w.mouseHover(driver, ap.getOrgnizationDropDown());
	//click on InformationOrgnaization
	ap.getInfOrgnization().click();
	//Click on edit Button
	ap.getEditBtn().click();
	//
	ap.getOrgnizationTbx().clear();
	ap.getOrgnizationTbx().sendKeys(OrganizationName);
	ap.getEmailTbx().clear();
	ap.getEmailTbx().sendKeys(email);
	ap.getSavebtn().click();
	String actual = ap.getOrgnizationTbx().getAttribute("value");
	Assert.assertEquals(actual, OrganizationName );
}
}
