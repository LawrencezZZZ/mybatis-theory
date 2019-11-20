package com.demo.config;

import com.demo.dao.UserMapper;
import com.demo.mybatis.MyFactoryBean;
import com.demo.mybatis.MyMapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({"com.demo"})
@MyMapperScan({"com.demo.dao"})
public class AppConfig {
    // 单个mapper注册
//    @Bean
//    public MyFactoryBean<UserMapper> userMapper() {
//        MyFactoryBean<UserMapper> bean = new MyFactoryBean(UserMapper.class);
//        return bean;
//    }
}
