package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



public class excelread {
	

	public String[][] readexceldata(String filepath,String filename,String sheetname) throws IOException
	{		
		String filedata = filepath+"\\"+filename;
	    File fs = new File(filedata);
		FileInputStream inputfile = new FileInputStream(fs);
		
		Workbook wb = new XSSFWorkbook(inputfile);
		Sheet sheet= wb.getSheet(sheetname);
		int rowcount = sheet.getPhysicalNumberOfRows();
		int columncount = sheet.getRow(0).getLastCellNum();
		String cellvalue[][]= new String [rowcount][columncount];
		
		for (int i=0;i<rowcount; i++)
		{
			Row row = sheet.getRow(i);
			for (int j=0;j<columncount;j++)
			{
				Cell cell = row.getCell(j);
				
				switch(cell.getCellType())
				{
				case STRING:
					cellvalue[i][j]=cell.getStringCellValue();
					System.out.println(cellvalue[i][j]);
					break; 
					
				case NUMERIC:
					DataFormatter dataformat = new DataFormatter();
					String celldata=dataformat.formatCellValue(cell);
					cellvalue[i][j] = celldata;
					System.out.println(cellvalue[i][j]);
					
				}
				
			}
		}
		
		return cellvalue;
	}
}


