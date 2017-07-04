package com.lxy.util;


public class Main {

	public static void main(String[] args) throws Exception {
		ExcelUtil excelUtil = new ExcelUtil("import.xls");

		String pid = "*****";
		WorkTile workTile = new WorkTile(pid);
		
		
		workTile.signin();
		
		workTile.batchTrash();
		
		workTile.initEntries();
		workTile.initMembers();
		workTile.initLabels();
		workTile.setTaskList(excelUtil.getExcel());
		workTile.addTasks();
		
		
	}
}
