package com.example.demo.config;

public class AlipayConfig {

	// 商户appid
	public static String APPID = "2016091900548023";
	// 私钥 pkcs8格式的
	public static String RSA_PRIVATE_KEY = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCIwxb2TqQ7lbFzlwUZ6whTOqwnUOQlPtqtMr1iMKJtDbx6U0BvJ+t8jMZA5+Jr0NTbccVaHsQC5lpCVvvkQyn0lA+PTb4TeIYU+rwZkMIi49jUqQVeDdzCc8iByDBnKJqWLm79DvsyyMV98FF9KdvgjsEZhCzH9tezPvZ+pnHF7cCnrrsf6aj0t0TPt+CeDR2P396iHyEIO3z4yVaOkjjkqiWAWCO/ontMN9wyXBn9Kk3Bxaleu1S+28UOaQrnQ7bj2/UXHK19sLuQJqLav6ncd7LfaZeueygNZa/X93rdWa02S8lN75+p6hX4CdyZ7ieM3tEQOVVRWveq0775oF0zAgMBAAECggEAGo53iQCgV4mr2Zw7u1quVSsRftjwVGMuJ2+w4r467B48uSwtWOhRi+/yF2xvxSvaCXrALc3HliCQ6kzlwN9h6EJP+y3HeRRwROajW/uGFyxTUIg5qJfchE3jY4AyFfYGfp8poi4kjSn7X4co67sTHTnbOU83OuUt4XqaduFvOlWz+DjMUf/kAnit8uTHLVVYAct4tUkY2gtW5YMCafQJD5BNXDNz80U/uae/eEWpLnI+eCIbrry0vjJWPT7zf3P3cKHxJiWvBOqU/Sg09OCu6wJRJ+09/AzQ3p/+89CFaBYPqel79+5TW4OkoLCsyjxgmN7pu5bfLq6IMNEN7aLiwQKBgQDrfaf5GC9dCnETChEf0tI9FDyrdzqKw6x5XnuVS3hwYxTUZV5GKR/10MmiGl4e3Lv3ysy7bCzrKz3/4EbipxBWahEgMnzyGgins9/F7SA3x3MZFsiA7/W+pkzta5pWNj5B/8jnX/Y8a4pOq5SUR/48ZwcfdAFg2eCqFZZi2YQaAwKBgQCUrD5tzqx00wvO+Cs81CaxgjS2B2lkWz749tcw42DalCSv7GkbDHzot7/0+UWbISqvt1ATtXmz/R/p9hDDBHdPzrINf5+We+J0/Lhv9N836XYiP22XyM35C1lXXkC24tKu7Mg0qNlBknr5D0dEUZeCwmW+MWONMtjAa35SDarhEQKBgQCD3Ium/nTe+07Po25tTGZuzxsdxBhixSiZmV9H/MeG3uQ1/kDotnRv96Y//9W+IEmcedFkDTGlyUPhOFtY5MVQLfpC9iJiilNYXG8r7BiDQ0pevRQupq8LPyGKPBtitOLtn+WGMYS21lzOqmL7GMjyV5p0cUeoTLfxZT8dQMEoswKBgGx5dB9YQToH1kDPj3SVchnn35/Erp/7d2ndaEsSS9OPbWkye8mxhd2iXBtYWPID9Ao7HOEUctThZgylbbtsocUIEZ+Js53vi95BmiyNpOQ9oeUBFGw/phEEt83oRh1qR8A7oSPS4plWUAUyoZP2WC6eue9YR8N5Cu7yPzuNH1WRAoGAXm7n34sixt3Lidlx54aFqovlRnbF5Q0VdGie7ba0B5ZsEaEQTVMsmcJNm+oDmTdWQXYjZAM/lVXzrQrxxd+lR8DkzWVejLPhKhpAdFhDQDKQy6qjDfW8EpIdzBKtSQwut8gM1IhFDBUDb4kTfv3IOp2IlMAuS4l3Kcr1ZwgHMW4=";
	// 服务器异步通知页面路径 需http://或者https://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	//public static String notify_url = "http://商户网关地址/alipay.trade.wap.pay-JAVA-UTF-8/notify_url.jsp";
	public static String notify_url = "http://localhost/";
	// 页面跳转同步通知页面路径 需http://或者https://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	// 商户可以自定义同步跳转地址
	public static String return_url = "http://商户网关地址/alipay.trade.wap.pay-JAVA-UTF-8/return_url.jsp";
	// 请求网关地址
	public static String URL = "https://openapi.alipaydev.com/gateway.do";
	// 编码
	public static String CHARSET = "UTF-8";
	// 返回格式
	public static String FORMAT = "json";
	// 支付宝公钥
	public static String ALIPAY_PUBLIC_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAxTDSetSxwVHdgFMWCWeJ38LcaH2o1PXellZ7mi3id9ky35A/cdcFrQH4JwCxmMBLWGuqY/fMoxNoG1jBT91vjsAl0PdBZcMRk0QHxSGGqF2iSJrLpnqxJDgsnVtYW5AGbGOU53oCp0zuLpgT6kaVMrTF/yirVxiY2bDQ81Brf1UZiHNmD6gQT5t0RjhPZjN96xsTmXwX8m5ys5yc0p4SyNytxfJGAm1wtrZHoAeUkAQ/EOH93EL5R+7yVcwf6Sm7Xy1Bi4yDWD8I9DNmL6O10TMTdFwLqkBonr1Kc0MyznHp3UHWzRHYValfeudri9sA/xUDGThtXSLCr1Lv6dxK/QIDAQAB";
	// 日志记录目录
	public static String log_path = "/log";
	// RSA2
	public static String SIGNTYPE = "RSA2";
}
