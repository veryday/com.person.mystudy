package com.example.demo.controller;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
/**
 * 文件管理
 * @author Admin
 *
 */
@Controller
public class FileManagerController {
	
	private static final Logger log = LoggerFactory.getLogger(FileManagerController.class);
	
	@Value("${spring.servlet.multipart.location}")
	private String downLoadPath;
	
	/**
	 * 单个文件上传
	 * @param file
	 * @return
	 */
	@PostMapping("/upload")
	@ResponseBody
	public String uploadFile(@RequestParam("file") MultipartFile file) {
		log.info("uploadFile");
		if(file == null)
			return "fail";
		String fileName = file.getOriginalFilename();
		File dest = new File("root/"+fileName);
		try {
			file.transferTo(dest);
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
			log.error(e.getMessage());
		}
		log.info("fileName:"+fileName);
		return "successs";
	}
	/**
	 * 上传多个文件
	 * @param request
	 * @return
	 */
	@PostMapping("/multiUpload")
	@ResponseBody
	public String uploadFile(MultipartHttpServletRequest request) {
		log.info("multiUpload");
		List<MultipartFile> files = request.getFiles("file");
		StringBuffer buffer = new StringBuffer();
		buffer.append("[");
		for(MultipartFile file : files) {
			if(file != null) {
				String fileName = file.getOriginalFilename();
				buffer.append(fileName);
				try {
					file.transferTo(new File(fileName));
				} catch (IllegalStateException | IOException e) {
					e.printStackTrace();
					log.error(e.getMessage());
				}
			}
			buffer.append(",");
		}
		buffer.append("]");
		return buffer.toString();
		
	}
	@RequestMapping("/download")
	@ResponseBody
	public String download(HttpServletResponse response,String fileName){
		  log.info("download");
		  File file = new File(downLoadPath+File.separator+fileName);
		  log.info("filePath="+file.getPath());
		  FileInputStream is = null;
          BufferedInputStream bs = null;
          OutputStream os = null;
		  if(file.exists()) {
			  try {
			//设置Headers
              response.setHeader("Content-Type","application/octet-stream");
              //设置下载的文件的名称-该方式已解决中文乱码问题
              response.setHeader("Content-Disposition","attachment;filename=" +  new String( fileName.getBytes("gb2312"), "ISO8859-1" ));
              is = new FileInputStream(file);
              bs =new BufferedInputStream(is);
              os = response.getOutputStream();
              byte[] buffer = new byte[1024];
              int len = 0;
              while((len = bs.read(buffer)) != -1){
                  os.write(buffer,0,len);
              }
			  }catch(IOException e) {
				  e.printStackTrace();
				  log.error(e.getMessage());
				return "下载失败";
			  }finally {
				  try{
	                    if(is != null){
	                        is.close();
	                    }
	                    if( bs != null ){
	                        bs.close();
	                    }
	                    if( os != null){
	                        os.flush();
	                        os.close();
	                    }
	                }catch (IOException e){
	                    e.printStackTrace();
	                }
			  }
		  }
		  return "不存在";
	}
	

}
