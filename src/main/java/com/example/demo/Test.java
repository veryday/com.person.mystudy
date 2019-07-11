package com.example.demo;

import java.util.concurrent.ConcurrentHashMap;

import javax.websocket.Session;

public class Test {

	public static void main(String[] args) {
		//String param="/static/templata/*";
		//System.out.println("/static/templata/POM.pdf".startsWith(param.substring(0,param.indexOf("*")-1)));
		//param="/static/js/*";
		//System.out.println("/static/templata/POM.pdf".matches(param));
		ConcurrentHashMap<String,String> userIdSession = new ConcurrentHashMap<String,String>();
		userIdSession.put("1", "2");
		System.out.println(userIdSession);
		userIdSession.put("1", "3");
		System.out.println(userIdSession);
	}

}
