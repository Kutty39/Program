package com.blbz.singleton.serviceimpl;

import com.blbz.singleton.service.ExampleClass;

import java.io.Serializable;

public class ExampleImplSerWithResolver implements ExampleClass,Serializable {
    private int i;
    private static final long serialVersionUID = -7604766932017737115L;
    private ExampleImplSerWithResolver(){}
    private static class Helper{
        private final static ExampleClass ec=new ExampleImplSerWithResolver();
    }
    public static ExampleClass getInstance(){

        return Helper.ec;
    }
    protected Object readResolve() {
        return getInstance();
    }
    public String  getI() {
        return ""+i;
    }

    public void setI(int i) {
        this.i = i;
    }

    @Override
    public String simpletextwithvalue(int i) {
        this.i=i+this.i;
        return "Increment value is "+this.i;
    }
}
