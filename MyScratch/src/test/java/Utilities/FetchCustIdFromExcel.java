package Utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.google.common.collect.Table.Cell;

public class FetchCustIdFromExcel {
	public static String getCustomerId() throws IOException  {

        FileInputStream fis = new FileInputStream("D:/TestData1.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheetAt(1);

        XSSFRow row = sheet.getRow(1);
        String customerId = row.getCell(0).getStringCellValue();

       

        workbook.close();
        fis.close();

        return customerId;
    }
}

