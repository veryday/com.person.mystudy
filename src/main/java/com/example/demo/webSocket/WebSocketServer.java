package com.example.demo.webSocket;

import java.util.concurrent.ConcurrentHashMap;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONObject;


/**
 * webSocket服务类（s-c）
 * 一个类服务一个客户端
 * @author Admin
 *
 */
/*
 * @ServerEndpoint 注解是一个类层次的注解，它的功能主要是将目前的类定义成一个websocket服务器端,
  * 注解的值将被用于监听用户连接的终端访问URL地址,客户端可以通过这个URL来连接到WebSocket服务器端
 */
@ServerEndpoint("/chat/{ID}")
@Component
public class WebSocketServer {

	//在线人数
	private static long onlineCount=0L;
	//客户端的session
	private static ConcurrentHashMap<String,Session> userIdSession = new ConcurrentHashMap<String,Session>();
	/**
	 * 连接建立成功调用的方法
	 * @param session
	 * @param ID
	 */
	@OnOpen
	public void onOpen(Session session,@PathParam("ID")String id) {
		System.out.println("onOpen");
		addOnlineCount();
		System.out.println("inOnline="+getOnlineCount());
		System.out.println("ID="+id);
		userIdSession.put(id, session);
	}
	
	/**
	 * 收到客户端消息后调用的方法
	 * @param session
	 * @param message
	 */
	@OnMessage
	public void onMessage(Session session,String message) {
		//JSONObject json = (JSONObject)JSONObject.parse(message);
		//String toId = json.getString("from");
		System.out.println("onMessage");
		//session = userIdSession.get(toId);
		System.out.println(message);
		session.getAsyncRemote().sendText(message);
	}
	
	/**
	 * 连接关闭调用的方法
	 * @param session
	 */
	@OnClose
	public void onClose(Session session) {
		System.out.println("onClose");
	}
	
	/**
	 * 发生错误时调用
	 * @param session
	 */
	@OnError
	public void onError(Session session,Throwable error) {
		System.out.println("onError");
	}
	
	public static synchronized long getOnlineCount() {
        return onlineCount;
    }

    public static synchronized void addOnlineCount() {
        WebSocketServer.onlineCount++;
    }

    public static synchronized void subOnlineCount() {
        WebSocketServer.onlineCount--;
    }
	
}
