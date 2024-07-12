package com.elsa.AOPdemo.aspect;

import com.elsa.AOPdemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import org.aspectj.lang.reflect.MethodSignature;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {


    @Before("com.elsa.AOPdemo.aspect.AopExpressions.forDaoPackageNoGetterSetter()")
    // in the package, optional modifier, any Return type, any method, any params
    public void beforeAddAccountAdvice(JoinPoint theJoinPoint){

        System.out.println("\n=====>>> Executing @Before advice on method");

        // display the method signature
        MethodSignature methodSignature = (MethodSignature) theJoinPoint.getSignature();

        System.out.println("Method: " + methodSignature);

        // display method arguments

        // get args
        Object[] args = theJoinPoint.getArgs();

        // loop through args
        for (Object tempArg: args){

            System.out.println(tempArg);

            if (tempArg instanceof Account){

                // downcast and print Account specific stuff
                Account theAccount = (Account) tempArg;

                System.out.println("account name: " + theAccount.getName());
                System.out.println("account level: " + theAccount.getLevel());
            }
        }
    }

}
