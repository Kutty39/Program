package com.blbz.singleton.serviceimpl;

import com.blbz.singleton.service.ExampleClass;

import java.io.Serializable;

public class ExampleImpl implements ExampleClass,Serializable {
    private int i;
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
