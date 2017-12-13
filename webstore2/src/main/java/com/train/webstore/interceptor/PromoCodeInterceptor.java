package com.train.webstore.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class PromoCodeInterceptor extends HandlerInterceptorAdapter{
	
	private String promoCode;
	
	private String successRedirect;
	private String errorRedirect;

	public String getPromoCode() {
		return promoCode;
	}

	public void setPromoCode(String promoCode) {
		this.promoCode = promoCode;
	}

	public String getSuccessRedirect() {
		return successRedirect;
	}

	public void setSuccessRedirect(String successRedirect) {
		this.successRedirect = successRedirect;
	}

	public String getErrorRedirect() {
		return errorRedirect;
	}

	public void setErrorRedirect(String errorRedirect) {
		this.errorRedirect = errorRedirect;
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		String inputPromoCode = request.getParameter("myPromoCode");
		
		if(request.getRequestURI().endsWith("/orderPromoCode") ){
			
			if(promoCode.equals(inputPromoCode)){
				response.sendRedirect(request.getContextPath()+"/"+successRedirect);
			}else{
				response.sendRedirect(request.getContextPath()+"/"+errorRedirect);
				return false;
			}
			
			
		}
		
		
		return true;
	}
	
	
	

}
