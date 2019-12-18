package com.blbz.singleton.model;

import com.blbz.singleton.service.ExampleClass;
import com.blbz.singleton.serviceimpl.ExampleImpl;

public class Lazy1 {
    private static Lazy1 ec=null;
    private Lazy1(){}
    public static Lazy1 getInstance(){
        ec=ec==null?(new Lazy1()):ec;
        return ec;
    }
}