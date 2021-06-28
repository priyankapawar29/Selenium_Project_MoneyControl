package CommonMethods;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.apache.poi.xssf.usermodel.XSSFCell;
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
		FileInputStream fis = new FileInputStream(ExcelFile);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheetAt(1);
		try {
			
			for(int i = 0; i<=9;i++) {
				columnData[i]=sheet.getRow(i).getCell(i).getStringCellValue();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			workbook.close();
			fis.close();
		}
		return columnData;
	}

	@SuppressWarnings("deprecation")
	public static void writeRowInExcel(String[] dataToWrite, String ExcelFile) throws IOException {
			 //create an object of Workbook and pass the file name
		FileInputStream fis = new FileInputStream(ExcelFile);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheetAt(0);
		try {
			 String[] header = {"Company Name", "Prev. Close", "Open Price"};
			 for (int i = 0; i<=9;i++){
				 String[] separateData = dataToWrite[i].split(",");
				 XSSFCell cell0 = sheet.getRow(i).createCell(0);
				 XSSFCell cell1 = sheet.getRow(i).createCell(1);
				 XSSFCell cell2 = sheet.getRow(i).createCell(2);
				 
				 if (i==0) {
					 cell0.setCellValue(header[0]);
					 cell1.setCellValue(header[1]);
					 cell2.setCellValue(header[2]);
				 }
				 else {
					 cell0.setCellValue(separateData[0]);
					 cell1.setCellValue(separateData[1]);
					 cell2.setCellValue(separateData[2]);
				 }
			 }
		} catch (Exception e){
			e.printStackTrace();
		} finally {
			workbook.close();
		}
	}
}
