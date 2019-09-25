package com.manage.framework.common.aop;

import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.aspectj.lang.JoinPoint;
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
public class AOPService {
	 private static Logger logger = LoggerFactory.getLogger(AOPService.class);
//    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    // defined aop pointcut
    //@Pointcut("execution(* com.company.project.modules.*.*(..))")
    //@Pointcut("execution(* com.company.project.modules..*.*(..))")
    /*任意公共方法的执行：
    execution(public * *(..))
    任何一个以“set”开始的方法的执行：
    execution(* set*(..))
    AccountService 接口的任意方法的执行：
    execution(* com.xyz.service.AccountService.*(..))
    定义在service包里的任意方法的执行：
    execution(* com.xyz.service.*.*(..))
    定义在service包和所有子包里的任意类的任意方法的执行：
    execution(* com.xyz.service..*.*(..))
    定义在pointcutexp包和所有子包里的JoinPointObjP2类的任意方法的执行：
    execution(* com.test.spring.aop.pointcutexp..JoinPointObjP2.*(..))
    最靠近(..)的为方法名,靠近.*(..))的为类名或者接口名,如上例的JoinPointObjP2.*(..))*/
    
    @Pointcut("execution(* com.manage.web.modules.controller.*.*(..))")
    public void controllerLog() {
    	System.out.println("Aop test");
    };
    
    @Before("controllerLog()")
    public void before(JoinPoint joinPoint) {
    	logger.info(DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss") 
				+ " | " +"AOP Before:"+joinPoint.getSignature().getDeclaringType()+
					" method: "+joinPoint.getSignature().getName());
    	
    	ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		HttpServletRequest request = attributes.getRequest();
		StringBuffer requestURL =   request.getRequestURL();
		String mothod = request.getMethod();
		String addr = request.getRemoteAddr();
		Map<String,String[]> map = request.getParameterMap();
		logger.info("HTTP连接信息：requestURL ： "+requestURL+" mothod: "+mothod+" addr:"+addr+" params:"+map
				+"class_method="+joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName()
				+"args="+ joinPoint.getArgs());
    }
    
    @AfterReturning(pointcut=("controllerLog()"),returning="retval")
    public void after(JoinPoint joinPoint,Object retval) {
    	logger.info(DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss") 
    			+ " | " +"AOP AfterReturning:Object"+ retval.getClass().getSimpleName());
    }

}
