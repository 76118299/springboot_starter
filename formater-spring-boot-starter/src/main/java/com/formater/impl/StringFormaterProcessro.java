package com.formater.impl;

import com.formater.FormaterProcessor;

public class StringFormaterProcessro implements FormaterProcessor {
    public <T> String formater(T obj) {
        return "Strong FORMATER";
    }
}
