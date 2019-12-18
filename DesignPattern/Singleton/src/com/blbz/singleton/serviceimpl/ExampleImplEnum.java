package com.blbz.singleton.serviceimpl;

import com.blbz.singleton.service.ExampleClass;

import java.io.Serializable;

public enum ExampleImplEnum {
    INSTANCE;
    private static int i;
    public static int getI(){
        return ExampleImplEnum.i;
    }
    public static String simpletextwithvalue(int i) {
        ExampleImplEnum.i = i + ExampleImplEnum.i;
        return "Increment value is " + ExampleImplEnum.i;
    }
}
