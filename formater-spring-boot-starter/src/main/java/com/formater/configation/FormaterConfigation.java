package com.formater.configation;

import com.formater.FormaterProcessor;
import com.formater.impl.JSONFormaterProcessor;
import com.formater.impl.StringFormaterProcessro;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * 配置formate Bean
 */
@Configuration
public class FormaterConfigation {
   @ConditionalOnMissingClass("com.alibaba.fastjson.JSON")
    @Bean
    @Primary
    public FormaterProcessor stringFormater(){
        return  new StringFormaterProcessro();
    }
    @ConditionalOnClass(name="com.alibaba.fastjson.JSON")
    @Bean
    public FormaterProcessor jsonFormater(){
        return  new JSONFormaterProcessor();
    }

}
