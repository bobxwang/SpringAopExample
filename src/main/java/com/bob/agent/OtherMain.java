package com.bob.agent;

/**
 * Created by bob on 16/1/19.
 */
public class OtherMain {

    public static void main(String[] args) {

        Hello jdkHello = new JDKDynamicProxy(new HelloImpl()).getProxy();
        jdkHello.sayHello("bob", "How r u");

        System.out.println("\r\n------\r\n");

        Hello cglHello = CGLibDynamicProxy.getInstance().getProxy(HelloImpl.class);
        cglHello.sayHello("Jack", "H r u");

        /**
         * 上面都是对这个接口或者类的所有方法进行了拦截,因为整个类被代理了,比较武断,如果我只想对里面的某个方法
         * 进行拦截,那么就要在里面判断那个method
         *
         * 在这,spring提出了一个Advisor(切面)的概念,通过它将增强类与拦截匹配条件组合在一起,在这拦截的匹配条件叫做Pointcut(切点)
         * 所以,Advisor = Advice(增强) + Pointcut
         *
         * CGLib创建代理的速度比较慢,但创建代理后运行的速度却非常快,因为它是相当于改写class文件,而JDK代理则正好相反
         *
         * JoinPoint(连接点),通过它可获得方法的任何信息,比如方法名,参数等
         */

    }
}