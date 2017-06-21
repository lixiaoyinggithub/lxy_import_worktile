package com.lxy.test;


import org.junit.Test;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/**
 * @author LiXiaoYing
 * @time 2017-06-14下午3:05:51
 * @desc 
 */
public class JsonTest {

	@Test
	public void testParseEntries(){
		String json = "{\"code\":200,\"data\":{\"entries\":[{\"entry_id\":\"4d7b28b72fa145ed834ea4e8dc6a95dc\",\"name\":\"项目计划\",\"pos\":65535,\"archived\":0,\"create_date\":1497403308186,\"update_date\":1497403308186,\"watched\":false},{\"entry_id\":\"3c684ef194a5486e80cb4201e5434b03\",\"name\":\"开发任务\",\"pos\":131071,\"archived\":0,\"create_date\":1497403308188,\"update_date\":1497403308188,\"watched\":false},{\"entry_id\":\"c3bfc4f0c41b4631a5ae10b6e423cccf\",\"name\":\"测试任务\",\"pos\":196606,\"archived\":0,\"create_date\":1497403308189,\"update_date\":1497403308189,\"watched\":false},{\"entry_id\":\"3eaa5f83b99d4137a2485267b87d5c7d\",\"name\":\"正在做\",\"pos\":262141,\"archived\":0,\"create_date\":1497403308189,\"update_date\":1497403308189,\"watched\":false},{\"entry_id\":\"189da328d2664dd2bd15ff8f057d0b34\",\"name\":\"已完成\",\"pos\":327676,\"archived\":0,\"create_date\":1497403308190,\"update_date\":1497403308190,\"watched\":false}],\"tasks\":[{\"tid\":\"20214ae8912344d2871d90ab6b3fab6a\",\"entry_id\":\"3c684ef194a5486e80cb4201e5434b03\",\"pid\":\"4790ec0d0c424dfcb87dfa0086426e86\",\"name\":\"1\",\"desc\":\"\",\"pos\":65535,\"labels\":[],\"uid\":\"963382dab4be4afab479d4e665b362bc\",\"expire_date\":0,\"completed\":0,\"members\":[],\"badges\":{\"expire_date\":0,\"comment_count\":0,\"todo_checked_count\":0,\"todo_count\":0,\"file_count\":0},\"todos\":[],\"is_deleted\":0,\"is_locked\":0,\"is_loop\":0,\"archived\":0,\"update_date\":1497407122081,\"create_date\":1497407122058,\"completed_date\":0,\"fids\":[],\"entry_name\":\"开发任务\",\"watchers\":[{\"uid\":\"963382dab4be4afab479d4e665b362bc\",\"name\":\"lxy444131509\",\"display_name\":\"李孝赢\",\"email\":\"lxy@jianzhimao.com\",\"avatar\":\"default_avatar.png\",\"desc\":\"\",\"status\":1,\"online\":0,\"phone_prefix\":\"\",\"phone\":\"13016006108\",\"title\":\"\",\"department\":\"\"}]}]}}";
		JSONObject object = JSONObject.parseObject(json);
		JSONObject data = object.getJSONObject("data");
		JSONArray entries = data.getJSONArray("entries");
		for (int i = 0; i < entries.size(); i++) {
			JSONObject map = entries.getJSONObject(i);	
			map.getString("entry_id");
			System.out.println(map.get("entry_id"));
			System.out.println(map.get("name"));
		}
	}
	@Test
	public void parseTasks(){
		String json = "{\"code\":200,\"data\":{\"entries\":[{\"entry_id\":\"4d7b28b72fa145ed834ea4e8dc6a95dc\",\"name\":\"项目计划\",\"pos\":65535,\"archived\":0,\"create_date\":1497403308186,\"update_date\":1497403308186,\"watched\":false},{\"entry_id\":\"3c684ef194a5486e80cb4201e5434b03\",\"name\":\"开发任务\",\"pos\":131071,\"archived\":0,\"create_date\":1497403308188,\"update_date\":1497403308188,\"watched\":false},{\"entry_id\":\"c3bfc4f0c41b4631a5ae10b6e423cccf\",\"name\":\"测试任务\",\"pos\":196606,\"archived\":0,\"create_date\":1497403308189,\"update_date\":1497403308189,\"watched\":false},{\"entry_id\":\"3eaa5f83b99d4137a2485267b87d5c7d\",\"name\":\"正在做\",\"pos\":262141,\"archived\":0,\"create_date\":1497403308189,\"update_date\":1497403308189,\"watched\":false},{\"entry_id\":\"189da328d2664dd2bd15ff8f057d0b34\",\"name\":\"已完成\",\"pos\":327676,\"archived\":0,\"create_date\":1497403308190,\"update_date\":1497403308190,\"watched\":false}],\"tasks\":[{\"tid\":\"20214ae8912344d2871d90ab6b3fab6a\",\"entry_id\":\"3c684ef194a5486e80cb4201e5434b03\",\"pid\":\"4790ec0d0c424dfcb87dfa0086426e86\",\"name\":\"1\",\"desc\":\"\",\"pos\":65535,\"labels\":[],\"uid\":\"963382dab4be4afab479d4e665b362bc\",\"expire_date\":0,\"completed\":0,\"members\":[],\"badges\":{\"expire_date\":0,\"comment_count\":0,\"todo_checked_count\":0,\"todo_count\":0,\"file_count\":0},\"todos\":[],\"is_deleted\":0,\"is_locked\":0,\"is_loop\":0,\"archived\":0,\"update_date\":1497407122081,\"create_date\":1497407122058,\"completed_date\":0,\"fids\":[],\"entry_name\":\"开发任务\",\"watchers\":[{\"uid\":\"963382dab4be4afab479d4e665b362bc\",\"name\":\"lxy444131509\",\"display_name\":\"李孝赢\",\"email\":\"lxy@jianzhimao.com\",\"avatar\":\"default_avatar.png\",\"desc\":\"\",\"status\":1,\"online\":0,\"phone_prefix\":\"\",\"phone\":\"13016006108\",\"title\":\"\",\"department\":\"\"}]}]}}";
		JSONObject object = JSONObject.parseObject(json);
		JSONObject data = object.getJSONObject("data");
		JSONArray tasks = data.getJSONArray("tasks");
		System.out.println("------------解析任务------------");
		System.out.println(tasks);
		System.out.println("------------解析任务------------");
	}
	@Test
	public void testParseMembers(){
		String json = "{\"data\":{\"info\":{\"pid\":\"4790ec0d0c424dfcb87dfa0086426e86\",\"team_id\":\"14e6e68cac0c4c53967405556c1e1ab1\",\"name\":\"CRM1.1.0\",\"desc\":\"\",\"archived\":0,\"pic\":\"icon-inbox\",\"bg\":\"#3c8cad\",\"visibility\":1,\"is_calendar\":0,\"navs\":[],\"permission\":31,\"link_join_code\":\"\",\"show_background\":0,\"background\":\"\",\"bg_image\":\"\",\"extensions\":[{\"eid\":\"478f3a4c51824ad23cb50c1c60670c0f\",\"key\":\"task\",\"type\":1,\"pos\":65535,\"join_date\":1497403308040},{\"eid\":\"a0e7b2a565119c0a7ec3126a16016113\",\"key\":\"event\",\"type\":1,\"pos\":131071,\"join_date\":1497403308040},{\"eid\":\"8c7dd922ad47494fc02c388e12c00eac\",\"key\":\"file\",\"type\":1,\"pos\":196606,\"join_date\":1497403308039},{\"eid\":\"42b90196b487c54069097a68fe98ab6f\",\"key\":\"post\",\"type\":1,\"pos\":262141,\"join_date\":1497403308039},{\"eid\":\"71860c77c6745379b0d44304d66b6a13\",\"key\":\"page\",\"type\":1,\"pos\":327676,\"join_date\":1497403308039},{\"eid\":\"f8b0b924ebd7046dbfa85a856e4682c8\",\"key\":\"graph\",\"type\":1,\"pos\":393211,\"join_date\":1497403308039},{\"eid\":\"c6c45e4495a68b6d99b5ae9afd78ad03\",\"key\":\"show_task_number\",\"type\":2,\"pos\":65535,\"join_date\":1497403308038}],\"curr_role\":1,\"labels\":[{\"name\":\"blue\",\"desc\":\"后端开发\",\"_id\":\"56780ea226711548459e1365\"},{\"name\":\"green\",\"desc\":\"Android\",\"_id\":\"56780ea226711548459e1364\"},{\"name\":\"orange\",\"desc\":\"IOS\",\"_id\":\"56780ea226711548459e1363\"},{\"name\":\"purple\",\"desc\":\"测试\",\"_id\":\"56780ea226711548459e1362\"},{\"name\":\"red\",\"desc\":\"开发\",\"_id\":\"56780ea226711548459e1361\"},{\"name\":\"shallow_green\",\"desc\":\"前端开发\",\"_id\":\"56780ea226711548459e135f\"},{\"name\":\"young_blue\",\"desc\":\"J端\",\"_id\":\"56780ea226711548459e135e\"},{\"name\":\"willow\",\"desc\":\"B端\",\"_id\":\"56780ea226711548459e135d\"},{\"name\":\"red_in\",\"desc\":\"C端\",\"_id\":\"56780f06bbcec4c108e04f38\"},{\"name\":\"peony\",\"desc\":\"提测\",\"_id\":\"56793850bbcec4c108e11ec9\"},{\"name\":\"lead\",\"desc\":\"任务分解\",\"_id\":\"56793916dca811e04c50aadd\"},{\"name\":\"walnut\",\"desc\":\"产品验收\",\"_id\":\"56949059e61aa3591131f9b9\"},{\"name\":\"violet\",\"desc\":\"计划点\",\"_id\":\"56d6ad15739030522189dbf5\"},{\"name\":\"yellow\",\"desc\":\"上线\",\"_id\":\"58b5be7207da454cdc35f6ab\"}],\"team\":{\"team_id\":\"14e6e68cac0c4c53967405556c1e1ab1\",\"name\":\"健壮猫\",\"status\":1,\"edition\":1,\"is_owner\":0},\"owner\":{\"uid\":\"13db77f9471a43a3b432012da71aeb81\",\"name\":\"cpthack\",\"display_name\":\"成佩涛\",\"email\":\"yu.zhou@codrim.net\",\"avatar\":\"default_avatar.png\",\"desc\":\"\",\"status\":1,\"online\":0,\"phone_prefix\":\"\",\"phone\":\"18826410953\",\"title\":\"\",\"department\":\"\"},\"admins\":[],\"is_star\":0,\"is_notify\":1,\"is_favorite\":0,\"pos\":1048561,\"star_pos\":1048561},\"members\":[{\"uid\":\"ba5e2c5779194a8a8c41053e101075e7\",\"name\":\"wt8904ba9a0842\",\"display_name\":\"彭快金\",\"email\":\"\",\"avatar\":\"default_avatar.png\",\"desc\":\"\",\"status\":1,\"online\":\"0\",\"phone_prefix\":\"\",\"phone\":\"13929335671\",\"title\":\"\",\"department\":\"\",\"name_pinyin\":\"pkj,pengkuaijin\",\"role\":1,\"join_date\":1497403308032},{\"uid\":\"963382dab4be4afab479d4e665b362bc\",\"name\":\"lxy444131509\",\"display_name\":\"李孝赢\",\"email\":\"lxy@jianzhimao.com\",\"avatar\":\"default_avatar.png\",\"desc\":\"\",\"status\":1,\"online\":\"1\",\"phone_prefix\":\"\",\"phone\":\"13016006108\",\"title\":\"\",\"department\":\"\",\"name_pinyin\":\"lxy,lixiaoying\",\"role\":1,\"join_date\":1497403321063},{\"uid\":\"d2a271f471e84682869a0ba97b18b695\",\"name\":\"wt2051397d7482\",\"display_name\":\"赖俊辉\",\"email\":\"\",\"avatar\":\"default_avatar.png\",\"desc\":\"\",\"status\":1,\"online\":\"0\",\"phone_prefix\":\"\",\"phone\":\"13632374306\",\"title\":\"\",\"department\":\"\",\"name_pinyin\":\"ljh,laijunhui\",\"role\":2,\"join_date\":1497403834282},{\"uid\":\"e7cce85b3aa748608d60a88651a565e0\",\"name\":\"wt37410f021385\",\"display_name\":\"谭祖好\",\"email\":\"tzh@jianzhimao.com\",\"avatar\":\"default_avatar.png\",\"desc\":\"\",\"status\":1,\"online\":\"0\",\"phone_prefix\":\"\",\"phone\":\"\",\"title\":\"\",\"department\":\"\",\"name_pinyin\":\"tzh,tanzuhao\",\"role\":2,\"join_date\":1497403842562},{\"uid\":\"595e8a503e6e491aa59ba25b8cd14055\",\"name\":\"wt0817ab118170\",\"display_name\":\"梁健雄\",\"email\":\"ljx@jianzhimao.com\",\"avatar\":\"default_avatar.png\",\"desc\":\"\",\"status\":1,\"online\":\"0\",\"phone_prefix\":\"\",\"phone\":\"13826005861\",\"title\":\"\",\"department\":\"\",\"name_pinyin\":\"ljx,liangjianxiong\",\"role\":2,\"join_date\":1497403849581},{\"uid\":\"21346d774190451ea71d063408469008\",\"name\":\"wt41884c650254\",\"display_name\":\"吴升航\",\"email\":\"wsh@jianzhimao.com\",\"avatar\":\"default_avatar.png\",\"desc\":\"\",\"status\":1,\"online\":\"0\",\"phone_prefix\":\"\",\"phone\":\"13138576951\",\"title\":\"\",\"department\":\"\",\"name_pinyin\":\"wsh,wushenghang\",\"role\":2,\"join_date\":1497403854587}]},\"code\":200}";
		JSONObject object = JSONObject.parseObject(json);
		JSONObject data = object.getJSONObject("data");
		JSONObject info = data.getJSONObject("info");
		
		JSONArray members = data.getJSONArray("members");
		
		for (int i = 0; i < members.size(); i++) {
			JSONObject map = members.getJSONObject(i);	
			System.out.println(map.getString("uid")+"->"+map.getString("display_name"));
			System.out.println();
		}
	}
	@Test
	public void testParseLabels(){
		String json = "{\"data\":{\"info\":{\"pid\":\"4790ec0d0c424dfcb87dfa0086426e86\",\"team_id\":\"14e6e68cac0c4c53967405556c1e1ab1\",\"name\":\"CRM1.1.0\",\"desc\":\"\",\"archived\":0,\"pic\":\"icon-inbox\",\"bg\":\"#3c8cad\",\"visibility\":1,\"is_calendar\":0,\"navs\":[],\"permission\":31,\"link_join_code\":\"\",\"show_background\":0,\"background\":\"\",\"bg_image\":\"\",\"extensions\":[{\"eid\":\"478f3a4c51824ad23cb50c1c60670c0f\",\"key\":\"task\",\"type\":1,\"pos\":65535,\"join_date\":1497403308040},{\"eid\":\"a0e7b2a565119c0a7ec3126a16016113\",\"key\":\"event\",\"type\":1,\"pos\":131071,\"join_date\":1497403308040},{\"eid\":\"8c7dd922ad47494fc02c388e12c00eac\",\"key\":\"file\",\"type\":1,\"pos\":196606,\"join_date\":1497403308039},{\"eid\":\"42b90196b487c54069097a68fe98ab6f\",\"key\":\"post\",\"type\":1,\"pos\":262141,\"join_date\":1497403308039},{\"eid\":\"71860c77c6745379b0d44304d66b6a13\",\"key\":\"page\",\"type\":1,\"pos\":327676,\"join_date\":1497403308039},{\"eid\":\"f8b0b924ebd7046dbfa85a856e4682c8\",\"key\":\"graph\",\"type\":1,\"pos\":393211,\"join_date\":1497403308039},{\"eid\":\"c6c45e4495a68b6d99b5ae9afd78ad03\",\"key\":\"show_task_number\",\"type\":2,\"pos\":65535,\"join_date\":1497403308038}],\"curr_role\":1,\"labels\":[{\"name\":\"blue\",\"desc\":\"后端开发\",\"_id\":\"56780ea226711548459e1365\"},{\"name\":\"green\",\"desc\":\"Android\",\"_id\":\"56780ea226711548459e1364\"},{\"name\":\"orange\",\"desc\":\"IOS\",\"_id\":\"56780ea226711548459e1363\"},{\"name\":\"purple\",\"desc\":\"测试\",\"_id\":\"56780ea226711548459e1362\"},{\"name\":\"red\",\"desc\":\"开发\",\"_id\":\"56780ea226711548459e1361\"},{\"name\":\"shallow_green\",\"desc\":\"前端开发\",\"_id\":\"56780ea226711548459e135f\"},{\"name\":\"young_blue\",\"desc\":\"J端\",\"_id\":\"56780ea226711548459e135e\"},{\"name\":\"willow\",\"desc\":\"B端\",\"_id\":\"56780ea226711548459e135d\"},{\"name\":\"red_in\",\"desc\":\"C端\",\"_id\":\"56780f06bbcec4c108e04f38\"},{\"name\":\"peony\",\"desc\":\"提测\",\"_id\":\"56793850bbcec4c108e11ec9\"},{\"name\":\"lead\",\"desc\":\"任务分解\",\"_id\":\"56793916dca811e04c50aadd\"},{\"name\":\"walnut\",\"desc\":\"产品验收\",\"_id\":\"56949059e61aa3591131f9b9\"},{\"name\":\"violet\",\"desc\":\"计划点\",\"_id\":\"56d6ad15739030522189dbf5\"},{\"name\":\"yellow\",\"desc\":\"上线\",\"_id\":\"58b5be7207da454cdc35f6ab\"}],\"team\":{\"team_id\":\"14e6e68cac0c4c53967405556c1e1ab1\",\"name\":\"健壮猫\",\"status\":1,\"edition\":1,\"is_owner\":0},\"owner\":{\"uid\":\"13db77f9471a43a3b432012da71aeb81\",\"name\":\"cpthack\",\"display_name\":\"成佩涛\",\"email\":\"yu.zhou@codrim.net\",\"avatar\":\"default_avatar.png\",\"desc\":\"\",\"status\":1,\"online\":0,\"phone_prefix\":\"\",\"phone\":\"18826410953\",\"title\":\"\",\"department\":\"\"},\"admins\":[],\"is_star\":0,\"is_notify\":1,\"is_favorite\":0,\"pos\":1048561,\"star_pos\":1048561},\"members\":[{\"uid\":\"ba5e2c5779194a8a8c41053e101075e7\",\"name\":\"wt8904ba9a0842\",\"display_name\":\"彭快金\",\"email\":\"\",\"avatar\":\"default_avatar.png\",\"desc\":\"\",\"status\":1,\"online\":\"0\",\"phone_prefix\":\"\",\"phone\":\"13929335671\",\"title\":\"\",\"department\":\"\",\"name_pinyin\":\"pkj,pengkuaijin\",\"role\":1,\"join_date\":1497403308032},{\"uid\":\"963382dab4be4afab479d4e665b362bc\",\"name\":\"lxy444131509\",\"display_name\":\"李孝赢\",\"email\":\"lxy@jianzhimao.com\",\"avatar\":\"default_avatar.png\",\"desc\":\"\",\"status\":1,\"online\":\"1\",\"phone_prefix\":\"\",\"phone\":\"13016006108\",\"title\":\"\",\"department\":\"\",\"name_pinyin\":\"lxy,lixiaoying\",\"role\":1,\"join_date\":1497403321063},{\"uid\":\"d2a271f471e84682869a0ba97b18b695\",\"name\":\"wt2051397d7482\",\"display_name\":\"赖俊辉\",\"email\":\"\",\"avatar\":\"default_avatar.png\",\"desc\":\"\",\"status\":1,\"online\":\"0\",\"phone_prefix\":\"\",\"phone\":\"13632374306\",\"title\":\"\",\"department\":\"\",\"name_pinyin\":\"ljh,laijunhui\",\"role\":2,\"join_date\":1497403834282},{\"uid\":\"e7cce85b3aa748608d60a88651a565e0\",\"name\":\"wt37410f021385\",\"display_name\":\"谭祖好\",\"email\":\"tzh@jianzhimao.com\",\"avatar\":\"default_avatar.png\",\"desc\":\"\",\"status\":1,\"online\":\"0\",\"phone_prefix\":\"\",\"phone\":\"\",\"title\":\"\",\"department\":\"\",\"name_pinyin\":\"tzh,tanzuhao\",\"role\":2,\"join_date\":1497403842562},{\"uid\":\"595e8a503e6e491aa59ba25b8cd14055\",\"name\":\"wt0817ab118170\",\"display_name\":\"梁健雄\",\"email\":\"ljx@jianzhimao.com\",\"avatar\":\"default_avatar.png\",\"desc\":\"\",\"status\":1,\"online\":\"0\",\"phone_prefix\":\"\",\"phone\":\"13826005861\",\"title\":\"\",\"department\":\"\",\"name_pinyin\":\"ljx,liangjianxiong\",\"role\":2,\"join_date\":1497403849581},{\"uid\":\"21346d774190451ea71d063408469008\",\"name\":\"wt41884c650254\",\"display_name\":\"吴升航\",\"email\":\"wsh@jianzhimao.com\",\"avatar\":\"default_avatar.png\",\"desc\":\"\",\"status\":1,\"online\":\"0\",\"phone_prefix\":\"\",\"phone\":\"13138576951\",\"title\":\"\",\"department\":\"\",\"name_pinyin\":\"wsh,wushenghang\",\"role\":2,\"join_date\":1497403854587}]},\"code\":200}";
		JSONObject object = JSONObject.parseObject(json);
		JSONObject data = object.getJSONObject("data");
		JSONObject info = data.getJSONObject("info");
		JSONArray labels = info.getJSONArray("labels");
		for (int i = 0; i < labels.size(); i++) {
			JSONObject map = labels.getJSONObject(i);	
			System.out.println(map.getString("name")+"->"+map.getString("desc"));
		}
	}
	@Test
	public void testFormatTask(){
		JSONObject bean = new JSONObject();
		JSONObject data = new JSONObject();
		data.put("entry_id", "3c684ef194a5486e80cb4201e5434b03");
		data.put("expire_date", System.currentTimeMillis());
		data.put("is_locked", 0);
		JSONArray labels = new JSONArray();
		labels.add("blue");
		data.put("labels", labels);
		
		JSONArray members = new JSONArray();
		members.add("963382dab4be4afab479d4e665b362bc");
		members.add("d2a271f471e84682869a0ba97b18b695");
		data.put("members", members);
		
		JSONArray names = new JSONArray();
		names.add("http1");
		names.add("http2");
		names.add("http3");
		names.add("http4");
		names.add("http5");
		data.put("names", names);
		
		data.put("pos_type", "bottom");
		
		bean.put("data", data);
		
		String json = bean.toJSONString();
	}
		  
}
