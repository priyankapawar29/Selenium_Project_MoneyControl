package CommonMethods;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class commonMethods {
	
	/**
	 * Fifteen seconds explicit wait added in order to make the DOM fully loaded
	 */
	public static void longWait(){
		try {
			TimeUnit.SECONDS.sleep(15);
		} catch (InterruptedException e) {
			System.out.println("Interruption happened due to sleep() method");
		}
	}
	
	/**
	 * Five seconds explicit wait added in order to make the DOM fully loaded
	 */
	public static void shortWait(){
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			System.out.println("Interruption happened due to sleep() method");
		}
	}
	
	/**
	 * This method is to read first 10 rows of first column from excel 
	 * @param ExcelFile is absolute path of excel
	 * @return a String array of cell values
	 * @throws IOException when file is not found
	 */
	public static String[] ReadColumnFromExcel(String ExcelFile) throws IOException {
		String[] columnData = {};
		FileInputStream fis = null;
		XSSFWorkbook workbook = null;
		XSSFSheet sheet;
		try {
			fis = new FileInputStream(ExcelFile);
			workbook = new XSSFWorkbook(fis);
			sheet = workbook.getSheetAt(0);
			for(int i = 0; i<=9;i++) {
				columnData[i]=sheet.getRow(i).getCell(i).getStringCellValue();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			workbook.close();
			fis.close();
		}
		return columnData;
	}

}
