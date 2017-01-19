package com.bob.agent;

/**
 * Created by bob on 16/1/19.
 */
public class HelloImpl implements Hello {

    @Override
    public void sayHello(String name, String msg) {
//        before();
        System.out.println(name + "," + msg);
//        after();
    }

    private void before() {
        System.out.println("Before");
    }

    private void after() {
        System.out.println("After");
    }
}