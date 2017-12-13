package com.train.webstore.interceptor;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AuditLogInterceptor extends HandlerInterceptorAdapter{
	
	
	Logger logger = Logger.getLogger("auditLogger");

	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object arg2, Exception arg3)
			throws Exception {
		if(request.getRequestURI().endsWith("/add") && response.getStatus()==302){
			
			logger.info("user:"+request.getRemoteUser());
			logger.info("添加商品成功：商品id:"+request.getParameter("productId"));
			logger.info("time:"+ new Date());
			
		}
		

		
	}



	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object obj) throws Exception {

		if(request.getRequestURI().endsWith("/add") && request.getMethod().equals("POST")){
			
			logger.info("user:"+request.getRemoteUser());
			logger.info("要添加商品：商品id:"+request.getParameter("productId"));
			
		}
		
		
		
		return true;
	}

}
