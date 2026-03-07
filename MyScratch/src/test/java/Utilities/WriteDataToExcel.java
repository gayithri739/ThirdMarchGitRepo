package Utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.google.common.collect.Table.Cell;

import Constants.ConstantsData;

public class WriteDataToExcel {
	public static void writeCustomerId(String customerId) throws IOException {

		FileInputStream fis = new FileInputStream(ConstantsData.EXCEL_PATH);
	    XSSFWorkbook workbook = new XSSFWorkbook(fis);
	    XSSFSheet sheet = workbook.getSheet("Sheet2");	    
	    sheet.createRow(0).createCell(0).setCellValue("Customer ID");
	    sheet.createRow(1).createCell(0).setCellValue(customerId);
	    fis.close();
	    FileOutputStream fos = new FileOutputStream(ConstantsData.EXCEL_PATH);
	    workbook.write(fos);
	    
	    fos.close();
	    workbook.close();
	}
	public static void writeAccountId(String accId) throws IOException {

		FileInputStream fis = new FileInputStream("D:/TestData1.xlsx");
	    XSSFWorkbook workbook = new XSSFWorkbook(fis);
	    XSSFSheet sheet = workbook.getSheet("Sheet2");	    
	    sheet.createRow(0).createCell(1).setCellValue("Account ID");
	    sheet.createRow(1).createCell(1).setCellValue(accId);
	    fis.close();
	    FileOutputStream fos = new FileOutputStream("D:/TestData1.xlsx");
	    workbook.write(fos);
	    fos.close();
	    workbook.close();
	}
}

