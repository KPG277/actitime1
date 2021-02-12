package com.orangehrm.generic;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FileLib {
public String getPropertyValue(String key) throws IOException {
	FileInputStream fis=new FileInputStream("./src/test/resources/data/Commondatas.property.txt");
	Properties p=new Properties();
	p.load(fis);
	String value = p.getProperty(key);
	return value;	
}
public String getExcelValue(String sheetname, int row, int cell) throws EncryptedDocumentException, IOException, InvalidFormatException {
	FileInputStream fis=new FileInputStream("./src/test/resources/data/testscripts.xlsx");
	Workbook wb = WorkbookFactory.create(fis);
	String value = wb.getSheet(sheetname).getRow(row).getCell(cell).getStringCellValue();
	return value;
}
public void setExcelValue(String sheetname, String setvalue,int row, int cell) throws EncryptedDocumentException, IOException, InvalidFormatException {
	FileInputStream fis=new FileInputStream("./src/test/resources/data/testscripts.xlsx");
	Workbook wb = WorkbookFactory.create(fis);
	wb.getSheet(sheetname).getRow(row).getCell(cell).setCellValue(setvalue);
	FileOutputStream fos=new FileOutputStream("./src/test/resources/data/testscripts.xlsx");
	wb.write(fos);
	wb.close();
}
}
