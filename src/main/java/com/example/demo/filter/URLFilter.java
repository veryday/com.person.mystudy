package com.example.demo.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


@Component
@WebFilter(urlPatterns = "/*", filterName = "URLFilter")
public class URLFilter implements Filter {
	
	private static final Logger log = LoggerFactory.getLogger(URLFilter.class);

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		System.out.println("URL过滤器初始化");
	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
			throws IOException, ServletException {

		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;

		System.out.print("URL过滤器开始过滤资源");
	/*
		HttpSession session = request.getSession(false);
		String url = request.getRequestURI();
		log.info("访问路径URL："+url);
		System.out.println(url);
		List<String> excudUrl = new ArrayList<String>();
		excudUrl.add("/chat/*");
		excudUrl.add("/excel");
		excudUrl.add("/login");
		excudUrl.add("/user/login");
		excudUrl.add("/registe");
		excudUrl.add("/user/registe");
		excudUrl.add("/static/cs/*");
		excudUrl.add("/static/js/*");
		excudUrl.add("/static/vedio/*");
		excudUrl.add("/static/templata/*");
		boolean flage = false;
		for (String param : excudUrl) {
			if (param.endsWith("*") && url.startsWith(param.substring(0, param.indexOf("*") - 1))) {
				flage = true;
				break;
			}
			if (url.matches(param)) {
				flage = true;
				break;
			}
		}
		if (!flage) {
			if (session != null) {
				System.out.println(session.getId());
				session.setMaxInactiveInterval(30);
			} else {
				// 转发
				// servletRequest.getRequestDispatcher("/login").forward(servletRequest,
				// servletResponse);
				response.sendRedirect("/login");
				return;
			}
		}*/
		filterChain.doFilter(servletRequest, servletResponse);
	}

	@Override
	public void destroy() {
		System.out.println("URL过滤器销毁了");
	}

}
