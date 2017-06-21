package com.lxy.util;


import java.util.Map;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class TaskBean {
	
	private String entry_id;
	private Long expire_date;
	
	private JSONArray labels;
	private JSONArray members;
	private JSONArray names;
	
	private Map<String, Object> taskMap;
	private WorkTile workTile;
	
	public TaskBean(Map<String, Object> taskMap,WorkTile workTile) {
		this.labels = new JSONArray();
		this.members = new JSONArray();
		this.names = new JSONArray();
		this.taskMap = taskMap;
		this.workTile = workTile;
		System.out.println(taskMap);
		expire_date = (Long) taskMap.get("结束日期");
		names.add(taskMap.get("任务名称").toString());
		
		String entity = taskMap.get("任务分类").toString();
		String member = taskMap.get("资源名称").toString();
		String label = taskMap.get("标签")==null?"":taskMap.get("标签").toString();
		
		
		JSONArray entities = workTile.getEntries();
		for (int i = 0; i < entities.size(); i++) {
			JSONObject map = entities.getJSONObject(i);	
			if(map.get("name").equals(entity)){
				entry_id = map.get("entry_id").toString();
			}
		}
		
		JSONArray worklabels = workTile.getLabels();
		if(label != null && !"".equals(label)){
			for (int i = 0; i < worklabels.size(); i++) {
				JSONObject map = worklabels.getJSONObject(i);	
				if(label.indexOf(",")!=-1){
					for (String l:label.split(",")) {
						if(map.get("desc").equals(l)){
							labels.add(map.get("name"));
						}
					}
				}else{
					if(map.get("desc").equals(label)){
						labels.add(map.get("name"));
					}
				}
			}
		}
		
		JSONArray workMembers = workTile.getMembers();
		for (int i = 0; i < workMembers.size(); i++) {
			JSONObject map = workMembers.getJSONObject(i);	
			if(member.indexOf(",")!=-1){
				for (String m:member.split(",")) {
					if(map.get("display_name").equals(m)){
						members.add(map.get("uid"));
					}
				}
			}else{
				if(map.get("display_name").equals(member)){
					members.add(map.get("uid"));
				}
				
			}
		}
		
	}
	public String toString(){
		JSONObject bean = new JSONObject();
		JSONObject data = new JSONObject();
		data.put("entry_id", entry_id);
		data.put("expire_date", expire_date);
		data.put("is_locked", 0);
		data.put("labels", labels);
		data.put("members", members);
		data.put("names", names);
		data.put("pos_type", "bottom");
		
		bean.put("data", data);
		String json = bean.toJSONString();
		return json;
	}
	public static void main(String[] args) {
		String date = "2017年06月19日 15:24";
	}
	public String getEntry_id() {
		return entry_id;
	}
	public void setEntry_id(String entry_id) {
		this.entry_id = entry_id;
	}
	public Long getExpire_date() {
		return expire_date;
	}
	public void setExpire_date(Long expire_date) {
		this.expire_date = expire_date;
	}
	public JSONArray getLabels() {
		return labels;
	}
	public void setLabels(JSONArray labels) {
		this.labels = labels;
	}
	public JSONArray getMembers() {
		return members;
	}
	public void setMembers(JSONArray members) {
		this.members = members;
	}
	public JSONArray getNames() {
		return names;
	}
	public void setNames(JSONArray names) {
		this.names = names;
	}
}
