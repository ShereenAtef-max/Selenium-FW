package TestData;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelData {
	 FileInputStream  FIS;
	
	public FileInputStream getFile() throws FileNotFoundException
	{
		//Excel Path
		String filePath = System.getProperty("user.dir")+"\\src\\test\\java\\TestData\\ExcelTestData.xlsx";
		//Read Excel found on this path
		File srcFile= new File(filePath);
		
		  FIS = new FileInputStream(srcFile);
		
		return FIS;
		
	}
	

	public Object[][] GetExcelData() throws IOException
	{
		
		FIS = getFile();
		//POI to read XLSX file
		//WorkBook => Sheet => Column & Row
		XSSFWorkbook WB = new XSSFWorkbook(FIS);
		XSSFSheet Sheet = WB.getSheetAt(0);
		
		int TotalRows = (Sheet.getLastRowNum()+1);
		int TotalCols = 4;
		
		String[][] arrayExcelData = new String [TotalRows][TotalCols];
		
		for(int i =0;i<TotalRows;i++)
		{
			for(int J=0; J<TotalCols;J++)
			{
				XSSFRow row = Sheet.getRow(i);
				arrayExcelData[i][J]=row.getCell(J).toString();
			}
		}
		
		WB.close();
		return arrayExcelData;
		
	}
	
	
}
