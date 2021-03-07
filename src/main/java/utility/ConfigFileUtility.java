package utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import driverInfo.BaseDriver;

public class ConfigFileUtility {

	public Properties prop;
	public FileInputStream fileInput;
	
	public ConfigFileUtility() {
		try {
			fileInput = new FileInputStream("D:\\eclipseWorkspace\\DataDrivenFramework\\src\\test\\resources\\config.properties");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		prop = new Properties();
		try {
			prop.load(fileInput);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}



	public String getDriverPath(){
		String driverPath = prop.getProperty("Driverpath");
		if(driverPath!= null) return driverPath;
		else throw new RuntimeException("driverPath not specified"); 
	}
	
	public String getURL(){
		String url = prop.getProperty("URL");
		if(url!= null) return url;
		else throw new RuntimeException("url not specified"); 
	}
	
	public String getDataFilePath(){
		String dataFilePath = prop.getProperty("DataFilePath");
		if(dataFilePath!= null) return dataFilePath;
		else throw new RuntimeException("dataFilePath not specified"); 
	}
	
	public void configureLogs() throws Exception {
		Properties props = new Properties();
		props.load(getClass().getClassLoader().getResourceAsStream("log4j.properties"));
		PropertyConfigurator.configure(props);
		BasicConfigurator.configure();
	}



}
