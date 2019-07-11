package com.example.demo.tool;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import com.alibaba.fastjson.JSONObject;


/**
 * http提交工具类
 * 
 * @author Admin
 *
 */
public class HttpUtil {
	// 客户端
	private static CloseableHttpClient httpClient;
	// post提交方法
	private static HttpPost httpPost;
	// get提交方法
	private static HttpGet httpGet;
	// 响应
	private static CloseableHttpResponse response;
	// 响应实体类
	private static HttpEntity httpEntity;

	public static void main(String[] args) throws ClientProtocolException, IOException {
		JSONObject json = new JSONObject();
		List<BasicNameValuePair> pairList = new ArrayList<BasicNameValuePair>();
		pairList.add(new BasicNameValuePair("s", "黄沙"));
		pairList.add(new BasicNameValuePair("offset", "0"));
		pairList.add(new BasicNameValuePair("limit", "1"));
		pairList.add(new BasicNameValuePair("type", "1"));
		json = JSONObject.parseObject(postForm("http://music.163.com/api/search/pc", pairList));
		System.out.println(json);
	}

	/**
	 * post的表单提交
	 * 
	 * @param url
	 * @param paramList
	 * @return
	 * @throws IOException
	 */
	public static String postForm(String url, List<BasicNameValuePair> paramList) throws IOException {
		httpClient = HttpClients.createDefault();
		httpPost = new HttpPost(url);
		// 表单方式
		// 设置参数到请求对象中
		httpPost.setEntity(new UrlEncodedFormEntity(paramList, "utf-8"));
		// 执行请求操作，并拿到结果
		response = httpClient.execute(httpPost);
		String result = "{}";
		if (response.getStatusLine().getStatusCode() == 200) {
			// 获取结果
			httpEntity = response.getEntity();
			// 按指定编码转换结果实体为String类型
			result = EntityUtils.toString(httpEntity, "UTF-8");
		}
		if (response != null) {
			response.close();
		}
		return result;
	}

	/**
	 * post的json提交
	 * 
	 * @param url
	 * @param paramJson
	 * @return
	 * @throws IOException
	 */
	public static String postJson(String url, JSONObject paramJson) throws IOException {
		httpClient = HttpClients.createDefault();
		httpPost = new HttpPost(url);
		StringEntity entity = new StringEntity(paramJson.toString(), "utf-8");// 解决中文乱码问题
		entity.setContentEncoding("UTF-8");
		entity.setContentType("application/json");
		// 设置参数到请求对象中
		httpPost.setEntity(entity);
		// 执行请求操作，并拿到结果
		response = httpClient.execute(httpPost);
		String result = "{}";
		if (response.getStatusLine().getStatusCode() == 200) {
			// 获取结果
			httpEntity = response.getEntity();
			// 按指定编码转换结果实体为String类型
			result = EntityUtils.toString(httpEntity, "UTF-8");
		}
		if (response != null) {
			response.close();
		}
		return result;
	}

	/**
	 * get提交
	 * 
	 * @param url
	 * @return
	 * @throws IOException
	 */
	public static String getHttp(String url) throws IOException {
		// 创建Httpclient对象
		httpClient = HttpClients.createDefault();
		// 创建http GET请求
		httpGet = new HttpGet(url);
		// 执行请求decryptData
		response = httpClient.execute(httpGet);
		String result = "{}";
		if (response.getStatusLine().getStatusCode() == 200) {
			result = EntityUtils.toString(response.getEntity(), "UTF-8");
		}
		if (response != null) {
			response.close();
		}
		return result;
	}
}
