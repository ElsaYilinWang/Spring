package com.elsa.AOPdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {


    @Before("com.elsa.AOPdemo.aspect.AopExpressions.forDaoPackageNoGetterSetter()")
    // in the package, optional modifier, any Return type, any method, any params
    public void beforeAddAccountAdvice(){

        System.out.println("\n=====>>> Executing @Before advice on method");
    }

}
