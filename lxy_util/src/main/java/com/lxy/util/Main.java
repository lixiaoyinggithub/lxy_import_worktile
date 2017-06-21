package com.lxy.util;


public class Main {

	public static void main(String[] args) throws Exception {
		ExcelUtil excelUtil = new ExcelUtil("import.xls");

		String pid = "4790ec0d0c424dfcb87dfa0086426e86";
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