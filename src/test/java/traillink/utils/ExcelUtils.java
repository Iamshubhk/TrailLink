package traillink.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils extends Loggers {
	
	private  XSSFWorkbook excelWbook;
	private  XSSFSheet excelWsheet;
	private  XSSFCell Cell;

	public String getcelldata(String SheetName,int rownum, int colnum) {
		try {
			String Path = System.getProperty("user.dir")+"/src/test/resources/dataProvider/Data.xlsx";
			FileInputStream Excelfile = new FileInputStream(new File(Path));
			excelWbook = new XSSFWorkbook(Excelfile);
			excelWsheet = excelWbook.getSheet(SheetName);
			Cell = excelWsheet.getRow(rownum).getCell(colnum);
			String cellData = Cell.getStringCellValue();
			return cellData;
		} catch (Exception e) {
			return "";
		}
	}
	
	public void WriteValue(String sheetname, String Value, int row, int col) throws IOException {

		File file = new File("Data.xlsx");
		FileInputStream fis = new FileInputStream(file);
		excelWbook= new XSSFWorkbook(fis);
		excelWsheet = excelWbook.getSheet(sheetname);
		org.apache.poi.ss.usermodel.Cell cell = null;
		cell = excelWsheet.getRow(row).getCell(col);
		cell.setCellValue(Value);
		//String str = cell.getStringCellValue();
		fis.close();
		// Open FileOutputStream to write updates
		FileOutputStream output_file = new FileOutputStream(new File("Data.xlsx"));
		// write changes
		excelWbook.write(output_file);
		// close the stream
		output_file.close();

	}
}
