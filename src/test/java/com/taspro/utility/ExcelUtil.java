package com.taspro.utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

import com.taspro.base.Constants;

public class ExcelUtil {

	XSSFWorkbook workbook;

	
	
	

	public String[][] readExcel(String sheetName) {
		
		//String path = System.getProperty("user.dir")+"src\\test\\resources\\TAS-2_Employee_data.xlsx";
		String path = Constants.EXCEL_PATH;
	
		try {
			FileInputStream fis = new FileInputStream(path);
			workbook = new XSSFWorkbook(fis);
		} catch (FileNotFoundException e) {
			System.out.println("Excel file not found! on the location : "+path);
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Input output error occured during excel file operations.");
			e.printStackTrace();
		}
		
		XSSFSheet sheet = workbook.getSheet(sheetName);
		
		int lastRow = sheet.getLastRowNum();
		int lastCell = sheet.getRow(lastRow).getLastCellNum();

		String[][] empDetail = new String[lastRow][lastCell]; // Created 2 dimensional array to store excel sheet data.

		for (int i = 0; i < lastRow; i++) {
			for (int j = 0; j < lastCell; j++) {
				empDetail[i][j] = sheet.getRow(i + 1).getCell(j).toString(); //Retrieving and storing the data from excel sheet by skipping the first row.
			}
		}
		return empDetail;
	}
}