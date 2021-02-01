package Day21_DataDrivenExcell;


import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



/*
 * FileInputStream

Workbook--> XSSFWorkbook
Sheet ----> XSSFSheet
Row-------> XSSFRow
Cell -----> XSSFCell
 * 
 */

public class ReadExcelData {

	public static void main(String[] args) throws IOException {
		FileInputStream file= new FileInputStream("C:\\excelData\\TestData1.xlsx");
		XSSFWorkbook workbook=new XSSFWorkbook(file);
		XSSFSheet sheet=workbook.getSheet("Sheet1");
		
		int rowcount=sheet.getLastRowNum();
		int cellcount=sheet.getRow(0).getLastCellNum();
		
		System.out.println("Number of rows="+rowcount);
		System.out.println("Number of column="+cellcount);
		
		for(int r=0; r<=rowcount; r++)
		{    
			 XSSFRow row=sheet.getRow(r);
			for(int c=0; c<cellcount; c++)
			{
				DataFormatter formatter= new DataFormatter();
				XSSFCell cell=row.getCell(c);
				String cellData=formatter.formatCellValue(cell);
				System.out.print(cellData+"   ");
			}
			System.out.println();
		}
		
		
	}
	
	
}