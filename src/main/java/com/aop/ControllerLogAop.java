package com.aop;

import java.util.Arrays;
import java.util.List;
import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import com.service.ComputerService;
import com.service.InterceptedLogService;
import com.util.ServerTool;
import com.util.StrUtil;

@Component
@Aspect
@Order(10)
public class ControllerLogAop {

	private Logger log = Logger.getLogger(ControllerLogAop.class);
	
	@Autowired
	private ComputerService computerService;
	
	@Autowired
	private InterceptedLogService interceptedLogService;
	
	/**
	 * 拦截controller下所有的请求
	 */
	@Pointcut("execution(* com.controller.*Controller.*(..))")
	public void FindFuncExpression() {}
	
	/**
	 * 1.监测异常，输出错误
	 * 2.记录请求的参数
	 * 3.准入机制，判断访问的Ip（查询Pass_Computer表信息）
	 * @param proceedingJoinPoint
	 * @return
	 */
	@Around(value="FindFuncExpression()")
	public Object ControllerAround(ProceedingJoinPoint proceedingJoinPoint){
		Object Result = null;
		String MethodName = proceedingJoinPoint.getSignature().getName();
		List<Object> Args = Arrays.asList(proceedingJoinPoint.getArgs());
		
		//HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		String Url = ServerTool.GetUrl();
		
		//获取IP
		String Ip = ServerTool.GetClientIp();
		
		//判断IP是否可通行IP
		boolean IpCheck = computerService.FindByIP(Ip)||Ip.equals("127.0.0.1");
		
		if(StrUtil.IsNotNullOrBank(Url)&&IpCheck){
			log.info("Controller Url is "+Url+" and Args is "+ Args);//记录请求信息
			try {
				Result = proceedingJoinPoint.proceed();
			} catch (Throwable e) {
				log.error("Method "+MethodName+" and the args is"+ Args +" Error: "+e.toString());
				e.printStackTrace();
			}
		}else{
			log.info("the ip is "+Ip+" be intercepted");
			//把拦截的Ip写入数据库，先判断是否已经存在记录
			interceptedLogService.SaveInterceptedComputer(Ip, Url);
		}
		log.info("Controller Url is "+Url+" and result is "+Result.toString());
		return Result;
	}
}
