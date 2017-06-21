package com.lxy.util;

import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.lxy.util.ssl.HttpClient;

//对接口进行测试  
public class WorkTile {

	private static String DOMAIN = "https://my.worktile.com";
	private String charset = "utf-8";

	private List taskList;
	
	private String pid = null;

	private HttpClient httpMethod = null;
	
	private JSONArray entries = null;
	private JSONArray members = null;
	private JSONArray labels = null;
	
	
	public WorkTile(String pid) {
		this.pid = pid;
		httpMethod = new HttpClient();
	}

	
	public void signin() {
		String httpOrgCreateTest = DOMAIN + "/api/user/signin";
		StringBuffer entity = new StringBuffer();
		// entity.append("{data: {name: \"lxy@jianzhimao.com\", password:
		// \"Jianzhimao\"}}");
		entity.append("{\"data\": {\"name\": \"lxy@jianzhimao.com\", \"password\": \"Jianzhimao\"}}");
		String httpOrgCreateTestRtn = httpMethod.doPostUncode(httpOrgCreateTest, entity.toString(), charset);
		System.out.println("result:" + httpOrgCreateTestRtn);
	}

	public void initEntries() {
		String url = DOMAIN + "/api/entries/?pid=" + pid
				+ "&exclude_tasks=false&formWhere=globalDataContext-loadEntriesAndTasks&dt="
				+ System.currentTimeMillis();
		String res = httpMethod.doGet(url, charset);
		entries = JsonUtil.parseEntries(res);
	}
			
	public void initMembers() {
		String httpOrgCreateTest = DOMAIN + "/api/projects/" + pid + "?dt=" + System.currentTimeMillis();
		String res = httpMethod.doGet(httpOrgCreateTest, charset);
		members = JsonUtil.parseMembers(res);
	}
	public void initLabels() {
		String httpOrgCreateTest = DOMAIN + "/api/projects/" + pid + "?dt=" + System.currentTimeMillis();
		String res = httpMethod.doGet(httpOrgCreateTest, charset);
		labels = JsonUtil.parseLabels(res);
	}
	public void addTasks() {
		for (int i = 0; i < taskList.size(); i++) {
			Map<String, Object> taskMap = (Map<String, Object>) taskList.get(i);
			TaskBean taskBean = new TaskBean(taskMap,this);
			addTask(taskBean);
		}
	}
	
	public void addTask(TaskBean taskBean) {
		String httpOrgCreateTest = DOMAIN + "/api/tasks/batch?pid=" + pid;
		String requestPayload = taskBean.toString();
		String httpOrgCreateTestRtn = httpMethod.doPostUncode(httpOrgCreateTest, requestPayload, charset);
		System.out.println("result:" + httpOrgCreateTestRtn);
	}
	
	
	@SuppressWarnings(value = { "批量删除，谨慎操作" })
	public void batchTrash() {
		String httpOrgCreateTest = DOMAIN + "/api/entries/?pid=" + pid
				+ "&exclude_tasks=false&formWhere=globalDataContext-loadEntriesAndTasks&dt="
				+ System.currentTimeMillis();
		String response = httpMethod.doGet(httpOrgCreateTest, charset);
		JSONArray array = JsonUtil.parseTasks(response);
		for (int i = 0; i < array.size(); i++) {
			JSONObject object = array.getJSONObject(i);
			trash(object.getString("tid"));
		}
	}
	public void trash(String taskId) {
		String httpOrgCreateTest = DOMAIN + "/api/tasks/" + taskId + "/trash?pid=" + pid;
		String requestPayload = "{\"data\":\"null\"}";
		String response = httpMethod.doPut(httpOrgCreateTest, requestPayload, charset);
		System.out.printf("[删除] tid= %s, res = %s\n", taskId,"删除成功");
	}

	public void setTaskList(List taskList) {
		this.taskList = taskList;
	}


	public JSONArray getEntries() {
		return entries;
	}


	public JSONArray getMembers() {
		return members;
	}


	public JSONArray getLabels() {
		return labels;
	}

}