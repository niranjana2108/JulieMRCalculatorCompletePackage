package seleniumUtility;

import driverInfo.BaseDriver;


public class DataMapper extends BaseDriver {
	
		
						
			public Object[][] dataMapperFunction(String caseType) throws Exception {
			if(caseType.contains("positive")) {
			ExcelRetrive.setExcelFile(configFileUtility.getDataFilePath(), "positivecases");
			} else {
			ExcelRetrive.setExcelFile(configFileUtility.getDataFilePath(), "negativecases");
			}
			return ExcelRetrive.getExcelData();
		
		
		
		
	}
		
	 
	 
	 
	

}
