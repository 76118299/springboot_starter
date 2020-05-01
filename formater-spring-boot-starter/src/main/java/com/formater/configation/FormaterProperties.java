package com.formater.configation;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.HashMap;
import java.util.Map;

@ConfigurationProperties(prefix = "formater.info")
public class FormaterProperties {

    public Map<String, Object> getInfo() {
        return info;
    }

    public void setInfo(Map<String, Object> info) {
        this.info = info;
    }

    private Map<String,Object> info = new HashMap<String, Object>();


}
