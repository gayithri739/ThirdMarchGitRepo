package Utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import Constants.ConstantsData;



public class FetchDataFromExcel {
	public static String getURL(int x,int y) throws IOException
	{
		String customerID;
		FileInputStream fs = new FileInputStream(ConstantsData.EXCEL_PATH);
		XSSFWorkbook workbook = new XSSFWorkbook(fs);
		XSSFSheet sheet = workbook.getSheetAt(0);
		XSSFCell val=sheet.getRow(x).getCell(y);
		String URL = val.toString();
		return URL;
	}

}
