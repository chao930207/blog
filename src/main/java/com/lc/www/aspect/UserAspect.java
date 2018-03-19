package com.lc.www.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class UserAspect {

	@Before("execution(* com.lc.www.service.impl.UserServiceImpl.check*(..))")
	public void checkNameBeforeAspect() {
		System.out.println("check before aspect");
	}

	@After("execution(* com.lc.www.service.impl.UserServiceImpl.query*(..))")
	public void queryAfterAspect() {
		System.out.println("query after aspect");
	}

	@Around("execution(* com.lc.www.service.impl.UserServiceImpl.validate*(..))")
	public Object validateArroundAspect(ProceedingJoinPoint jp) throws Throwable {
		System.out.println("环绕前");
		System.out.println("方法" + jp.getSignature());
		Object result = jp.proceed();
		System.out.println(result);
		System.out.println("环绕后");
		return result;
	}
}
