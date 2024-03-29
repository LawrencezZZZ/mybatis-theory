package com.demo.mybatis;

import org.apache.ibatis.annotations.Select;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyInvocationHandler implements InvocationHandler {
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        Select annotation = method.getAnnotation(Select.class);
        if(annotation != null ){
            String str = annotation.value()[0];
            System.out.println("sql:" + str);
        }
        if("toString".equals(method.getName())){
            return proxy.getClass().getInterfaces()[0].getName();
        }
        // TODO jdbc链接 sql提交
        return null;
    }
}
