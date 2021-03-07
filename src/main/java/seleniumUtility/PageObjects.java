package seleniumUtility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import driverInfo.BaseDriver;

public class PageObjects  extends BaseDriver {

		
	public WebElement getGoButtonXpath() {
		return driver.findElement(By.xpath("//button[@id='gobutton']"));
	}
	
	public WebElement getOperandOne() {
		return driver.findElement(By.xpath("//form/input"));
	}
	
	public WebElement getOperandTwo() {
		return driver.findElement(By.xpath("//form/input[2]"));
	}
	
	public WebElement getDropdown() {
		return driver.findElement(By.xpath("//form/select"));
	}
	
	public WebElement getResult() {
		return driver.findElement(By.xpath("//form/h2"));
	}
	
}
