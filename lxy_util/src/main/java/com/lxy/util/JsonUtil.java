package com.lxy.util;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class JsonUtil {
	
	public static JSONArray parseEntries(String json){
		JSONObject object = JSONObject.parseObject(json);
		JSONObject data = object.getJSONObject("data");
		JSONArray entries = data.getJSONArray("entries");
		return entries;
	}
	public static JSONArray parseMembers(String json){
		JSONObject object = JSONObject.parseObject(json);
		JSONObject data = object.getJSONObject("data");
		JSONArray members = data.getJSONArray("members");
		return members;
	}
	public static JSONArray parseLabels(String json){
		JSONObject object = JSONObject.parseObject(json);
		JSONObject data = object.getJSONObject("data");
		JSONObject info = data.getJSONObject("info");
		JSONArray labels = info.getJSONArray("labels");
		return labels;
	}
	
	public static JSONArray parseTasks(String json){
//		String json = "{\"code\":200,\"data\":{\"entries\":[{\"entry_id\":\"4d7b28b72fa145ed834ea4e8dc6a95dc\",\"name\":\"项目计划\",\"pos\":65535,\"archived\":0,\"create_date\":1497403308186,\"update_date\":1497403308186,\"watched\":false},{\"entry_id\":\"3c684ef194a5486e80cb4201e5434b03\",\"name\":\"开发任务\",\"pos\":131071,\"archived\":0,\"create_date\":1497403308188,\"update_date\":1497403308188,\"watched\":false},{\"entry_id\":\"c3bfc4f0c41b4631a5ae10b6e423cccf\",\"name\":\"测试任务\",\"pos\":196606,\"archived\":0,\"create_date\":1497403308189,\"update_date\":1497403308189,\"watched\":false},{\"entry_id\":\"3eaa5f83b99d4137a2485267b87d5c7d\",\"name\":\"正在做\",\"pos\":262141,\"archived\":0,\"create_date\":1497403308189,\"update_date\":1497403308189,\"watched\":false},{\"entry_id\":\"189da328d2664dd2bd15ff8f057d0b34\",\"name\":\"已完成\",\"pos\":327676,\"archived\":0,\"create_date\":1497403308190,\"update_date\":1497403308190,\"watched\":false}],\"tasks\":[{\"tid\":\"20214ae8912344d2871d90ab6b3fab6a\",\"entry_id\":\"3c684ef194a5486e80cb4201e5434b03\",\"pid\":\"4790ec0d0c424dfcb87dfa0086426e86\",\"name\":\"1\",\"desc\":\"\",\"pos\":65535,\"labels\":[],\"uid\":\"963382dab4be4afab479d4e665b362bc\",\"expire_date\":0,\"completed\":0,\"members\":[],\"badges\":{\"expire_date\":0,\"comment_count\":0,\"todo_checked_count\":0,\"todo_count\":0,\"file_count\":0},\"todos\":[],\"is_deleted\":0,\"is_locked\":0,\"is_loop\":0,\"archived\":0,\"update_date\":1497407122081,\"create_date\":1497407122058,\"completed_date\":0,\"fids\":[],\"entry_name\":\"开发任务\",\"watchers\":[{\"uid\":\"963382dab4be4afab479d4e665b362bc\",\"name\":\"lxy444131509\",\"display_name\":\"李孝赢\",\"email\":\"lxy@jianzhimao.com\",\"avatar\":\"default_avatar.png\",\"desc\":\"\",\"status\":1,\"online\":0,\"phone_prefix\":\"\",\"phone\":\"13016006108\",\"title\":\"\",\"department\":\"\"}]}]}}";
		JSONObject object = JSONObject.parseObject(json);
		JSONObject data = object.getJSONObject("data");
		JSONArray tasks = data.getJSONArray("tasks");
		return tasks;
	}
}
