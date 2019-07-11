package com.example.demo.kuaidi;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/**
 * 快递查询
 * 
 * @author Admin
 *
 */
public class FastMail {

	public static String getHttp(String url){
		// 创建Httpclient对象
	    CloseableHttpClient httpclient = HttpClients.createDefault();
	    String resultString = "";
	    CloseableHttpResponse response = null;
		// 创建http GET请求
	    HttpGet httpGet = new HttpGet(url);
		// 执行请求decryptData
		try {
			response = httpclient.execute(httpGet);
			if (response.getStatusLine().getStatusCode() == 200) {
	            resultString = EntityUtils.toString(response.getEntity(), "UTF-8");
	        }
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
	            if (response != null) {
	                response.close();
	            }
	            httpclient.close();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
		}
		return  resultString;
	}

		public static void main(String[] args) {
			String url="https://www.kuaidi100.com/autonumber/autoComNum";//"http://www.kuaidi100.com/query";
			StringBuilder urlPath = new StringBuilder(url);
			urlPath.append(String.format("?resultv2=%s",""));
			urlPath.append(String.format("&text=%s","75145336588197"));
		//	urlPath.append(String.format("?type=%s","yunda"));
		//	urlPath.append(String.format("?type=%s","jd"));
		//	urlPath.append(String.format("&postid=%s", "VC55230341272"));
			//urlPath.append(String.format("&postid=%s", "3102486841694"));
		//	urlPath.append(String.format("&id=%s", "2"));
		//	urlPath.append(String.format("&valicode=",""));
		//	urlPath.append(String.format("&temp=%s", "0."+System.currentTimeMillis()));
		//	urlPath.append(String.format("&phone=", ""));
			System.out.println(urlPath.toString());
			String body =getHttp(urlPath.toString());
			System.out.println(body);
		}
}
