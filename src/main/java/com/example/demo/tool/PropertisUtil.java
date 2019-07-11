package com.example.demo.tool;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * propertis工具类
 * @author Admin
 *
 */
public class PropertisUtil {

	 private static Properties properties = null;
	 static {
		 properties = new Properties();
		 init();
	 }
	 /**
	  * 初始化文件(文件在项目下)
	  * @param file
	  */
	private static void init() {
		 try {
			 String path = PropertisUtil.class.getClassLoader().getResource(".").getPath();
			 File dir = new File(path);
			 System.out.println("初始化该路径下的文件："+path);
			 File[] files = dir.listFiles();
			 for (File file : files) {
	             if (file.isFile()) {
	            	 if(file.getName().endsWith("properties")) {
	            		 properties.load(PropertisUtil.class.getClassLoader().getResourceAsStream(file.getName()));
	            		 System.out.println("已初始化文件："+file.getName());
	            	 }
	             } 
	         }
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	 }
	 /**
	  * 加载文件(文件不再项目下)
	  * @param file
	  */
	 public static void addFile(File file) {
		 try {
			InputStream inStream = new FileInputStream(file);
			addFile(inStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
	 }
	 /**
	  * 加载文件(文件不再项目下)
	  * @param file
	  */
	 public static void addFile(InputStream inStream) {
		 try {
			properties.load(inStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
	 }
	 /**
	  * 获取去值
	  * @param key
	  * @return
	  */
	 public static String getValue(String key) {
		 return properties.getProperty(key);
	 }
	 /**
	  * 获取properties对象
	  * @param file
	  * @return
	  */
    public static Properties getProperties(File file) {
		 try {
				InputStream inStream = new FileInputStream(file);
				return getProperties(inStream);
			} catch (IOException e) {
				e.printStackTrace();
			}
		 return null;
	 }
    /**
	  * 获取properties对象
	  * @param file
	  * @return
	  */
   public static Properties getProperties(InputStream inStream) {
		 Properties prop = new Properties();
		 try {
				prop.load(inStream);
			} catch (IOException e) {
				e.printStackTrace();
			}
		 return prop;
	 }
	 
	 public static void main(String[] args) {
		 System.out.println(getValue("ReviceAddr"));
	    }
}

