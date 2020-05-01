package com.formater;

import com.formater.configation.FormaterProperties;

public class FormaterTemplate {

    private FormaterProcessor processor;
    private FormaterProperties properties;

    public FormaterTemplate(FormaterProcessor processor, FormaterProperties properties) {
        this.processor = processor;
        this.properties = properties;
    }


    public <T> String doFormater(T obj){
        String infos = properties.getInfo().toString();
        System.out.printf(infos);
        return  processor.formater(obj);
    }
}
