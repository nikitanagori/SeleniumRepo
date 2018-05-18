package utility;

import java.io.FileInputStream;

import java.io.FileOutputStream;


import org.apache.poi.ss.usermodel.Row.MissingCellPolicy;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {
	//write basic read/write methods.

	private static XSSFWorkbook wBook;
	private static XSSFSheet sheet;
	private static XSSFRow row;
	private static XSSFCell cell;
	
	//This method is to set the File path and to open the Excel file, Pass Excel Path and Sheetname as Arguments to this method
	public static void setExcelPath(String sheetName,String path) throws Exception
	{

			// Open the Excel file
		FileInputStream fis=new FileInputStream(path);
		
		// Access the required test data sheet
		wBook=new XSSFWorkbook(fis);
		sheet=wBook.getSheet(sheetName);
		
	}
	//This method is to read the test data from the Excel cell, in this we are passing parameters as Row num and Col num
	public static String getCellData(int rownum,int column)
	{
		row=sheet.getRow(rownum);
		cell=row.getCell(column);
		String cellStringData=cell.getStringCellValue();
		return cellStringData;
		
	}
	
	public static String[][] getExcelTable(){
		int rowcount=sheet.getLastRowNum();
		int col=2;
		
		String [][] table=new String[rowcount+1][col];
		
		for(int i=0;i<rowcount+1;i++) {
			for(int j=0;j<col;j++) {
				
				table[i][j]=getCellData(i, j);
			}
		}
		return table;
		
	}
	
	public static void setExcelCell(int rownum, int colnum,String cellData) throws Exception {
		row=sheet.getRow(rownum);
		
		cell=row.getCell(colnum, MissingCellPolicy.RETURN_BLANK_AS_NULL);
		if(cell==null) {
			cell=row.createCell(colnum);
			cell.setCellValue(cellData);
		}
		else {
			cell.setCellValue(cellData);
			
		}
		//write the result in the excel.
		FileOutputStream fos=new FileOutputStream ("C:\\Users\\A06438_P5.Training\\Downloads\\Drivers\\testdata.xlsx");
		
		wBook.write(fos);
		
		fos.flush();
		fos.close();
	}
}

