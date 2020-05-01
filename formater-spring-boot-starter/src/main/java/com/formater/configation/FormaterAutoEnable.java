package com.formater.configation;

import com.formater.FormaterProcessor;
import com.formater.FormaterTemplate;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * 自动装配 配置类
 * SPI配置
 * 配置到META-INFO/spring.factories 文件中
 */
@Configuration
@Import(FormaterConfigation.class)
@EnableConfigurationProperties(FormaterProperties.class) //启用properties 将propertie 配置得内容加载到FormaterProperties中
public class FormaterAutoEnable {
    @Bean
    public FormaterTemplate formaterTemplate(FormaterProcessor processor,FormaterProperties properties){
        return  new FormaterTemplate(processor,properties);
    }
}
