package com.buoy.exception;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.shiro.authz.UnauthenticatedException;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.http.server.ServletServerHttpResponse;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import com.buoy.util.Constant;

/**
 * 统一异常处理配置
 * @author Howard
 * 2017年4月1日
 */
public class ExceptionResolverCustom implements HandlerExceptionResolver{
	
	protected static Logger logger = Logger.getLogger(ExceptionResolverCustom.class);
	
	//json转换器
    //将异常信息转json
    private HttpMessageConverter<ExceptionResultInfo> jsonMessageConverter;
    
    // 前端控制器调用此方法执行异常处理
    // handler，执行的action类就包装了一个方法（对应url的方法）
    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
            Exception e) {

        //输出异常信息
        e.printStackTrace();
    	
        HandlerMethod handlerMethod = (HandlerMethod)handler;
        // 转成springmvc底层对象（就是对action方法的封装对象，只有一个方法）
        
        
        
        //取出方法
        Method method = handlerMethod.getMethod();

        // 判断方法是否返回json
        // 只要方法上有responsebody注解表示返回json
        // 查询method是否有responsebody注解
        ResponseBody responseBody = AnnotationUtils.findAnnotation(method, ResponseBody.class);
        if(responseBody!=null){

            //将异常信息转json输出
            return this.resolveJsonException(request, response, handlerMethod, e);
        }
        // 这里说明action返回的是jsp页面
        // 解析异常
        ExceptionResultInfo exceptionResultInfo = resolveExceptionCustom(e);
        ModelAndView modelAndView = new ModelAndView();
//        if (exceptionResultInfo.getType() == Constant.TYPE_RESULT_AUTH) {
//        	// 转向错误页面
////            modelAndView.addObject("exceptionResultInfo",
////            		exceptionResultInfo);
//            modelAndView.setViewName("/login");// 逻辑视图名
//            return modelAndView;
//        }
        
        // 转向错误页面
        modelAndView.addObject("exceptionResultInfo",
        		exceptionResultInfo.getMessage());
        if (exceptionResultInfo.getUrl() != null) {
        	modelAndView.setViewName(exceptionResultInfo.getUrl());// 逻辑视图名
        }else {
        	modelAndView.setViewName("/error");// 逻辑视图名
        }
        return modelAndView;
    }

    private ExceptionResultInfo resolveExceptionCustom(Exception e){

        if(e instanceof ExceptionResultInfo){
        	logger.error("系统出现异常!异常信息："+e.getMessage());
            // 抛出的是系统自定义异常
            return new ExceptionResultInfo(((ExceptionResultInfo) e).getType(),e.getMessage());			
        }else if (e instanceof UnauthenticatedException){
        	logger.error("系统出现异常!异常信息："+e.getMessage());
            // 抛出的是系统自定义异常
        	return new ExceptionResultInfo(Constant.TYPE_RESULT_WARN,"用户未登录！","/login");		
        }else if (e instanceof UnauthorizedException) {
        	logger.error("用户无操作权限!");
            return new ExceptionResultInfo(Constant.TYPE_RESULT_WARN,"当前用户无此操作权限","/right");	
        }else {
            //重新构造“未知错误异常”
        	logger.error("系统出现未知异常!");
            return new ExceptionResultInfo(Constant.TYPE_RESULT_FAIL,"未知错误！");	
        }

        
    }


    // 将异常信息转json输出
    private ModelAndView resolveJsonException(HttpServletRequest request,
            HttpServletResponse response, Object handler, Exception e) {
    	logger.error("返回json异常处理...");
        //解析异常 在方法里判断是自定义还是未知异常
        ExceptionResultInfo exceptionResultInfo = resolveExceptionCustom(e);

        HttpOutputMessage outputMessage = new ServletServerHttpResponse(response);
        
        try {
            //将exceptionResultInfo对象转成json输出
            jsonMessageConverter.write(exceptionResultInfo, MediaType.APPLICATION_JSON, outputMessage);
        } catch (HttpMessageNotWritableException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }

        return new ModelAndView();
    }



    public HttpMessageConverter<ExceptionResultInfo> getJsonMessageConverter() {
        return jsonMessageConverter;
    }
    public void setJsonMessageConverter(HttpMessageConverter<ExceptionResultInfo> jsonMessageConverter) {
        this.jsonMessageConverter = jsonMessageConverter;
    }

}
