package com.demo.mybatis;

import org.springframework.beans.factory.FactoryBean;

public class MyFactoryBean<T> implements FactoryBean<T> {

    private Class<T> mapper;

    public MyFactoryBean(Class<T> mapper) {
        this.mapper = mapper;
    }

    public T getObject() throws Exception {
        return Mysession.getMapper(this.mapper);
    }

    public Class<T> getObjectType() {
        return this.mapper;
    }

}
