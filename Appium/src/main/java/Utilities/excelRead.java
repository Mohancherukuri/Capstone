package Utilities;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class excelRead {
	public static String excel(int row, int column) {
		String testData = null;
		try {
			String filePath = System.getProperty("user.dir") + "\\src\\main\\resources\\testData.xlsx";
			FileInputStream file = new FileInputStream(filePath);
			XSSFWorkbook wb = new XSSFWorkbook(file);
			XSSFSheet ws = wb.getSheetAt(0);
			testData = String.valueOf(ws.getRow(row).getCell(column));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return testData;
	}
}
