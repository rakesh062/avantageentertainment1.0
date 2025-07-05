package avantage.entertainment.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtilityClass {
	
	public FileInputStream fileInputStream;
	public FileOutputStream fileOutputStream;
	public XSSFWorkbook workBook;
	public XSSFSheet sheet;
	public XSSFRow row;
	public XSSFCell cell;
	public CellStyle celllStyle;
	String excelFilePath;
	
	public ExcelUtilityClass(String excelFilePath) {
		this.excelFilePath=excelFilePath;
	}
	
	public int getRowCount(String sheetName) {
		int rowCount=0;
		
		try {
			fileInputStream=new FileInputStream(excelFilePath);
			workBook=new XSSFWorkbook(fileInputStream);
			sheet=workBook.getSheet(sheetName);
			rowCount=sheet.getLastRowNum();
			workBook.close();
			fileInputStream.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rowCount;
		
	}
	
	public int getCellCount( String sheetName, int rowNumber) {
		int cellCount=0;
		try {
			fileInputStream=new FileInputStream(excelFilePath);
			workBook=new XSSFWorkbook(fileInputStream);
			sheet=workBook.getSheet(sheetName);
			row=sheet.getRow(rowNumber);
			cellCount=row.getLastCellNum();
			workBook.close();
			fileInputStream.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return cellCount;
		
		
	}
	
	public String getCellData(String sheetName, int rowNumber, int CellNumber)
	{
		String data="";
		try {
			fileInputStream=new FileInputStream(excelFilePath);
			workBook=new XSSFWorkbook(fileInputStream);
			sheet=workBook.getSheet(sheetName);
			row=sheet.getRow(rowNumber);
			cell=row.getCell(CellNumber);
			
			DataFormatter formatter=new DataFormatter();
			
			try {
				data=formatter.formatCellValue(cell);
			}catch(Exception e) {
				data="";
			}
			workBook.close();
			fileInputStream.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		return data;
		
	}
	
	public void setCellData(String sheetName, int rowNumber, int cellNumber, String cellData) {
		
		File excelFile=new File(excelFilePath);
		if(!excelFile.exists()) {  //If File doesn't exist then create new excel file
			try {
				workBook=new XSSFWorkbook();
				fileOutputStream=new FileOutputStream(excelFilePath);
				workBook.write(fileOutputStream);
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		try {
			fileInputStream=new FileInputStream(excelFilePath);
			workBook=new XSSFWorkbook(fileInputStream);
			
			if(workBook.getSheetIndex(sheetName)==-1) {  //If Sheet doesn't exist then create new sheet
				workBook.createSheet(sheetName);
				sheet=workBook.getSheet(sheetName);
			}
			
			if(sheet.getRow(rowNumber)==null) { //If row doesn't exist then create new row
				sheet.createRow(rowNumber);
				row=sheet.getRow(rowNumber);
			}
			
			cell=row.createCell(cellNumber);
			cell.setCellValue(cellData);
			fileOutputStream=new FileOutputStream(excelFilePath);
			workBook.write(fileOutputStream);
			workBook.close();
			fileInputStream.close();
			fileOutputStream.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
