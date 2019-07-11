package com.example.demo.controller;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.demo.model.Result;
import com.example.demo.model.UserInf;
import com.example.demo.service.UserInfService;
import com.example.demo.tool.MD5;

import java.util.UUID;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author hujing
 * @since 2019-05-11
 */
@Controller
@RequestMapping("/user")
public class UserInfController {

	private static final Logger log = LoggerFactory.getLogger(UserInfController.class);
	
	@Autowired
	private UserInfService userService;
	
	@RequestMapping("/login")
	public ModelAndView userLogin(HttpServletRequest request,HttpServletResponse response,String account,String password) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("login");
		QueryWrapper< UserInf> queryWrapper = new QueryWrapper<UserInf>();
		queryWrapper.eq("account_number", account);
		UserInf userInf = userService.getOne(queryWrapper);
		if(userInf == null) {
			mv.addObject("msg", "账号错误或不存在");
			return mv;
		}else if(!userInf.getPasswordv().equals(password)) {
			mv.addObject("msg", "密码错误");
			return mv;
		}
		HttpSession session = request.getSession();
		session.setAttribute("USER_"+session.getId(), userInf);
		session.setMaxInactiveInterval(30);
		Cookie cookie = new Cookie(account, session.getId());
		response.addCookie(cookie);
		mv.setViewName("fileManager");
		return mv;
	}
	@PostMapping("/registe")
	@ResponseBody
	@Transactional
	public String userRegiste(@RequestBody UserInf userInf) {
		log.info("userRegiste");
		if(userInf == null || userInf.getAccountNumber() == "" || userInf.getAccountNumber() == null ||
				userInf.getPasswordv() == "" || userInf.getPasswordv() == null) {
			throw new RuntimeException("数据不能为空");
		}
		String passwordv =userInf.getPasswordv();
		UUID uuid = UUID.randomUUID();
		userInf.setUserId(uuid.toString().replace("_", ""));
		try {
			passwordv = MD5.getStrMD5(passwordv);
			userInf.setPassword(passwordv);
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.getMessage());
		}
		userService.save(userInf);
		return Result.result("0", "success");
	}
	
}

