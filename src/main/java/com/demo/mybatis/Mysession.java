package com.demo.mybatis;

import java.lang.reflect.Proxy;

public class Mysession {
    public <T> T getMapper(Class<T> type) {
        return (T)Proxy.newProxyInstance(Mysession.class.getClassLoader(), new Class[]{type}, new MyInvocationHandler());
    }
}
