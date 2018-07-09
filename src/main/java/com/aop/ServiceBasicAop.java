package com.aop;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * service层基础处理
 * @author heyanzhu
 *
 */
@Order(10)
@Component
@Aspect
public class ServiceBasicAop {

	private static final  Logger log = Logger.getLogger(ServiceBasicAop.class);
	
	@Pointcut("execution(* com.controller.*Controller.*(..))")
	public void FindFuncExpression() {}
	
	/**
	 * 环绕通知
	 * 针对所有service曾的Find函数进行处理
	 * 1.输出日志
	 * 2.返回空值
	 * @param joinPoint
	 * @param ex
	 */
	@Around("FindFuncExpression()")
	public Object ServiceExctionForFind(ProceedingJoinPoint proceedingJoinPoint){
	    
		String MethodName = proceedingJoinPoint.getSignature().getName();
		log.info("Method "+MethodName+" Start");
		Object Result = null;
		try {
			Result = proceedingJoinPoint.proceed();
		} catch (Throwable e) {
			log.error("Method "+MethodName+" have a expection is "+e.toString());
		}
		log.info("Method "+MethodName +" end");
		return Result;
	}
}
