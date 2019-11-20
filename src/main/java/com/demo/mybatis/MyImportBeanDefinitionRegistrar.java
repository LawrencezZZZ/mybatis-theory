package com.demo.mybatis;

import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.core.type.AnnotationMetadata;

import java.io.File;
import java.net.URL;

public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {

    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        AnnotationAttributes mapperScanAttrs = AnnotationAttributes.fromMap(importingClassMetadata.getAnnotationAttributes(MyMapperScan.class.getName()));
        // 获取MyMapperScan的value即包名的数组
        String[] values = (String[]) mapperScanAttrs.get("value");

        // 获取包下所有的文件
        ClassLoader classLoader = MyImportBeanDefinitionRegistrar.class.getClassLoader();
        URL url = classLoader.getResource(values[0].replace(".", "/"));
        File file = new File(getRootPath(url));
        String[] names = file.list();

        for (String name : names) {
            int pos = name.indexOf('.');
            if (-1 != pos) {
                // UserMapper.class -> UserMapper
                name = name.substring(0, pos);
            }
            BeanDefinitionBuilder builder = BeanDefinitionBuilder.genericBeanDefinition(MyFactoryBean.class);
            AbstractBeanDefinition beanDefinition = builder.getBeanDefinition();
            // com.demo.dao.UserMapper
            beanDefinition.getConstructorArgumentValues().addGenericArgumentValue(values[0] + "." + name);
            // UserMapper - > userMapper
            String beanName = name.substring(0, 1).toLowerCase().concat(name.substring(1));
            registry.registerBeanDefinition(beanName, beanDefinition);

        }

    }

    public String getRootPath(URL url) {
        String fileUrl = url.getFile();
        int pos = fileUrl.indexOf('!');

        if (-1 == pos) {
            return fileUrl;
        }

        return fileUrl.substring(5, pos);
    }
}
