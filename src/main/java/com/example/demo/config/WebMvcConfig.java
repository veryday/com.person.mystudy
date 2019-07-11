package com.example.demo.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.example.demo.interceptor.CheckUser;
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

	/**
	 * 注册拦截器
	 */
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		//addPathPatterns("/**")拦截-----------excludePathPatterns("/*")不拦截
		List<String> patterns = new ArrayList<String>();
		//patterns.add("/**/login");
		//patterns.add("/**/registe");
		patterns.add("/**/loyout");
		patterns.add("/static/**");
		registry.addInterceptor(new CheckUser()).addPathPatterns("/**").excludePathPatterns(patterns);
	}
}
