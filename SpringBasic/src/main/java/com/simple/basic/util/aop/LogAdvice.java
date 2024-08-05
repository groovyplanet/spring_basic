package com.simple.basic.util.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect // AOP 클래스
@Component // 이 클래스는 component-scan에 읽혀서 bean으로 생성됨
public class LogAdvice {

	// Advice - 공통 기능
	// Pointcut - Advice를 적용할 메서드에 대해 정의하는 규칙

//    @Before("execution(* com.simple.basic.controller.*Controller.*(..))")
//	@Before("execution(* com.simple.basic.service.score.*ScoreServiceImpl.*(..))")
	public void beforeLog() {
		System.out.println("--메서드 실행 전 동작--");

	}

//    @After("execution(* com.simple.basic.controller.*Controller.*(..))")
//	@After("execution(* com.simple.basic.service.score.*ScoreServiceImpl.*(..))")
	public void afterLog() {
        System.out.println("--메서드 실행 후 동작 --");
    }

//	@AfterThrowing(pointcut = "execution(* com.simple.basic.service.score.*ScoreServiceImpl.*(..))",throwing="e" // 에러를 처리할 변수명)

	public void exceptionLog(Exception e) {
		System.out.println("advice 에러로그 : " + e);
	}
	
//	@Around - after,before,afterThrowing 세가지를 결합해서 , 처리할 수 있게 해주는 어노테이션
//	규칙 - 반환은 Object로 만들고 , 매개변수로 실행 시점을 결정지어줄 수 있는 ProceedingJoinPoint를 선언합니다.
	@Around("execution(* com.simple.basic.service.score.*ScoreServiceImpl.*(..))")
	public Object aroundLog(ProceedingJoinPoint jp) {
		
		/*
		 * 메서드로 넘어오는 매개변수 확인 가능
		 * 메서드 실행되는 target 확인 가능
		 * 이런 결과를 수집해서 , 전체 log로 찍어주거나 FileOutput을 이용해서 실행로그 출력을 해줄 수 있음.
		 */
		
		
		Object result = null;
		
		try {
		
			result = jp.proceed(); //타겟 메서드의 실행
			
			
		} catch (Throwable e) {
			e.printStackTrace(); //해당 메서드에서 에러가 발생하면 , 이 친구가 로그를 같이 찍음
		}

	return result; // 메서드의 정상 흐름으로 돌아갑니다.
	}
	

}
