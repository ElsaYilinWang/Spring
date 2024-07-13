package com.elsa.springboot.mvccrud.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class DemoLoggingAspect {

    // set up logger
    private Logger myLogger = Logger.getLogger(getClass().getName());

    // set up pointcut declarations
    @Pointcut("execution(* com.elsa.springboot.mvccrud.controller.*.*(..))")
    private void forControllerPackage(){}

    // set up pointcut declarations
    @Pointcut("execution(* com.elsa.springboot.mvccrud.service.*.*(..))")
    private void forServicePackage(){}

    @Pointcut("execution(* com.elsa.springboot.mvccrud.dao.*.*(..))")
    private void forDaoPackage() {}

    @Pointcut("forControllerPackage() || forServicePackage() || forDaoPackage()")
    private void forAppFlow() {}

    // add @Before advice
    @Before("forAppFlow()")
    public void before(JoinPoint theJoinPoint){

        // display method we are calling
        String method = theJoinPoint.getSignature().toShortString();
        myLogger.info("=====>> in @Before: calling method: " + theMethod);

        // display the arguments to the method

        // get the arguments
        Object[] args = theJoinPoint.getArgs();
)
        // loop thru and display args
        for (Object tempArg : args) {
            myLogger.info("=====>> argument: " + tempArg);
        }
    }

    // add @AfterReturning advice
    @AfterReturning(
            pointcut = "forAppFlow()",
            returning = "theResult")
    public void afterReturning(JoinPoint theJoinPoint, Object theResult){

        // display method we are returning from
        String theMethod = theJoinPoint.getSignature().toShortString();

        myLogger.info("=====>> in @AfterReturning: from method: " + theMethod);

        // display data returned
        myLogger.info("=====>> result: " + theResult);
    }
}
