package com.example.demo.tool;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/**
*线程程池
*
*/
public class ThreadPool {

	private static ExecutorService defaultThreadPool = null;
	private static ExecutorService threadPool = null;
	
	public static ExecutorService getThreadPool() {
		if(defaultThreadPool == null) {
			synchronized (ThreadPool.class) {
				if(defaultThreadPool == null) {
					defaultThreadPool = new ThreadPoolExecutor(5, 5, 0L, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>(10));
				}
			}
		}
		return defaultThreadPool;
	}
	
	public static ExecutorService getThreadPool(MyRejectedExecutionHandler handler) {
		if(threadPool == null) {
			synchronized (ThreadPool.class) {
				if(threadPool == null) {
					threadPool = new ThreadPoolExecutor(5, 5, 0L, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>(10),handler);
				}
			}
		}
		return threadPool;
	}
}
