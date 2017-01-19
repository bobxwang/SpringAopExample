package com.bob.agent;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Created by bob on 16/1/19.
 */
public class CGLibDynamicProxy implements MethodInterceptor {

    private static class CGLibDynamicProxyHolder {
        private static CGLibDynamicProxy instance = new CGLibDynamicProxy();
    }

    private CGLibDynamicProxy() {
    }

    public static CGLibDynamicProxy getInstance() {
        return CGLibDynamicProxyHolder.instance;
    }

    @SuppressWarnings("unchecked")
    public <T> T getProxy(Class<T> clasz) {
        return (T) Enhancer.create(clasz, this);
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        before();
        Object result = methodProxy.invokeSuper(o, objects);
        after();
        return result;
    }

    private void before() {
        System.out.println("Before");
    }

    private void after() {
        System.out.println("After");
    }
}