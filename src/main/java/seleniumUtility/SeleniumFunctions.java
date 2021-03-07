package seleniumUtility;

import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import driverInfo.BaseDriver;

public class SeleniumFunctions extends BaseDriver {
	PageObjects po = new PageObjects();
	Logger logger = Logger.getLogger(SeleniumFunctions.class);
	
	public void openURL(String url){
		logger.debug("open url");
		driver.get(url);
	}
	
	public void clickGoButton() {
		logger.debug("click go button function entered");
		po.getGoButtonXpath().click();
	}
	
	public void sendOperandOne(String data) {
		logger.debug("enter operand 1 function entered");
		po.getOperandOne().sendKeys(data);
	}
	
	public void sendOperandTwo(String data) {
		logger.debug("enter operand 2 function entered");
		po.getOperandTwo().sendKeys(data);
	}
	
	public String getValue() {
		logger.debug("getvalue function entered");
		return po.getResult().getText();
	}
	
	public void selectDropdown(String operator) {
		logger.debug("selectDropdown function entered");
		Select dropdown = new Select(po.getDropdown());
		dropdown.selectByVisibleText(operator);
		
	}
	
	public void closeBrowser() {
		logger.debug("closeBrowser function entered");
		driver.quit();
		
	}
	
	public void seleniumWait() {
		logger.debug("seleniumWait function entered");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}
	
	
	

}
