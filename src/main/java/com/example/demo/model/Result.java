package com.example.demo.model;

import java.util.List;

import com.alibaba.fastjson.JSONObject;

public class Result {

	public static String result(String code, String msg) {
		JSONObject json = new JSONObject();
		json.put("code", code);
		json.put("msg", msg);
		return json.toString();
	}

	public static String result(String code, String msg, Object obj) {
		JSONObject json = new JSONObject();
		json.put("code", code);
		json.put("msg", msg);
		json.put("obj", obj);
		return json.toString();
	}

	public static String result(String code, String msg, List<Object> list) {
		JSONObject json = new JSONObject();
		json.put("code", code);
		json.put("msg", msg);
		json.put("list", list);
		return json.toString();
	}

}
