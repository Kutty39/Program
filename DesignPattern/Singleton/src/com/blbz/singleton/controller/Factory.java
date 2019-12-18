package com.blbz.singleton.controller;

import com.blbz.singleton.service.ExampleClass;
import com.blbz.singleton.serviceimpl.InstanceFactory;

import java.util.Scanner;

public class Factory {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        System.out.println("1.Eager\n2.Lazy\n3.Static Block\n4.BillPugh\n5.Serialized");
        int choice=sc.nextInt();
         ExampleClass ec= InstanceFactory.getInstace(choice);
        assert ec != null;
        ec.simpletextwithvalue(1);
        System.out.println(ec.getI());
    }
}
