package com.simple.basic.util.aop;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect // AOP 클래스
@Component // 이 클래스는 component-scan에 읽혀서 bean으로 생성됨
public class LogAdvice {

    // 해당 클래스에서 로그를 사용함 (base패키지 밑에 존재해야 사용합니다.)
    public static final Logger log = LoggerFactory.getLogger(LogAdvice.class);

    @Before("execution(* com.simple.basic.controller.*Controller.*(..))")
    // @Before("execution(* com.simple.basic.service.score.*ScoreServiceImpl.*(..))")
    public void beforeLog() {
        System.out.println("--메서드 실행 전 동작--");
    }

    @After("execution(* com.simple.basic.controller.*Controller.*(..))")
    // @After("execution(* com.simple.basic.service.score.*ScoreServiceImpl.*(..))")
    public void afterLog() {
        System.out.println("--메서드 실행 후 동작 --");
    }

    @AfterThrowing(pointcut = "execution(* com.simple.basic.service.score.*ScoreServiceImpl.*(..))", throwing = "e")
    public void exceptionLog(Exception e) {
        System.out.println("advice 에러로그 : " + e);
    }

    @Around("execution(* com.simple.basic.service.score.*ScoreServiceImpl.*(..))")
    public Object aroundLog(ProceedingJoinPoint jp) {
        long start = System.currentTimeMillis();
        log.info("실행 클래스 : " + jp.getTarget());
        log.info("실행 메서드 :" + jp.getSignature().toString());
        log.info("매개값 : " + Arrays.toString(jp.getArgs()));

        Object result = null;

        try {
            // before
            result = jp.proceed(); // 타겟 메서드의 실행
            // after

            long end = System.currentTimeMillis();
            log.info("실행시간 : " + (end - start) * 0.001);

            String path = "C:\\Users\\user\\Desktop\\course\\spring\\spring_log\\08.06_log.txt";
            BufferedWriter bos = new BufferedWriter(new FileWriter(path, true));

            bos.write("매개값 : " + jp.getTarget() + "\n");
            bos.write("실행 클래스 : " + jp.getTarget() + "\n");
            bos.write("실행 메서드 :" + jp.getSignature().toString() + "\n");
            bos.write("매개값 : " + Arrays.toString(jp.getArgs()) + "\n");
            bos.write("실행시간 : " + (end - start) * 0.001 + "\n");
            bos.flush();
            bos.close();

        } catch (Throwable e) {
            log.error("에러 발생 : ", e);
        }

        return result; // 메서드의 정상 흐름으로 돌아갑니다.
    }
}
