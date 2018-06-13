package com.buoy.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.ModelAttribute;

public class BaseController {
	protected static Logger logger = Logger.getLogger(BaseController.class);

	HttpServletRequest request;
	HttpServletResponse response;
	
	@ModelAttribute 
	public void setReqAndRes(HttpServletRequest request, HttpServletResponse response){ 
        this.request = request; 
        this.response = response; 
//        this.session = request.getSession(); 
    } 
	
	public HttpServletRequest getRequest() {
		return request;
	}
	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}
	public HttpServletResponse getResponse() {
		return response;
	}
	public void setResponse(HttpServletResponse response) {
		this.response = response;
	}
	public static void  info(String message) {
		logger.info(message);
	}
	public static void error(String message,Exception e) {
		logger.error(message, e);
	}
}
