package seleniumUtility;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelRetrive {


	private static XSSFSheet ExcelWSheet;
	private static XSSFWorkbook ExcelWBook;
	private static XSSFCell Cell;

	//This method is to set the File path and to open the Excel file
	//Pass Excel Path and SheetName as Arguments to this method
	public static void setExcelFile(String Path,String SheetName) throws Exception  {
		FileInputStream ExcelFile = new FileInputStream(Path);
		ExcelWBook = new XSSFWorkbook(ExcelFile);
		ExcelWSheet = ExcelWBook.getSheet(SheetName);
	}

	//This method is to read the test data from the Excel cell
	//In this we are passing parameters/arguments as Row Num and Col Num
	public static String getCellData(int RowNum, int ColNum) throws Exception{
		Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);
		String CellData = Cell.toString();
		return CellData;
	}
	

	
	public static int getRowCount() throws Exception{
		int RowNum = ExcelWSheet.getLastRowNum();
		return RowNum;
	}
	
	public static Object[][] getExcelData() {
		Object[][] data = null;
		try {
			data = new Object[getRowCount()][ExcelWSheet.getRow(0).getLastCellNum()];
			for (int i= 1 ; i <=getRowCount(); i++) {

				for (int j=0; j <ExcelWSheet.getRow(i).getLastCellNum(); j++) {
					  Cell = ExcelWSheet.getRow(i).getCell(j);
					  data[i-1][j] = Cell.toString();
						  
				}

			}
		} catch (Exception e) {
			
			e.printStackTrace();
		
		}
		return data;
	

		
	}

}
