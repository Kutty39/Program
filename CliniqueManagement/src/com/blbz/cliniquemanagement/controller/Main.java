package com.blbz.cliniquemanagement.controller;
/*
Created by  : Tamilselvan S
Created on  : 27/11/2019
Purpose     : This programme is used to manage a list of Doctors associated with the Clinique. This also manages the list of patients who use the clinique
 */

import com.blbz.cliniquemanagement.service.Clinique;
import com.blbz.cliniquemanagement.serviceimp.CliniqueImp;
import com.blbz.cliniquemanagement.utility.Utility;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;


public class Main {
    private static Clinique cl;

    public static void main(String[] args) {
        cl = new CliniqueImp();
        int choice = 0;
        //Initial menu
        do {
            System.out.println("Clinique Management System");
            System.out.println("--------------------------");
            System.out.println("1.Login");
            System.out.println("2.SignUp");
            System.out.println("3.Exit");
            switch (Utility.getInt()) {
                case 1:
                    signin();
                    break;
                case 2:
                    signUp();
                    break;
                case 3:
                    System.out.println("Thanks for using our system.\n Have a great day!!!!");
                    choice = 1;
                    break;
                default:
                    System.out.println("Invalid input");
                    break;

            }
        } while (choice == 0);
    }

    /*
    Login method. it will ask only ID and check whether they are available in the database or not
    after sign in, it will give the separate menu for doctor and patient
    it will show the appointment for the current day by default
    Doctor can see the appointment details for any day
    Patient can see as well as create new appointment
     */
    private static void signin() {
        String date = LocalDate.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        boolean choice = true;

        System.out.println("Enter your ID");
        String id = Utility.getFreeText();
        String valid = cl.validateID(id);
        while (valid.equals("Invalid")) {
            id = Utility.getFreeText();
            valid = cl.validateID(id);
        }
        switch (valid) {
            case "Doctor":
                System.out.println("Welcome doctor");
                cl.getAppointment(id, date, "Doctor");
                do {
                    System.out.println("1.Your appointment on any other date\n2.Exit");
                    switch (Utility.getInt()) {
                        case 1:
                            System.out.println("Enter the date(dd-mm-yyyy eg. 31-01-2019)");
                            date = Utility.getString("date");
                            cl.getAppointment(id, date, "Doctor");
                            break;
                        case 2:
                            choice = false;
                            break;
                        default:
                            System.out.println("Invalid input");
                    }
                } while (choice);

                break;
            case "Patient":
                System.out.println("Welcome to our clinic");
                cl.getAppointment(id, date, "Patient");
                do {
                    System.out.println("1.Create new appointment\n2.Search appointment on any other date\n3.Exit");

                    switch (Utility.getInt()) {
                        case 1:
                            System.out.println("Enter ID or Name or Speciality");
                            List<String> idlist = cl.searchDoctor(Utility.getFreeText());
                            if (idlist != null) {
                                System.out.println("Enter the doctor ID to book appointment.");
                                String did = Utility.getFreeText();
                                while (!idlist.contains(did)) {
                                    System.out.println("Enter correct id");
                                    did = Utility.getFreeText();
                                }
                                System.out.println("Enter the date(dd-mm-yyyy. eg. 30-01-2019)");
                                LocalDate date1 = Utility.curnfutDate(Utility.getString("date"));
                                cl.createAppointment(id, did, date1);
                            } else {
                                System.out.println("No data found");
                            }
                            break;
                        case 2:
                            System.out.println("Enter the date(dd-mm-yyyy eg. 31-01-2019)");
                            date = Utility.getString("date");
                            cl.getAppointment(id, date, "Patient");
                            break;
                        case 3:
                            choice = false;
                            break;
                        default:
                            System.out.println("Invalid input");
                    }
                } while (choice);
                break;
        }
    }

    /*
    first time patient/doctor both have to open new account by giving their personal details
     */
    private static void signUp() {
        System.out.println("Please give us the below information");
        System.out.println("1.Doctor\n2.Patient");
        switch (Utility.getInt()) {
            case 1:
                System.out.println("Welcome Doctor");
                System.out.println("Please enter your name");
                String name = Utility.getString();
                System.out.println("Enter your Specialization");
                String sp = Utility.getString();
                System.out.println("Enter your availability time in the below format\n(eg. 01:00 PM - 05:45 PM or 10:00 AM - 01:00 PM)");
                String time = Utility.getFreeText();
                cl.addDoctor(name, sp, time);
                break;
            case 2:
                System.out.println("Welcome. we are here to take care you!!!");
                System.out.println("Please enter your name");
                String pname = Utility.getString();
                System.out.println("Enter your phone number");
                String ph = Utility.getString("ph");
                System.out.println("Enter your age");
                String age = Utility.getString("age");
                cl.addPatient(pname, ph, age);
                break;
            default:
                System.out.println("");
        }
    }
}
