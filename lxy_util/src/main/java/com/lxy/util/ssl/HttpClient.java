package com.lxy.util.ssl;

import java.util.ArrayList;  
import java.util.Iterator;  
import java.util.List;  
import java.util.Map;  
import java.util.Map.Entry;  
import org.apache.http.HttpEntity;  
import org.apache.http.HttpResponse;  
import org.apache.http.NameValuePair;
import org.apache.http.client.CookieStore;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.message.BasicNameValuePair;  
import org.apache.http.util.EntityUtils;  
/* 
 * 利用HttpClient进行post请求的工具类 
 */  
public class HttpClient {  
	SSLClient client = null;  
	public HttpClient() {
		try {
			client = new SSLClient();
		} catch (Exception e) {
			e.printStackTrace();
		}  
	}
    public String doPost(String url,Map<String,String> map,String charset){  
        HttpPost httpPost = null;  
        String result = null;  
        try{  
            httpPost = new HttpPost(url);  
            //设置参数  
            List<NameValuePair> list = new ArrayList<NameValuePair>();  
            Iterator iterator = map.entrySet().iterator();  
            while(iterator.hasNext()){  
                Entry<String,String> elem = (Entry<String, String>) iterator.next();  
                list.add(new BasicNameValuePair(elem.getKey(),elem.getValue()));  
            }  
            if(list.size() > 0){  
                UrlEncodedFormEntity entity = new UrlEncodedFormEntity(list,charset);  
                httpPost.setEntity(entity);  
            }  
            HttpResponse response = client.execute(httpPost);  
            if(response != null){  
                HttpEntity resEntity = response.getEntity();  
                if(resEntity != null){  
                    result = EntityUtils.toString(resEntity,charset);  
                }  
            }  
        }catch(Exception ex){  
            ex.printStackTrace();  
        }  
        return result;  
    }  
    public String doPostUncode(String url,String entity,String charset){  
        HttpPost method = null;  
        String result = null;  
        try{  
            method = new HttpPost(url);  
            method.setHeader("Content-Type","application/json; charset=utf-8");
            method.setHeader("Accept","application/json, text/plain, */*");
            if(entity!=null){
            	   StringEntity strEntity  = new StringEntity(entity,charset);
                   method.setEntity(strEntity);
            }
            HttpResponse response = client.execute(method);  
            if(response != null){  
                HttpEntity resEntity = response.getEntity();  
                
                CookieStore cookieStore = client.getCookieStore();
                client.setCookieStore(cookieStore);
                
                if(resEntity != null){  
                    result = EntityUtils.toString(resEntity,charset);  
                }  
            }  
        }catch(Exception ex){  
            ex.printStackTrace();  
        }  
        return result;  
    }  
    public String doPut(String url,String entity,String charset){  
        HttpPut method = null;  
        String result = null;  
        try{  
            method = new HttpPut(url);  
            method.setHeader("Content-Type","application/json; charset=utf-8");
            method.setHeader("Accept","application/json, text/plain, */*");
            if(entity!=null){
            	   StringEntity strEntity  = new StringEntity(entity,charset);
                   method.setEntity(strEntity);
            }
            HttpResponse response = client.execute(method);  
            if(response != null){  
                HttpEntity resEntity = response.getEntity();  
                
                CookieStore cookieStore = client.getCookieStore();
                client.setCookieStore(cookieStore);
                
                if(resEntity != null){  
                    result = EntityUtils.toString(resEntity,charset);  
                }  
            }  
        }catch(Exception ex){  
            ex.printStackTrace();  
        }  
        return result;  
    }  
    public String doGet(String url,String charset){  
        HttpGet httpMethod = null;  
        String result = null;  
        try{  
            httpMethod = new HttpGet(url); 
            httpMethod.setHeader("Content-Type","application/json; charset=utf-8");
            httpMethod.setHeader("Accept","application/json, text/plain, */*");
            HttpResponse response = client.execute(httpMethod);  
            if(response != null){  
                HttpEntity resEntity = response.getEntity();  
                if(resEntity != null){  
                    result = EntityUtils.toString(resEntity,charset);  
                }  
            }  
        }catch(Exception ex){  
            ex.printStackTrace();  
        }  
        return result;  
    }  
}  