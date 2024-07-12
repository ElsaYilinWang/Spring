package com.elsa.AOPdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AopExpressions {

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

}
