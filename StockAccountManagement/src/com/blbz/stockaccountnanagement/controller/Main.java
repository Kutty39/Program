package com.blbz.stockaccountnanagement.controller;

/*
Created by  : Tamilselvan S
Created on  : 29/11/2019
Purpose     : Stock Account Management
                1.Account maintenance
                2.Transaction tracking
                3.Company stock maintenance
 */


import com.blbz.stockaccountnanagement.model.StockModel;
import com.blbz.stockaccountnanagement.service.Company;
import com.blbz.stockaccountnanagement.service.StockAccount;
import com.blbz.stockaccountnanagement.serviceimp.CompanyImp;
import com.blbz.stockaccountnanagement.serviceimp.StockAccountImp;
import com.blbz.stockaccountnanagement.utility.Utility;

public class Main {
    static Utility ut = new Utility();

    public static void main(String[] args) {
        int choice = 0;
        do {
            System.out.println("Welcome to stock management");
            System.out.println("1.User Menu\n2.company menu\n3.Exit");
            switch (ut.getInput()) {
                case 1:
                    userMenu();
                    break;
                case 2:
                    companyMenu();
                    break;
                case 3:
                    System.out.println("Thanks for using our system.\nBye! Bye!!!");
                    choice = 1;
                    break;
                default:
                    System.out.println("Invalid input");
            }
        } while (choice == 0);
    }

    private static void companyMenu() {
        Company cm = new CompanyImp();
        String sym = "";
        int choice = 0;
        double nos = 0;
        double price = 0;
        String name = "";

        do {
            System.out.println("*****************************");
            System.out.println("\tCompany Menu");
            System.out.println("*****************************");
            System.out.println("1.Add Company\n2.Edit company\n3.Delete company\n4.Save\n5.Report\n6.Exit");
            switch (ut.getInput()) {
                case 1:
                    System.out.println("Enter Company Name");
                    name = ut.getInputString();
                    System.out.println("Enter stock symbol for your company");
                    sym = "";
                    do {
                        if (!sym.equals("")) {
                            System.out.println("this stock symbol is already available.please enter another symbol");
                        }
                        sym = ut.getInputString();
                    } while (!cm.validateSym(sym));
                    System.out.println("Enter no. of share");
                    nos = ut.getInputDouble();
                    System.out.println("Please enter price of one stock");
                    price = ut.getInputDouble();
                    cm.addStock(name, sym, nos, price);
                    break;
                case 2:
                    System.out.println("Enter the stock symbol to edit");
                    sym = ut.getInputString();
                    String[] dt = cm.getdetails(sym).replace("[", "").replace("]", "").split(",");
                    System.out.println("Company name :" + dt[0] + "\nWant to change press'y'.press any key to next");
                    if (ut.getInputString().toUpperCase().equals("Y")) {
                        System.out.println("Enter company name");
                        name = ut.getInputString();
                    } else {
                        name = dt[0];
                    }
                    System.out.println("no. of share :" + dt[1] + "\nWant to change press'y'.press any key to next");
                    if (ut.getInputString().toUpperCase().equals("Y")) {
                        System.out.println("Enter no. of share");
                        nos = ut.getInputDouble();
                    } else {
                        nos = Double.parseDouble(dt[1]);
                    }
                    System.out.println("stock price:" + dt[1] + "\nWant to change press'y'.press any key to next");
                    if (ut.getInputString().toUpperCase().equals("Y")) {
                        System.out.println("Please enter price of one stock");
                        price = ut.getInputDouble();
                    } else {
                        price = Double.parseDouble(dt[1]);
                    }
                    cm.addStock(name, sym, nos, price);
                    break;
                case 3:
                    System.out.println("Enter the stock symbol to delete");
                    sym = ut.getInputString();
                    if (cm.deleteStock(sym)) {
                        System.out.println("Deleted successfully");
                    } else {
                        System.out.println("Stock symbol is not present in our data base");
                    }
                    break;
                case 4:
                    cm.save();
                    break;
                case 5:
                    cm.displayAllDetails();
                    System.out.println("press enter to exit");
                    ut.getInputString();
                    break;
                case 6:
                    if (StockModel.isFiledited()) {
                        System.out.println("Some changes are not saved. press 'y' to save.press any key to cancel");
                        if (ut.getInputString().toUpperCase().equals("Y")) {
                            cm.save();
                        }
                    }
                    choice = 1;
                    break;
                default:
                    System.out.println("Invalid input");
            }
        } while (choice == 0);
    }

    private static void userMenu() {
        StockAccount sk = new StockAccountImp();

        int choice = 0;
        do {
            System.out.println("*********************");
            System.out.println("\tUser Menu");
            System.out.println("*********************");
            System.out.println("1.Create new profile\n2.Open existing profile\n3.Exit");
            switch (ut.getInput()) {
                case 1:
                    System.out.println("Enter the name to create");
                    String name = ut.getInputString();
                    System.out.println("Enter the initial amount");
                    double amount = ut.getInputDouble();
                    sk.StockAccount(name, amount);
                    userAction();
                    break;
                case 2:
                    System.out.println("Enter the name to open");
                    if (sk.openJSON(ut.getInputString())) {
                        userAction();
                    }
                    break;
                case 3:
                    choice = 1;
                    break;
                default:
                    System.out.println("Invalid input");
            }
        } while (choice == 0);
    }

    private static void userAction() {
        StockAccount sk = new StockAccountImp();
        Company cm = new CompanyImp();
        String sym = "";
        double amount = 0;

        int choice = 0;
        do {
            System.out.println("*******************************");
            System.out.println("\tUser Action Menu");
            System.out.println("*******************************");
            System.out.println("1.Show Account Balance\n2.Buy Share\n3.Sell Share\n4.Holding Report\n5.Transaction Report");
            switch (ut.getInput()) {
                case 1:
                    System.out.println("your account balance is " + sk.valueof());
                    break;
                case 2:
                    System.out.println("Enter stock symbol to buy");
                    do {
                        if (!sym.equals("")) {
                            System.out.println("Enter valid stock symbol");
                        }
                        sym = ut.getInputString();
                    } while (cm.validateSym(sym));
                    System.out.println("Enter the amount to buy");
                    do {
                        if (amount != 0) {
                            System.out.println("You don't have sufficient amount.\n you have " + sk.valueof() + " in your account");
                        }
                        amount = ut.getInputDouble();
                    } while ((sk.valueof() < amount));
                    sk.buy(amount, sym);
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    choice = 1;
                    break;
                default:
                    System.out.println("Invalid input");
            }
        } while (choice == 0);
    }
}
