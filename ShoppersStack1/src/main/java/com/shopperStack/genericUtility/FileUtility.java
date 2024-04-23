package com.shopperStack.genericUtility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FileUtility {

	FileInputStream fis;
	
	public String readPropertyData(String key) throws IOException {
		fis=new FileInputStream(FrameworkConstants.propertyPath);
		Properties pro=new Properties();
		pro.load(fis);
		String value=pro.getProperty(key);
		return value;
	}
	
	public String readExcelData(String sheetName,int row,int cell) throws IOException {
		fis=new FileInputStream(FrameworkConstants.excelPath);
		Workbook wb=WorkbookFactory.create(fis);
		String value=wb.getSheet(sheetName).getRow(row).getCell(cell).getStringCellValue();
		return value;
	}
}
