package hjg.excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.xml.sax.helpers.DefaultHandler;

/**
 * @author hjg
 * @version 创建时间：2010-9-18下午01:45:45
 * 
 **/
public class PoiExcelUtils extends DefaultHandler {
	public void testPoiExcel2007(String strPath) throws Exception {
		// 构造 XSSFWorkbook 对象，strPath 传入文件路径
		XSSFWorkbook xwb = new XSSFWorkbook(strPath);
		// 读取第一章表格内容
		XSSFSheet sheet = xwb.getSheetAt(0);
		// 定义 row、cell
		XSSFRow row;
		String cell;
		// 循环输出表格中的内容
		for (int i = sheet.getFirstRowNum(); i < sheet.getPhysicalNumberOfRows(); i++) {
			row = sheet.getRow(i);
			for (int j = row.getFirstCellNum(); j < row.getPhysicalNumberOfCells(); j++) {
				// 通过 row.getCell(j).toString() 获取单元格内容，
				cell = row.getCell(j).toString();
				System.out.print(cell + "\t");
			}
			System.out.println("");
		}
	}

	public static void main(String[] args) throws Exception {
		 String fileName = "resource/test.xlsx";
		 // 检测代码
		 try {
		 PoiExcelUtils er = new PoiExcelUtils();
		 // 读取excel2007
		 er.testPoiExcel2007(fileName);
		 } catch (Exception ex) {
		 ex.printStackTrace();
		 }
		 
//		 import2007(fileName);
	}

	public static void import2007(String strPath) throws Exception {
		XSSFWorkbook wb = new XSSFWorkbook(strPath);
		int sheetNum = wb.getNumberOfSheets();

		for (int i = 0; i < sheetNum; i++) {

			XSSFSheet childSheet = wb.getSheetAt(i);

			int rowNum = childSheet.getLastRowNum();

			for (int j = childSheet.getFirstRowNum(); j < rowNum; j++) {

				XSSFRow row = childSheet.getRow(j);

				int cellNum = row.getLastCellNum();

				for (int k = 0; k < cellNum; k++) {
					if (row.getCell(k) != null) {
						System.out.println(row.getCell(k).toString());
					}
				}

			}
		}
	}

}
