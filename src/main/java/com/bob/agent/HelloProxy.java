package com.bob.agent;

/**
 * Created by bob on 16/1/19.
 */
public class HelloProxy implements Hello {

    private HelloImpl hello;

    /**
     * 静态代理,但问题是***Proxy类系统中会越来越多,我们不希望这样,因此产生动态代理
     *
     * @param hello
     */
    public HelloProxy(HelloImpl hello) {
        this.hello = hello;
    }

    @Override
    public void sayHello(String name, String msg) {
        before();
        hello.sayHello(name, msg);
        after();
    }

    private void before() {
        System.out.println("Before");
    }

    private void after() {
        System.out.println("After");
    }
}
