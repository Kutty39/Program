package com.blbz.singleton.controller;

import com.blbz.singleton.model.*;
import com.blbz.singleton.service.ExampleClass;
import com.blbz.singleton.serviceimpl.ExampleImplEnum;
import com.blbz.singleton.serviceimpl.ExampleImplSer;
import com.blbz.singleton.serviceimpl.ExampleImplSerWithResolver;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Scanner;

public class Singleton{
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Scanner sc =new Scanner(System.in);
        int choice=0;
        while (choice==0){
            System.out.println("1.Eager\n2.Lazy\n3.Static Block\n4.BillPugh\n5.Serialized\n6.Enum\n7.Reflection\n0.Exit");
            choice=sc.nextInt();
            switch (choice){
                case 1:
                    ExampleClass ec= Eaget.getInstance();
                    ec.simpletextwithvalue(1);
                    System.out.println("First Class value:"+ ec.getI());
                    ExampleClass ec1= Eaget.getInstance();
                    ec1.simpletextwithvalue(1);
                    System.out.println("Second Class value:"+ ec1.getI());
                    break;
                case 2:
                    ExampleClass lec= Lazy.getInstance();
                    lec.simpletextwithvalue(1);
                    System.out.println("First Class value:"+ lec.getI());
                    ExampleClass lec1= Lazy.getInstance();
                    lec1.simpletextwithvalue(1);
                    System.out.println("Second Class value:"+ lec1.getI());
                    break;
                case 3:
                    ExampleClass sec= StaticBlock.getInstance();
                    sec.simpletextwithvalue(1);
                    System.out.println("First Class value:"+ sec.getI());
                    ExampleClass sec1= StaticBlock.getInstance();
                    sec1.simpletextwithvalue(1);
                    System.out.println("Second Class value:"+ sec1.getI());
                    break;
                case 4:
                    ExampleClass bec= BillPugh.getInstance();
                    bec.simpletextwithvalue(1);
                    System.out.println("First Class value:"+ bec.getI());
                    ExampleClass bec1= BillPugh.getInstance();
                    bec1.simpletextwithvalue(1);
                    System.out.println("Second Class value:"+ bec1.getI());
                    break;
                case 5:
                    ExampleClass srec= ExampleImplSer.getInstance();
                    srec.simpletextwithvalue(1);
                    System.out.println("First Class value:"+ srec.getI());
                    ExampleClass srec1= ExampleImplSer.getInstance();
                    srec1.simpletextwithvalue(1);
                    System.out.println("Second Class value:"+ srec1.getI());
                    ObjectOutput Opt=new ObjectOutputStream(new FileOutputStream("obj1.ser"));
                    Opt.writeObject(srec);
                    ObjectInput opi=new ObjectInputStream(new FileInputStream("obj1.ser"));
                    ExampleClass sreco=(ExampleClass) opi.readObject();
                    System.out.println("Without Resolver");
                    System.out.println(srec.hashCode());
                    System.out.println(sreco.hashCode());

                    ExampleClass srecr= ExampleImplSerWithResolver.getInstance();
                    ObjectOutput Optr=new ObjectOutputStream(new FileOutputStream("obj2.ser"));
                    Optr.writeObject(srecr);
                    ObjectInput opir=new ObjectInputStream(new FileInputStream("obj2.ser"));
                    ExampleClass srecor=(ExampleClass) opir.readObject();
                    System.out.println("With Resolver");
                    System.out.println(srecr.hashCode());
                    System.out.println(srecor.hashCode());
                    break;
                case 6:
                    ExampleImplEnum.simpletextwithvalue(1);
                    System.out.println(ExampleImplEnum.getI());
                    ExampleImplEnum.simpletextwithvalue(1);
                    System.out.println(ExampleImplEnum.getI());
                    break;
                case 7:
                    Lazy1 ecR = Lazy1.getInstance();
                    Lazy1 ecR2=null;
                    try {
                        Constructor constructor=Lazy1.class.getDeclaredConstructor();
                        constructor.setAccessible(true);
                         ecR2=(Lazy1) constructor.newInstance();
                    } catch (NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
                        e.printStackTrace();
                    }
                    System.out.println(ecR.hashCode());
                    System.out.println(ecR2.hashCode());
                    break;
                default:
                    break;
            }
        }

    }
}