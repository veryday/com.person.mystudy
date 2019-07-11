package com.example.demo.tool;

import java.security.MessageDigest;

import org.apache.commons.codec.binary.Hex;

/**
 * md5加密
 * 
 * @author Admin
 *
 */
public class MD5 {
	
	/**
	 * 普通加密
	 * 
	 * @param inStr 数据
	 * @return 加密后的数据
	 * @throws Exception
	 */
	public static String getStrMD5(String inStr) throws Exception {

		// 获取MD5算法
		MessageDigest md5 = MessageDigest.getInstance("MD5");
		// 进行哈希计算并返回结果
		byte[] digest = md5.digest(inStr.getBytes());
		StringBuilder sb = new StringBuilder();
		for (byte var : digest) {
			int des = var & 0xff;
			if (des < 16)
				sb.append("0");
			sb.append(Integer.toHexString(des));// 返回为无符号整数基数为16的整数参数的字符串表示形式
		}
		return sb.toString();
	}

	/**
	 * MD5+salt
	 * 
	 * @param inStr 数据
	 * @param salt  盐
	 * @return 加密后的数据
	 * @throws Exception
	 */
	public static String getStrMD5(String inStr, String salt) throws Exception {

		String pwd = md5Hex(inStr+salt);
		// 获取MD5算法
		MessageDigest md5 = MessageDigest.getInstance("MD5");
		// 进行哈希计算并返回结果
		byte[] digest = md5.digest(pwd.getBytes());
		StringBuilder sb = new StringBuilder();
		for (byte var : digest) {
			int des = var & 0xff;
			if (des < 16)
				sb.append("0");
			sb.append(Integer.toHexString(des));// 返回为无符号整数基数为16的整数参数的字符串表示形式
		}
		return sb.toString();
	}

	private static String md5Hex(String inStr) throws Exception {
		// 获取MD5算法
		MessageDigest md5 = MessageDigest.getInstance("MD5");
		// 进行哈希计算并返回结果
		byte[] digest = md5.digest(inStr.getBytes());
		return new String(new Hex().encode(digest));
	}
}
