package com.example.demo.tool;

import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

import org.apache.commons.codec.binary.Base64;

/**
DES加密介绍
     DES是一种对称加密算法，所谓对称加密算法即：加密和解密使用相同密钥的算法
注意：DES加密和解密过程中，密钥长度都必须是8的倍数
*/
public class DES {

	/**
     * 加密
     * @param datasource byte[]
     * @param password String
     * @return byte[]
	 * @throws Exception 
     */
	 public static String encrypt(String str, String password) throws Exception {          
		 SecureRandom random=new SecureRandom();//随机数算法(NativePRNG和SHA1PRNG)
		 DESKeySpec desKey = new DESKeySpec(password.getBytes());
		 //创建一个密匙工厂，然后用它把DESKeySpec转换成
		 SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");//获取DES处理类
		 SecretKey securekey = keyFactory.generateSecret(desKey);
		//Cipher对象实际完成加密操作
	        Cipher cipher = Cipher.getInstance("DES");
	        //用密匙初始化Cipher对象
	        cipher.init(Cipher.ENCRYPT_MODE, securekey, random);
	        //现在，获取数据并加密
	        //正式执行加密操作
	        return Base64.encodeBase64String(cipher.doFinal(str.getBytes()));
	 }
	 
	 /**
	     * 解密
	     * @param src byte[]
	     * @param password String
	     * @return byte[]
	     * @throws Exception
	     */
	 public static String decrypt(String src, String password) throws Exception {
		 // DES算法要求有一个可信任的随机数源
         SecureRandom random = new SecureRandom();
         // 创建一个DESKeySpec对象
         DESKeySpec desKey = new DESKeySpec(password.getBytes());
         // 创建一个密匙工厂
         SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
         // 将DESKeySpec对象转换成SecretKey对象
         SecretKey securekey = keyFactory.generateSecret(desKey);
         // Cipher对象实际完成解密操作
         Cipher cipher = Cipher.getInstance("DES");
         // 用密匙初始化Cipher对象
         cipher.init(Cipher.DECRYPT_MODE, securekey, random);
         // 真正开始解密操作
         return new String(cipher.doFinal(Base64.decodeBase64(src)));
	 }
}
