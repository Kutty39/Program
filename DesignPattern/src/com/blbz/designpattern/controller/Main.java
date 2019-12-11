package com.blbz.designpattern.controller;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        observer os=new ObservingCenter();
        os.registerObservees(new User());
        os.registerObservees(new Sellar());
        os.registerObservees(new Warehouse());

        os.notifyObservees("Hi");
    }
}

interface observer {
    void registerObservees(Observees observee);

    void deRegister(Observees observee);

    void notifyObservees(String change);
}

class ObservingCenter implements observer {
    private List<Observees> allobs;

    public ObservingCenter() {
        this.allobs = new ArrayList<>();
    }

    @Override
    public void registerObservees(Observees observee) {
        allobs.add(observee);
    }

    @Override
    public void deRegister(Observees observee) {
        allobs.remove(observee);
    }

    @Override
    public void notifyObservees(String change) {
        for (Observees observee:allobs){
            observee.update(change);
        }
    }
}

interface Observees {
    void update(String s);
}
class User implements Observees
{

    @Override
    public void update(String s) {
        System.out.println(s+" User");
    }
}

class Sellar implements Observees
{

    @Override
    public void update(String s) {
        System.out.println(s+" seller");
    }
}
class Warehouse implements Observees
{

    @Override
    public void update(String s) {
        System.out.println(s +" warehouse");
    }
}