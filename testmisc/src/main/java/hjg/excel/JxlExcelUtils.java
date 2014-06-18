package hjg.excel;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class JxlExcelUtils {
	/**
	 * 读取解析一个Excel文件 存入相应的List
	 * @param file 要解析的Excel文件
	 * @return 
	 */
	public List<String> readExcel(File file){
		if(!(file != null && file.exists() && file.isFile())){
			return null;
		}
		System.out.println(file.getAbsolutePath());
		Workbook book =null;
		Sheet[] sheet = null;
		List<String> list = new ArrayList<String>();
		int sheetNum = 0;
		int rowNum = 0;
		int columnNum = 0;
		Cell cellTemp = null;
		String result = "";
		try {
			book = Workbook.getWorkbook(file);
			sheet = book.getSheets();
			sheetNum = sheet.length;
			for (int i = 0; i < sheetNum; i++) {
				list.add("第" + (i + 1) + "张工作簿\n");
				rowNum = sheet[i].getRows();
				columnNum = sheet[i].getColumns();
				for (int j = 0; j < rowNum; j++) {
					list.add(j + "行：\n");
					for (int k = 0; k < columnNum; k++) {
						cellTemp = sheet[i].getCell(k, j);
						result = cellTemp.getContents();
						list.add("   " + result);
					}
					list.add("\n");
				}
			}
		} catch (BiffException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(book != null)
				book.close();
		}
		return list;
	}
	
	/**
	 * 读取解析一个Excel文件中的一个工作薄
	 * @param file		相应的Excel文件
	 * @param sheetNum	Excel文件中的相应的工作薄
	 * @return
	 */
	public List<String> readExcel(File file, int sheetNum){
		if(!(file != null && file.exists() && file.isFile())){
			return null;
		}
		List<String> list = new ArrayList<String>();
		Workbook book =null;
		Sheet[] sheet = null;
		int rowNum = 0;
		int columnNum = 0;
		Cell cellTemp = null;
		String result = "";
		try {
			book = Workbook.getWorkbook(file);
			sheet = book.getSheets();
			
			if ((sheetNum - 1) > sheet.length) {
				return null;
			}
			
System.out.println("第" + (sheetNum) + "张工作簿");
			list.add("第" + (sheetNum) + "张工作簿");
			rowNum = sheet[sheetNum].getRows();
			columnNum = sheet[sheetNum].getColumns();
			for (int j = 0; j < rowNum; j++) {
				list.add(j + "行：");
System.out.print(j + "行：");
				for (int k = 0; k < columnNum; k++) {
					cellTemp = sheet[sheetNum].getCell(k, j);
					result = cellTemp.getContents();
					list.add(result);
System.out.print("   " + result);
				}
				list.add("\n");
System.out.println();
			}
			book.close();
		} catch (Exception e) {
			System.out.println(e);
		}finally{
			if(null != book)
				book.close();
		}
		return list;
	}
	
	/**
	 * 读取解析一个Excel文件的固定的工作薄的固定坐标的值
	 * @param file		要读取的Excel文件
	 * @param sheetNum	要读取Excel文件的相应的工作薄
	 * @param columnNum	相应的列数
	 * @param rowNum	相应的行数
	 * @return	固定坐标的
	 */
	public String readExcel(File file, int sheetNum, int columnNum, int rowNum){
		if(!(file.exists() && file.isFile())){
			return null;
		}
		Workbook book =null;
		Sheet[] sheet = null;
		Cell cellTemp = null;
		String result = "";
		try {
			book = Workbook.getWorkbook(file);			
			sheet = book.getSheets();
			if(sheetNum > (sheet.length-1)){
				return null;
			}
			if(columnNum > sheet[sheetNum-1].getColumns()){
				return null;
			}
			if(rowNum > sheet[sheetNum-1].getRows()){
				return null;
			}
			cellTemp = sheet[sheetNum - 1].getCell(columnNum, rowNum);
			result = cellTemp.getContents();
System.out.println(result);
		} catch (Exception e) {
			System.out.println(e);
		}finally{
			if(book != null){
				book.close();
			}
		}
		return result;
	}
	
	
	public static void main(String[] args){
		JxlExcelUtils e = new JxlExcelUtils();
		File f = new File("resource/test.xls");
		List<String> list = e.readExcel(f, 1);
		for (String s : list) {
			System.out.println(s);
		}
	}
}
