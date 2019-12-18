package com.blbz.singleton.model;

import com.blbz.singleton.service.ExampleClass;
import com.blbz.singleton.serviceimpl.ExampleImpl;

public class BillPugh {
    private BillPugh(){}
    private static class Helper{
        private final static ExampleClass ec=new ExampleImpl();
    }
    public static ExampleClass getInstance(){

        return Helper.ec;
    }
}
