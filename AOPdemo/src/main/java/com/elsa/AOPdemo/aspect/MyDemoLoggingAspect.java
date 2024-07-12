package com.elsa.AOPdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

    // this is where we add all of our related advices for logging

    // @Pointcut declarations
    @Pointcut("execution(* com.elsa.AOPdemo.dao.*.*(..)")
    private void forDaoPackage(){}

    // create a pointcut for getter methods
    @Pointcut("execution(* com.elsa.AOPdemo.dao.*.get*(..)")
    private void getter(){}

    // create a pointcut for setter methods
    @Pointcut("execution(* com.elsa.AOPdemo.dao.*.set*(..)")
    private void setter(){}

    // create pointcut: include package ... exclude getter/setter
    @Pointcut("forDaoPackage() && !(getter() || setter())")
    private void forDaoPackageNoGetterSetter(){}

    // @Before("execution(public void addAccount()")
    @Before("forDaoPackageNoGetterSetter()")
    // in the package, optional modifier, any Return type, any method, any params
    public void beforeAddAccountAdvice(){

        System.out.println("\n=====>>> Executing @Before advice on method");
    }

    @Before("forDaoPackage()")
    public void performApiAnalytics(){

        System.out.println("\n=====>>> Performing API analytics");
    }
}
