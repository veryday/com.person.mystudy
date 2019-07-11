package com.example.demo.emailAndMessag;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.LinkedHashMap;

import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.tool.MD5;

/**
 * 发送短信
 * 
 * @author Admin
 *
 */
public class SendMSG {

	public static void main(String[] args) {
		//短信接口地址
				String url ="http://112.91.147.35:8086/sms/v2/std/batch_send";
				SimpleDateFormat sdf = new SimpleDateFormat("MMddHHmmss");
				String timestamp = sdf.format(Calendar.getInstance().getTime());
			String	    mobile="18129859541";
			String	content="同事您好，感谢您对此次测试的配合.小小站惊喜波";
			String userid = "J93189";
			String pwd = "352017";
			String svrtype = "";
			LinkedHashMap<String,String> map = new LinkedHashMap<String,String>();
			pwd = encryptPwd(userid,pwd, timestamp);
			map.put("userid",userid );
			map.put("pwd",pwd );
			map.put("mobile",mobile );
			map.put("content",content );
			map.put("timestamp",timestamp );
			map.put("svrtype",svrtype );
			System.out.println(getMessageResponseInfo1(map, url));
	}

	// 调用发短信接口
	public static JSONObject getMessageResponseInfo1(LinkedHashMap<String, String> map, String url) {
		JSONObject json = new JSONObject();
		try {
			json = (JSONObject) JSONObject.toJSON(map);
			System.out.println("传参json的数据：" + json);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Requestjson格式转换失败");
		}
		JSONObject json1 = new JSONObject();
		CloseableHttpClient client = HttpClients.createDefault();
		String result = "";
		HttpPost post = new HttpPost(url);
		try {
			StringEntity s = new StringEntity(json.toString(), "GBK");
			s.setContentType("application/json");// 发送json数据需要设置contentType
			post.setEntity(s);
			CloseableHttpResponse res = client.execute(post);
			try {
				if (res.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
					HttpEntity entity = res.getEntity();
					result = EntityUtils.toString(entity);// 返回json格式：
					json1 = JSONObject.parseObject(result);
				} else {
					System.out.println("调用失败");
				}
			} catch (Exception e) {
				System.out.println("Responsejson1格式转换失败");
				e.printStackTrace();
			}
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return json1;
	}
	/**
	 * 
	 * 
	 * @description 对密码进行加密
	 * @param userid
	 *        用户账号
	 * @param pwd
	 *        用户原始密码
	 * @param timestamp
	 *        时间戳
	 * @return 加密后的密码
	 */
	public static String encryptPwd(String userid, String pwd, String timestamp)
	{
		// 加密后的字符串
		String encryptPwd = null;
		try
		{
			String passwordStr = userid.toUpperCase() + "00000000" + pwd + timestamp;
			// 对密码进行加密
			encryptPwd = MD5.getStrMD5(passwordStr);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		// 返回加密字符串
		return encryptPwd;
	}

}
