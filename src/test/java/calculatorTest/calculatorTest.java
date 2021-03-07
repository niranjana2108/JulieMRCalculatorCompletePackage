package calculatorTest;

import org.testng.annotations.Test;

import driverInfo.BaseDriver;
import seleniumUtility.DataMapper;
import seleniumUtility.SeleniumFunctions;
import utility.ConfigFileUtility;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import org.apache.log4j.Logger;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;

public class calculatorTest {
	SeleniumFunctions seleniumFunctions = new SeleniumFunctions();
	DataMapper dataMapper = new DataMapper();
	ConfigFileUtility configFileUtility = new ConfigFileUtility();
	static Logger logger = Logger.getLogger(calculatorTest.class.getName());
	
	@BeforeClass
	public void beforeClass() throws Exception {
		
		configFileUtility.configureLogs();
		seleniumFunctions.openURL(configFileUtility.getURL());
	}	

	@Test(dataProvider="positiveTestCaseData")
	public void calculatorPositiveValidation(String operand1,String operand2,String operator,String expectedValue) throws InterruptedException {
		logger.info("Entering postive test case");
		seleniumFunctions.sendOperandOne(operand1);
		Thread.sleep(2000);
		logger.info("Operand 1 entered");
		seleniumFunctions.sendOperandTwo(operand2);
		logger.info("Operand 2 entered");
		seleniumFunctions.seleniumWait();
		seleniumFunctions.selectDropdown(operator);
		logger.info("operator selected");
		Thread.sleep(2000);
		seleniumFunctions.clickGoButton();
		logger.info("Go button clicked");
		Thread.sleep(2000);
		
		
		Assert.assertEquals(expectedValue, seleniumFunctions.getValue());
		
	}
	
//	@Test
//	public void calculatorNegativeValidation(String operand1,String operand2,String operator,String expectedValue) {
//
//	}
	
	 @DataProvider(name="positiveTestCaseData")
		public Object[][]  positiveTestCaseData() throws Exception {
		  Object[][]  arrayObject = dataMapper.dataMapperFunction("positiveCase");
			return arrayObject;
		}
	 
	 @DataProvider(name="negativeTestCaseData")
		public Object[][]  negativeTestCaseData() throws Exception {
		  Object[][]  arrayObject = dataMapper.dataMapperFunction("negativeCase");
			return arrayObject;
		}

	 @AfterMethod 
	 public void takeScreenShotOnFailure(ITestResult testResult) throws IOException { 
	 	if (testResult.getStatus() == ITestResult.FAILURE) { 
	 		File scrFile = ((TakesScreenshot)BaseDriver.driver).getScreenshotAs(OutputType.FILE); 
	 		FileUtils.copyFile(scrFile, new File("D:\\eclipseWorkspace\\JulieMRCalculatorCompletePackage\\src\\test\\resources\\FailedScreenshots\\" + testResult.getName()+"_"+System.currentTimeMillis() +".jpg"));
	 	} 
	 }	



	@AfterClass
	public void afterClass() {
		seleniumFunctions.closeBrowser();
	}

}
