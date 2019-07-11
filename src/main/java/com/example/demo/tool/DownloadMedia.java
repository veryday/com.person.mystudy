package com.example.demo.tool;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * 下载媒体文件
 * @author Admin
 *
 */
public class DownloadMedia {

	/**
	 * 下载文件
	 * @param strUrl 文件有效url
	 * @param filePath 文件路径
	 * @throws IOException
	 */
	public static void download(String strUrl,String filePath) throws IOException {
		//转化URL
		URL url = new URL(strUrl);
		//请求连接
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		//设置浏览器模式
		con.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");
		con.setRequestProperty("Accept-Language", "zh-CN,zh;");
		//获取流对象
		InputStream instream = con.getInputStream();
		//创建文件
		File file = new File(filePath);
		if(file.exists()&&file.length()>0){
			return;
		}
		File dir=new File(filePath.substring(0,filePath.lastIndexOf("\\")));
		if(!dir.exists()){
			dir.mkdirs();
		}
		//文件的输出
		FileOutputStream outStream = new FileOutputStream(file);
		System.out.println("开始下载："+file.getName());
		byte[] bytes=new byte[1024*1024*10];
		int len=0;
		while((len=instream.read(bytes))!=-1){
			outStream.write(bytes, 0, len);
			System.out.print("#");
		}
		System.out.println();
		System.out.println("下载完毕");
		instream.close();
		outStream.close();
	}
}
