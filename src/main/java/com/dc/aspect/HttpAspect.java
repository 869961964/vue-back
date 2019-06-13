package com.dc.aspect;

import java.util.Arrays;

import javax.servlet.ServletRequest;
import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.http.HttpServletRequest;

import org.apache.tomcat.util.http.fileupload.RequestContext;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import lombok.extern.slf4j.Slf4j;

@Aspect //声明为切面类
@Component
@Slf4j
public class HttpAspect {
	
	@Pointcut("execution(public * com.dc.web.*.*(..))")
    public void webLog(){}
	@Before("webLog()")
    public void before(JoinPoint joinPoint){
		//url
		ServletRequestAttributes attributes= (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		HttpServletRequest request =  attributes.getRequest();
		log.info("url={}",request.getRequestURL());
		//method
		log.info("method={}",request.getMethod());
		//ip
		log.info("ip={}",request.getRemoteAddr());
		//类
		 log.info("CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
	     //参数   
		 log.info("ARGS : " + Arrays.toString(joinPoint.getArgs()));

    }
	@After("webLog()")
	public void adter() {
		log.info("2222222222");
	}
	@AfterReturning(returning = "ret",pointcut = "webLog()")
    public void doAfterReturning(Object ret) throws Throwable {
        // 处理完请求，返回内容
        log.info("RESPONSE : " + ret);
    }

}
