package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.model.Result;
import com.example.demo.model.UserInf;
import com.example.demo.service.UserInfService;
import com.example.demo.tool.Excel;

@Controller
public class SysController {

	private static final Logger log = LoggerFactory.getLogger(SysController.class);
	
	@Autowired
	private UserInfService userInfoService;
	
	@RequestMapping("/")
	@ResponseBody
	public String sys() {
		log.info("sys");
		List<UserInf> list = userInfoService.list();
		return Result.result("0", "success", list);
	}
	@GetMapping("/login")
	public String userLogin(){
		log.info("userLogin");
		return "login";
	}
	@GetMapping("/registe")
	public String userRegiste(){
		log.info("userRegiste");
		return "registe";
	}
	@GetMapping("/file")
	public String userFileManager(){
		log.info("userFileManager");
		return "fileManager";
	}
	@GetMapping("/vedio")
	public String vedio(){
		log.info("uservedio");
		return "redirect:/static/vedio/happyfit2.mp4";//重定向
	}
	@GetMapping("/help")
	public String help(){
		log.info("userhelp");
		return "forward:/static/vedio/HELP.md";//转发
	}
	
	@GetMapping("/excel")
	public void excel(HttpServletResponse response) throws Exception{
		log.info("excel");
		Map<String,String> excelInfo = new HashMap<String, String>();
		Map<String,String> cellNameAndFieldName = new HashMap<String, String>();
		List<UserInf> dataList = userInfoService.list();
		excelInfo.put("sheetName", "用户信息表");
		excelInfo.put("excelName", "用户信息表");
		cellNameAndFieldName.put("账号","accountNumber");
		cellNameAndFieldName.put("名称", "name");
		cellNameAndFieldName.put("昵称", "nickName");
		cellNameAndFieldName.put("性别", "sex");
		cellNameAndFieldName.put("年龄", "age");
		Excel.downloadExcel(response, excelInfo, cellNameAndFieldName, dataList);
	}
	
	@GetMapping("/loyout")
	public void loyout(HttpServletRequest request){
		HttpSession session = request.getSession(false);
		if(session != null)
			session.invalidate();
	}
}
