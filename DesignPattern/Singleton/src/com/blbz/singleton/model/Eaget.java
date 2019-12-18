package com.blbz.singleton.model;

import com.blbz.singleton.service.ExampleClass;
import com.blbz.singleton.serviceimpl.ExampleImpl;

public class Eaget {
    private static ExampleClass ec=new ExampleImpl();
    private Eaget(){

    }
    public static ExampleClass getInstance(){
        return ec;
    }
}
