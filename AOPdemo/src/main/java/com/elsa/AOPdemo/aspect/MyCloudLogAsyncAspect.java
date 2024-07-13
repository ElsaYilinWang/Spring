package com.elsa.AOPdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class MyCloudLogAsyncAspect {

    @Before("com.elsa.AOPdemo.aspect.AopExpressions.forDaoPackageNoGetterSetter()")
    // in the package, optional modifier, any Return type, any method, any params
    public void logToCloudAsync(){

        System.out.println("\n=====>>> Logging to Cloud in async fashion");
    }


}
