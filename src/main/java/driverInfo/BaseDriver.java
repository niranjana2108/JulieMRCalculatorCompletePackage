package driverInfo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import utility.ConfigFileUtility;

public class BaseDriver {
	public static ConfigFileUtility configFileUtility = new ConfigFileUtility();
	public static WebDriver driver;
	static{

		//chrome driver
		System.setProperty("webdriver.chrome.driver", configFileUtility.getDriverPath());
		driver = new ChromeDriver();
	}

}
