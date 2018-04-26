package com.kisan.kisannet.excelreader;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.formula.functions.Column;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.kisan.kisannet.testBase.TestBase;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class ExcelReader {
	public static final Logger logger = Logger.getLogger(ExcelReader.class.getName());
	

	public String[][] getExcelData(String excellocation, String sheetname) throws IOException {
		try {
		//declare dataset to hold the data
		String datasets[][] = null;
		
		FileInputStream file = new FileInputStream(new File(excellocation));
		// create workbook
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		//get sheet from workbook
		XSSFSheet sheet = workbook.getSheet(sheetname);
		//get total active rows in sheet
		int totalrows = sheet.getLastRowNum()+1;
		//get total active columns in sheet
		int totalcolumns = sheet.getRow(0).getLastCellNum();
		//create dataset
		datasets = new String[totalrows-1][totalcolumns];
		
		Iterator<Row> rowiterator = sheet.iterator();
		int i = 0;
		int t = 0;
		
		while(rowiterator.hasNext()){
			Row row = rowiterator.next();
			if(i++ != 0) {
				int k = t;
				t++;
				Iterator<Cell> celliterator = row.iterator();
				int j = 0;
				while(celliterator.hasNext()) {
					Cell cell = celliterator.next();
					switch(cell.getCellType()) {
					case Cell.CELL_TYPE_NUMERIC:
						datasets[k][j++] = cell.getStringCellValue();
						//System.out.println(cell.getNumericCellValue());
						break;
						
					case Cell.CELL_TYPE_STRING:
						datasets[k][j++] = cell.getStringCellValue();
						//System.out.println(cell.getStringCellValue());
						break;
					case Cell.CELL_TYPE_BOOLEAN:
						datasets[k][j++] = cell.getStringCellValue();
						//System.out.println(cell.getBooleanCellValue());
						break;
					case Cell.CELL_TYPE_FORMULA:
						datasets[k][j++] = cell.getStringCellValue();
						//System.out.println(cell.getStringCellValue());
						break;
					}
				}
				//System.out.println("");
			}
		}
		logger.info("Excel Reading Done");
		file.close();
		return datasets;
		
	}catch(Exception e) {
		logger.info("Excel Reading Failed");
		e.printStackTrace();
	}
		return null;
		
	}
	
	public static void main(String[] args) throws Exception {
		String excellocation = "G:\\Automation Projects\\KisanNetAndroid\\src\\test\\java\\com\\kisan\\kisannet\\data\\TestData.xlsx";
		String sheetname = "ChannelNames";
		ExcelReader excel = new ExcelReader();
		excel.getExcelData(excellocation, sheetname);
	}
	
}

