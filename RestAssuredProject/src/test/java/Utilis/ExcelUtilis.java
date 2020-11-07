package Utilis;

import java.io.FileInputStream;
import java.io.InputStream;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtilis {
	static XSSFWorkbook workbook;
	//static HSSFWorkbook workbook;
	static XSSFSheet sheet;
	//static HSSFSheet sheet;

	public ExcelUtilis(String excelPath, String sheetname) {
		//------------- xlsx, use XSSFWORKBOOK  ----------------------
		try {
			workbook = new XSSFWorkbook(excelPath);
			sheet= workbook.getSheet(sheetname);
		} catch (Exception exp) {
			System.out.println(exp.getMessage());
			System.out.println(exp.getCause());
			exp.printStackTrace();
		}
		
		//------------- xls, use HSSFWORKBOOK  ----------------------
//				try {
//					InputStream file = new FileInputStream(excelPath);
//					workbook = new HSSFWorkbook();
//					sheet= workbook.getSheet(sheetname);
//				} catch (Exception exp) {
//					System.out.println(exp.getMessage());
//					System.out.println(exp.getCause());
//					exp.printStackTrace();
//				}
	}

	public static void getRowCount() {

		//throws exception or try catch can be used
		// public void getRownCount() throws exception{ 
		//can use absolute or relative path, Relative is best just give "./foldername/filename"
		//one more way to get relative path -
		//			String projDir = System.getProperty("user.dir");
		//			System.out.println(projDir);
		int rowcount = sheet.getPhysicalNumberOfRows();
		System.out.println("No.of Rows :" + rowcount);

	}

	public static void getCellData(int rowNum, int colNum) {
		//			------  prints String data----
		//			String value = sheet.getRow(1).getCell(0).getStringCellValue();
		//            System.out.println(value);
		//            ------prints integer value---
		//          double value = sheet.getRow(1).getCell(2).getNumericCellValue();
		//        System.out.println(value);
		//			---- prints both -----
		DataFormatter formatter = new DataFormatter();
		Object value = formatter.formatCellValue(sheet.getRow(rowNum).getCell(colNum));
		System.out.println(value);

	}

}
