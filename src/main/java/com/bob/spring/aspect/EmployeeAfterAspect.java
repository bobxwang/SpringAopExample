package com.bob.spring.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class EmployeeAfterAspect {

    @After("args(name)")
    public void logStringArguments(String name) {
        System.out.println("Running After Advice. String argument passed=" + name);
    }

    @AfterThrowing("within(com.bob.spring.model.Employee)")
    public void logExceptions(JoinPoint joinPoint) {
        System.out.println("Exception thrown in Employee Method=" + joinPoint.toString());
    }

    /**
     * 返回后增强,也可理解为Finally增强,相当于finally语句,是在方法结束后执行,也就是说它比@After还要再晚一些
     *
     * @param returnString
     */
    @AfterReturning(pointcut = "execution(* getName())", returning = "returnString")
    public void getNameReturningAdvice(String returnString) {
        System.out.println("getNameReturningAdvice executed. Returned String=" + returnString);
    }
}