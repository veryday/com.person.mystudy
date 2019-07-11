package com.example.demo.exception;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.model.Result;

@ControllerAdvice
public class MyCotrrollerAdvice {
	
	private static final Logger log = LoggerFactory.getLogger(MyCotrrollerAdvice.class);

	/**
	 * 全局异常捕获处理
	 * @param ex
	 * @return
	 */
	@ExceptionHandler(value=Exception.class)
	@ResponseBody
	public String errorHandler(Exception ex){
		log.info(ex.getMessage());
		System.out.println("-----------------全局异常捕获处理----------------------");
		ex.printStackTrace();
		System.out.println("-----------------全局异常捕获处理end------------");
		return Result.result("-1", "系统异常");
	}
	/**
	 * 拦截捕捉自定义异常 MyException.class
	 * @param myEx
	 * @return
	 */
	@ExceptionHandler(value=MyException.class)
	@ResponseBody
	public String myErrorHandler(MyException myEx){
		log.info(myEx.getMessage());
		System.out.println("-----------------全局自定义异常捕获处理----------------------");
		myEx.printStackTrace();
		System.out.println("-----------------全局自定义异常捕获处理end------------");
		return Result.result(myEx.getCode().toString(), "系统异常");
	}
}
