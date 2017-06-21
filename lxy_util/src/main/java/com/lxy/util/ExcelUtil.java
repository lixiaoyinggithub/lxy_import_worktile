package com.lxy.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.WorkbookSettings;

public class ExcelUtil {

	private File excel;

	private String fileName;
	public ExcelUtil(String fileName) {
		String path2 = ExcelUtil.class.getResource("/").toString(); 
		path2 = path2.replaceAll("file:/", "")+fileName;  
		this.excel = new File(path2);
	}
	
	public List getExcel() throws Exception {
		List rowLost = new ArrayList();
		WorkbookSettings workbookSettings = new WorkbookSettings();
		workbookSettings.setEncoding("ISO-8859-1");
		InputStream inputStream = new FileInputStream(excel);
		Workbook workBook = Workbook.getWorkbook(inputStream, workbookSettings);
		Sheet sheet = workBook.getSheet(0);// 这里只取得第一个sheet的值（高级检索导出只有sheet[0]），默认从0开始
		int row = sheet.getRows();
		int col = sheet.getColumns();
		Cell cell = null;
		Cell header = null;
		// 从第2行开始为正式数据
		for (int j = 1; j < row; j++) {
			Map<String, Object> rowRecord = new HashMap<String, Object>();
			for (int i = 0; i < col; i++) {
				header = sheet.getCell(i, 0);
				cell = sheet.getCell(i, j);
				Object value = null;
				if (header.getContents().indexOf("日期") != -1) {
					value = DateUtil.parseDate(cell.getContents(),DateUtil.DATE_PATTERN_1);
				} else {
					value = cell.getContents().trim();
				}
				if (value != null && !"".equals(value)) {
					rowRecord.put(header.getContents().trim(), value);
				}
			}
			if (!rowRecord.isEmpty()) {
				rowLost.add(rowRecord);
			}
		}
		
		List<Map<String, Object>> res = new ArrayList<>();
		for (int i = 0; i < rowLost.size(); i++) {
			Map<String, Object> map = (Map<String, Object>) rowLost.get(i);
			if(map.containsKey("任务分类")){
				res.add(map);
			}
		}
		workBook.close();
		return res;
		
	}
	public static void main(String[] args) throws Exception {
		ExcelUtil excelUtil = new ExcelUtil("import.xls");
		List list = excelUtil.getExcel();
		List<Map<String, Object>> res = new ArrayList<>();
		for (int i = 0; i < list.size(); i++) {
			Map<String, Object> map = (Map<String, Object>) list.get(i);
			if(map.containsKey("任务分类")){
				res.add(map);
			}
		}
		for (int i = 0; i < res.size(); i++) {
			System.out.println(res.get(i));
		}
		System.out.println(res);
	}

}
