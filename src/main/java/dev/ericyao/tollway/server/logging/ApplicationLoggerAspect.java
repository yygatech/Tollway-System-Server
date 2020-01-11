package dev.ericyao.tollway.server.logging;

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
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Pointcut("within(dev.ericyao.tollway.server.controller..*)")
	public void controllerPackagePointcuts() {
		
	}
	
	@Around("controllerPackagePointcuts()")
	public Object logAround(ProceedingJoinPoint jp) {
		log.debug("\n\n");
		log.debug("*************** Before Method Execution ***************\n"
				+ "{}.{}() with argument[s] = {}",
				jp.getSignature().getDeclaringTypeName(),
				jp.getSignature().getName(),
				Arrays.toString(jp.getArgs()));
		log.debug("_______________________________________________________\n\n");
	
		Object o = null;
		
		try {
			o = jp.proceed();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		
		log.debug("\n\n");
		log.debug("*************** After Method Execution ***************\n"
				+ "{}.{}() with argument[s] = {}",
				jp.getSignature().getDeclaringTypeName(),
				jp.getSignature().getName(), 
				Arrays.toString(jp.getArgs()));
		log.debug("______________________________________________________\n\n");
		
		return o;
	}
}
