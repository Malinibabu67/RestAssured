package Utilis;

public class ExcelutilisTest {
	
	static String excelPath = "./Data/Testdata.xlsx";
	static String sheetname = "Sheet1";
	
	public static void main(String[] args) {
		ExcelUtilis  excel = new ExcelUtilis(excelPath, sheetname);
		
		excel.getRowCount();
		excel.getCellData(1, 1);
	}

}
