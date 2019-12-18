package com.blbz.singleton.model;

import com.blbz.singleton.service.ExampleClass;
import com.blbz.singleton.serviceimpl.ExampleImpl;

public class Lazy {
    private static ExampleClass ec=null;
    private Lazy(){}
    public static ExampleClass getInstance(){
        ec=ec==null?(new ExampleImpl()):ec;
        return ec;
    }
}
