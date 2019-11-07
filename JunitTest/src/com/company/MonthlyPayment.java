package com.company;

class MonthlyPayment {
    static double payment(double year, double principle, double interestRate) {
        double n = 12 * year;
        double r = interestRate / (12 * 100);
        return Math.round((principle * r) / (1 - Math.pow(1 + r, -n)));
    }
}
