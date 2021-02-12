package com.orangehrm.generic;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.orangehrm.pom.HomePage;
import com.orangehrm.pom.LoginPage;



public class BaseClass {
	static {
		System.setProperty("webdriver.chrome.driver", "./src/main/resources/driver/chromedriver.exe");
	}
	public static WebDriverCommonLib w=new WebDriverCommonLib();
	public static WebDriver driver;
@BeforeClass
public void openBrowser() {
	driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
}
@BeforeMethod
public void login() throws IOException {
	FileLib l=new FileLib();
	String url = l.getPropertyValue("url");
	 String un = l.getPropertyValue("un");
	String pwd = l.getPropertyValue("pwd");
	driver.get(url);
	LoginPage lg=new LoginPage(driver);
	lg.setLoginPage(un, pwd);
}
@AfterMethod
public void logout() {
	HomePage hp=new HomePage(driver);
	hp.setlogout();
}
@AfterClass
public void closeBrowser() {
	driver.close();
}
}
