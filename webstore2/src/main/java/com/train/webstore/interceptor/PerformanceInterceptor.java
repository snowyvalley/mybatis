package com.train.webstore.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.util.StopWatch;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class PerformanceInterceptor implements HandlerInterceptor{
	
	ThreadLocal<StopWatch> localTread = new ThreadLocal<StopWatch>();
	
	Logger logger = Logger.getLogger(this.getClass());

	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object obj, Exception exce)
			throws Exception {
		
		System.out.println("in afterCompletion");
		
		StopWatch stopWatch = localTread.get();
		stopWatch.stop();
		logger.info(stopWatch.getTotalTimeMillis());
		
		localTread.set(null);
		logger.info("==============================");
		
		
	}

	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object obj, ModelAndView mv)
			throws Exception {

		System.out.println("postHandle");
		logger.info(System.currentTimeMillis());
		
	}

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

		StopWatch stopWatch = new StopWatch(handler.toString());
		stopWatch.start(handler.toString());
		localTread.set(stopWatch);
		
		System.out.println("preHandle");
		
		logger.info(request.getRequestURL());
		logger.info(request.getQueryString());
		logger.info(System.currentTimeMillis());
		
		
		return true;
	}

}
