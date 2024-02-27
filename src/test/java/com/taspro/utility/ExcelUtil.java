package com.taspro.utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.taspro.base.Constants;



public class ExcelUtil {

	XSSFWorkbook workbook;
	FileInputStream fis;
	private  Logger log  = LogManager.getLogger(ExcelUtil.class.getName());

	public ExcelUtil() {
		String path = Constants.EXCEL_PATH;
		try {
			log.info("reading the excel file from the path provided");
			fis = new FileInputStream(path);
		} catch (FileNotFoundException e) {
			
			log.error("excel file not found");
			System.out.println("Excel file not found! on the location : " + path);
			e.printStackTrace();
		}
	}

	public String[][] readExcelSheet(String sheetName) {

		try {
			workbook = new XSSFWorkbook(fis);
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
				XSSFCell cellData = sheet.getRow(i + 1).getCell(j);// Retrieving and storing the data from excel sheet
																	// by skipping the first row.
				cellData.setCellType(CellType.STRING);
				empDetail[i][j] = cellData.toString();
			}
		}
		return empDetail;
	}

	public String[][] readColumnData(String sheetName, int colNum) { // column number starts from 0.
		try {
			workbook = new XSSFWorkbook(fis);
		} catch (IOException e) {
			System.out.println("Input output error occured during excel file operations.");
			e.printStackTrace();
		}

		XSSFSheet sheet = workbook.getSheet(sheetName);

		int lastRow = sheet.getLastRowNum();
		String[][] empColData = new String[lastRow][1];

		for (int i = 0; i < lastRow; i++) {
			XSSFCell cellData = sheet.getRow(i + 1).getCell(colNum);
			cellData.setCellType(CellType.STRING);
			empColData[i][0] = cellData.toString();
		}
		return empColData;
	}
}