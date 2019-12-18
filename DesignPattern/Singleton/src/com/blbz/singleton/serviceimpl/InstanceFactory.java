package com.blbz.singleton.serviceimpl;

import com.blbz.singleton.model.BillPugh;
import com.blbz.singleton.model.Eaget;
import com.blbz.singleton.model.Lazy;
import com.blbz.singleton.model.StaticBlock;
import com.blbz.singleton.service.ExampleClass;

public class InstanceFactory {

    public static ExampleClass getInstace(int i){
        switch (i){
            case 1:
               return Eaget.getInstance();
            case 2:
                return Lazy.getInstance();

            case 3:
                return StaticBlock.getInstance();

            case 4:
                return BillPugh.getInstance();
            case 5:
                return ExampleImplSerWithResolver.getInstance();
            default:
                return null;
        }
    }
}
