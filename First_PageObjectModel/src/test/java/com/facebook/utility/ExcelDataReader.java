package com.facebook.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataReader {

	XSSFWorkbook wb;

	public ExcelDataReader() throws IOException  {
		File src = new File("E:\\madhavi\\MukeshOtwani\\First_PageObjectModel\\testdata\\testdataread.xlsx");

			FileInputStream is = new FileInputStream(src);

			wb = new XSSFWorkbook(is);
		
		

	}

	public String getstringdata(int SheetIndex, int row, int column) {
		return wb.getSheetAt(SheetIndex).getRow(row).getCell(column).getStringCellValue();
	}

	public String getstringdata(String sheetname,int row , int column)
	{
		return wb.getSheet(sheetname).getRow(row).getCell(column).getStringCellValue();
	}

	public double getnumericdata(String Sheetname, int row, int column) {
		return wb.getSheet(Sheetname).getRow(row).getCell(column).getNumericCellValue();
	}
}
