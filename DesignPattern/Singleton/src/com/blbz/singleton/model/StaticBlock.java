package com.blbz.singleton.model;

import com.blbz.singleton.service.ExampleClass;
import com.blbz.singleton.serviceimpl.ExampleImpl;

public class StaticBlock {
    private static ExampleClass ec;

    static {
        try {
            ec = new ExampleImpl();
        } catch (Exception e) {
            System.out.println("Exception");
        }
    }
    private StaticBlock(){}
    public static ExampleClass getInstance(){
        return ec;
    }
}
