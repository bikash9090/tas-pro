package com.taspro.utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {
	
	XSSFWorkbook workbook;
	
	
	public String[][] readExcel() {
	String path = "C:\\Users\\Subha Sangita Swain\\git\\tas-pro\\src\\test\\resources\\TAS-2_Employee_data.xlsx";
	
	try {
		FileInputStream fis = new FileInputStream(path);
		 workbook = new XSSFWorkbook(fis);
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	XSSFSheet sheet = workbook.getSheet("empSheet");
	
	int lastRow = sheet.getLastRowNum();
	int lastCell = sheet.getRow(lastRow).getLastCellNum();
	
	String[][] empDetail = new String[lastRow][lastCell];
	
	for(int i=0;i<lastRow;i++) {
		for(int j=0;j<lastCell;j++) {
			empDetail[i][j] = sheet.getRow(i+1).getCell(j).toString();
		}
	}
	
	return empDetail;
	
}
}