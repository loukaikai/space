package com.manage.framework.modules.aop;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Component
@Aspect
public class HttpService {
	private static Logger logger = LoggerFactory.getLogger(HttpService.class);
	
	
//    @Pointcut("execution(* com.jeespring.modules.*.web.*.*(..))")
	@Pointcut("execution(* com.manage.web.*.*(..))")
	public void Log() {
		System.out.println("HttpService test");
	}
	
	@Before("Log()")
	public void beforeHttpservice(JoinPoint joinpoint) {
		ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		HttpServletRequest request = attributes.getRequest();
		StringBuffer requestURL =   request.getRequestURL();
		String mothod = request.getMethod();
		String addr = request.getRemoteAddr();
		Map<String,String[]> map = request.getParameterMap();
		logger.info("HTTP连接信息：requestURL ： "+requestURL+" mothod: "+mothod+" addr:"+addr+" params:"+map
				+"class_method="+joinpoint.getSignature().getDeclaringTypeName() + "." + joinpoint.getSignature().getName()
				+"args="+ joinpoint.getArgs());
	}
	
    @After("Log()")
    public void doAfter(){
        logger.info("doAfter");
    }

    /**
     * 返回信息展示，注意实体类需要一个toString方法
     * @param object
     */
    @AfterReturning(returning = "object", pointcut = "Log()")
    public void doAfterReturning(Object object){
        logger.info("respone="+object);
        //System.out.println("respone="+object);
    }
	
	
	
}
