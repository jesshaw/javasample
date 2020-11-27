package com.lexiangmiao.sample.springframework.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * spring 5 或者 spring boot 2
 *
 * --------------------------------------
 * AOP 正常顺序
 * ***** @Around 我是环绕通知之前 around
 * ***** @Before 我是前置通知
 *    ======计算结果 5
 * ***** @AfterReturning 我是返回后通知
 * ***** @After 我是后置通知
 * ***** @Around 我是环绕通知之后 around
 *
 * AOP 异常顺序
 * ***** @Around 我是环绕通知之前 around
 * ***** @Before 我是前置通知
 * ***** @AfterThrowing 我是异常通知
 * ***** @After 我是后置通知
 * --------------------------------------
 *
 *
 * spring 4 或者 spring boot 1
 *
 * --------------------------------------
 * AOP 正常顺序
 * ***** @Around 我是环绕通知之前 around
 * ***** @Before 我是前置通知
 *    ======计算结果 5
 * ***** @Around 我是环绕通知之后 around
 * ***** @After 我是后置通知
 * ***** @AfterReturning 我是返回后通知
 *
 * AOP 异常顺序
 * ***** @Around 我是环绕通知之前 around
 * ***** @Before 我是前置通知
 * ***** @After 我是后置通知
 * ***** @AfterThrowing 我是异常通知
 * --------------------------------------
 */
@Aspect
@Component
public class CalcAspect {
    @Before("execution(public int com.lexiangmiao.sample.springframework.aop.CalcServiceImpl.*(..))")
    public void beforeNotify() {
        System.out.println("***** @Before 我是前置通知");
    }

    @After("execution(public int com.lexiangmiao.sample.springframework.aop.CalcServiceImpl.*(..))")
    public void afterNotify() {
        System.out.println("***** @After 我是后置通知");
    }

    @AfterReturning("execution(public int com.lexiangmiao.sample.springframework.aop.CalcServiceImpl.*(..))")
    public void afterReturningNotify() {
        System.out.println("***** @AfterReturning 我是返回后通知");
    }

    @AfterThrowing("execution(public int com.lexiangmiao.sample.springframework.aop.CalcServiceImpl.*(..))")
    public void afterThrowingNotify() {
        System.out.println("***** @AfterThrowing 我是异常通知");
    }

    @Around("execution(public int com.lexiangmiao.sample.springframework.aop.CalcServiceImpl.*(..))")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Object retValue = null;
        System.out.println("***** @Around 我是环绕通知之前 around");
        retValue = proceedingJoinPoint.proceed();
        System.out.println("***** @Around 我是环绕通知之后 around");
        return retValue;
    }
}
