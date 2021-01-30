package idp.hcIndia.testScript;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class datadrivenbyusingexcel {
	
	public static XSSFSheet excelSheet;
	public static XSSFWorkbook excelworkbook;
	public static XSSFCell excelCell;
	public static XSSFRow excelRow;
	public static Object[][] getTableArray(String filepath,String sheetname) throws IOException
	{
		String[][] tabarray=null;
		FileInputStream excelFile=new FileInputStream(filepath);
		excelworkbook=new XSSFWorkbook(excelFile);
		excelSheet=excelworkbook.getSheet(sheetname);
		int startrow=1;
		int startcol=1;
		int ci,cj;
		int totalrows=excelSheet.getLastRowNum();
		int totalcol=2;
		tabarray=new String[totalrows][totalcol];
		ci=0;
		for(int i=startrow;i<=totalrows;i++,ci++)
		{
			cj=0;
			for(int j=startcol;j<=totalcol;j++,cj++)
			{
				tabarray[ci][cj]=getCellData(i,j);
				System.out.println(tabarray[ci][cj]);
			}
		}
		return tabarray;
		
		
	}
	
	public static String getCellData(int RowNum,int ColNum)
	{
		excelCell=excelSheet.getRow(RowNum).getCell(ColNum);
		int datatype=excelCell.getCellType();
		if(datatype==3)
		{
			return "";
		}
		else
		{
			String CellData=excelCell.getStringCellValue();
			return CellData;
		}
	}
	
}			