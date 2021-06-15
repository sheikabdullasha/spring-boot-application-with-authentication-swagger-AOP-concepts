package com.sample.demo.logging;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;  
@Aspect
@Component
public class ApplicationLoggerAspect {
	private final Logger log=LoggerFactory.getLogger(ApplicationLoggerAspect.class);

	@Pointcut("within(com.sample.app.controller..*)")
	public void definePackagePointcuts() {
		
	}
	
	@Around("definePackagePointcuts()")
	public Object log(ProceedingJoinPoint jp){
		log.debug("\n \n \n ");
		log.debug("********Before method execution****** \n {}.{} () with arguments[s] = {}",
		jp.getSignature().getDeclaringTypeName(),
		jp.getSignature().getName(),Arrays.toString(jp.getArgs()));
		log.debug("__________________________________________________ \n \n \n");
		
		Object o =null;
		try {
			o=jp.proceed();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		log.debug("********After method execution****** \n {}...{} () with arguments[s] = {}",
				jp.getSignature().getDeclaringTypeName(),
				jp.getSignature().getName(),Arrays.toString(jp.getArgs()));
				log.debug("__________________________________________________ \n \n \n");
				return o;
		
	}
	
	
}
