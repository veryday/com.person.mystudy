package com.example.demo.tool;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class ClassInfo {

	/**
	 * 获取指定属性的值
	 * @param fieldName
	 * @param obj
	 * @return
	 * @throws SecurityException
	 * @throws Exception
	 */
	public static Object getFieldValueByName(String fieldName,Object obj) throws SecurityException,Exception{
		String firstLetter = fieldName.substring(0, 1).toUpperCase();
		String getter = "get"+firstLetter+ fieldName.substring(1);
		Method method =  obj.getClass().getMethod(getter, new Class[] {}); 
		 Object value = method.invoke(obj, new Object[] {});    
		 if(value == null){
				value="";
			}
         return value;
	}
	/**
	 * 获取指定属性数组的值
	 * @param fieldNames
	 * @param obj
	 * @return
	 * @throws SecurityException
	 * @throws Exception
	 */
	public static List<String> getFieldValueByNames(List<String> fieldNameList,Object obj) throws SecurityException,Exception{
		List<String> list=new ArrayList<>();
		for(String fieldName:fieldNameList){
			String firstLetter = fieldName.substring(0, 1).toUpperCase();
			String getter = "get"+firstLetter+ fieldName.substring(1);
			Method method =  obj.getClass().getMethod(getter, new Class[] {}); 
			Object value = method.invoke(obj, new Object[] {}); 
			if(value == null){
				value="";
			}
			list.add(value.toString());
		}
         return list;
	}
}
