package com.acti.utis;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelLib 
{
	XSSFWorkbook wb;
//	constructor
	public ExcelLib(String xlPath) 
	{
		try 
		{
			File fil = new File(xlPath);
			FileInputStream fis = new FileInputStream(fil);
			wb = new XSSFWorkbook(fis);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	public int getRowCount(int sheetIndex) 
	{
		return wb.getSheetAt(sheetIndex).getLastRowNum() + 1;
		
	}
	public String getCellData(int sheetIndex, int rowIndex, int colIndex)
	{
		return wb.getSheetAt(sheetIndex).getRow(rowIndex).getCell(colIndex).toString();
	}

}
