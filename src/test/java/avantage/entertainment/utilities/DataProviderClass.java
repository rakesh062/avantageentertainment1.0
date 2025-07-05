package avantage.entertainment.utilities;

import org.testng.annotations.DataProvider;

import avantage.entertainment.testcases.BaseClass;

public class DataProviderClass extends BaseClass {
	
	@DataProvider(name="loginData")
	
	public String [][] getLoginData(){
		
		String sheetName=propertiesReader.getProperty("loginDataSheetName");
		
		ExcelUtilityClass excelUtility=new ExcelUtilityClass(propertiesReader.getProperty("excelFilePath"));
		
		int totalRows= excelUtility.getRowCount(sheetName);
		int totalColoumns=excelUtility.getCellCount(sheetName,1);
		
		String loginData[][]=new String[totalRows][totalColoumns];
		
		for(int rowNum=1;rowNum<=totalRows;rowNum++) {
			for(int coloumnNum=0;coloumnNum<totalColoumns;coloumnNum++) {
				
				loginData[rowNum-1][coloumnNum] = excelUtility.getCellData(sheetName, rowNum, coloumnNum);
				
			}
		}
		
		return loginData;
		
	}

}
