package com.blbz.cliniquemanagement.controller;

import com.blbz.cliniquemanagement.utility.Utility;

import javax.xml.bind.SchemaOutputResolver;

public class Main {

    public static void main(String[] args) {
	int choice=0;
        do{
            System.out.println("Clinique Management System");
            System.out.println("--------------------------");
            System.out.println("1.Login");
            System.out.println("2.SignUp");
            System.out.println("3.Exit");
            switch (Utility.getInt()){
                case 1:
                    break;
                case 2:
                    signUp();
                    break;
                case 3:
                    System.out.println("Thanks for using our system.\n Have a great day!!!!");
                    choice=1;
                    break;
                default:
                    System.out.println("Invalid input");
                    break;

            }
        }while(choice==0);
    }

    private static void signUp() {
        System.out.println("Please give us the below information");
        System.out.println("1.Doctor\n2.Patient\n3.Exit");
        int choice=0;
        do{
        switch (Utility.getInt()){
            case 1:
                System.out.println("Welcome Doctor");
                System.out.println("Please enter name");
                String name=Utility.getString();
                System.out.println("Enter your Specialization");
                String sp=Utility.getString();

                break;
            case 2:
                break;
            case 3:
                choice=1;
                break;
            default:
                System.out.println("");
        }}while (choice==0);
    }
}
