package com.orangehrm.generic;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Generic Class for WebDriver Methods
 * @author Pooja
 *
 */
public class WebDriverCommonLib {
/**
 * Explicit wait for element is displayed or not 
 * @param driver
 * @param element
 */
public void waitForElement(WebDriver driver, WebElement element) {
	WebDriverWait wait =new WebDriverWait(driver, 10);
	wait.until(ExpectedConditions.invisibilityOf(element));
}
/**
 * implicit wait for element
 * @param driver
 */
public void waitForElementGui(WebDriver driver) {
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
}
/**
 * Custome wait for element is displayed or not
 * @param element
 */
public void customWait(WebElement element) {
	int i=0;
	while(i<100) {
		try {
			element.isDisplayed();
			break;
		}
		catch(NoSuchElementException e) {
			i++;
		}
	}
}
/**
 * select the option in the listbox by using index
 * @param element
 * @param i
 */
public void selectOption(WebElement element, int i) {
	Select s=new Select(element);
	s.selectByIndex(i);
}
/**
 * select the option in the listbox by visible text
 * @param element
 * @param text
 */
public void selectOption(WebElement element, String text) {
	Select s=new Select(element);
	s.selectByVisibleText(text);
}
/**
 * Mouse action
 * @param driver
 * @param element
 */

public void mouseHover(WebDriver driver, WebElement element) {
	Actions a=new Actions(driver);
	a.moveToElement(element).perform();
	
}
/**
 * right click on  mouse
 * @param driver
 * @param element
 */
public void rightClick(WebDriver driver, WebElement element) {
	Actions a=new Actions(driver);
	a.contextClick(element).perform();
	
}
 	
}


