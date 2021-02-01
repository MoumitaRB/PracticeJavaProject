package Day21_DataDrivenExcell;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class WriteDataExcelData {

	public static void main(String[] args) throws IOException {
		FileOutputStream file= new FileOutputStream("C:\\excelData\\writeTestdata.xlsx");
		XSSFWorkbook workbook= new XSSFWorkbook();
		XSSFSheet sheet= workbook.createSheet("Data");
		
		for(int r=0; r<=5; r++)
		{    
			XSSFRow row= sheet.createRow(r);
			
			for(int c=0; c<3; c++)
			{
				row.createCell(c).setCellValue("welcome");
				
			}
					
		}
		workbook.write(file);
		System.out.println("Writing data is completed...");
	}

}
