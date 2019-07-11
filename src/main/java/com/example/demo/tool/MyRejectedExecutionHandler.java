package com.example.demo.tool;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
/**
*线程池任务列已满的处理机制
*
*/
public class MyRejectedExecutionHandler implements RejectedExecutionHandler{

	@Override
	public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
		
		//打印丢弃的任务
        System.out.println(r.toString() + " is discard");
	}

}
