package com.company;


import java.time.LocalDate;

public class Calendar {
    /*
    just to create calender for given month and year
     */

    static String[][] calender;

    public static void main(String[] args) {
        calenderPage(10, 2019);
        printCalenter(calender);
        canlederQ(calender);
        canlederStk(calender);
    }

    //Print the calender
    private static void printCalenter(String[][] calender) {
        for (String[] str : calender) {
            for (String s : str) {
                System.out.print((s == null ? "  " : s) + " ");
            }
            System.out.println();
        }
    }

    //storing and printing calender in Queue
    static void canlederQ(String[][] calender) {
        int row = 0;
        MyQueue<String> dayq=new MyQueue<>();
        MyQueue<String> dateq=new MyQueue<>();
        MyQueue<String> tempq;

        for (String[] str : calender) {
            tempq=row==0?dayq:dateq;
            for (String s : str) {
                tempq.enQueue((s == null ? "  " : s) + " ");
            }
            ++row;
            tempq.enQueue("\n");
        }
        while (dayq.size()!=0){
            System.out.print(dayq.deQueus());
        }
        while (dateq.size()!=0){
            System.out.print(dateq.deQueus());
        }

    }

    //storing and printing calender in Stack
    static void canlederStk(String[][] calender) {
        Stock<String> dayq=new Stock<>();
        Stock<String> dateq=new Stock<>();
        Stock<String> tempq;

        for (int i = calender.length-1; i <=0 ; i++) {
            tempq=i==0?dayq:dateq;
            for (int j = calender[i].length-1; j <0 ; j++) {
                String s= calender[i][j];
                tempq.push((s == null ? "  " : s) + " ");
            }
            tempq.push("\n");
        }
        while (dayq.size()!=0){
            System.out.print(dayq.pop());
        }
        while (dateq.size()!=0){
            System.out.print(dateq.pop());
        }

    }

    //this will create the full calender
    private static void calenderPage(int month, int year) {
        LocalDate date = DateTime.getDate(1, month, year);
        LocalDate monthenddate = DateTime.getMonthEnd(date);
        int endweek = DateTime.getWeeKNum(monthenddate);

        calender = new String[endweek + 1][7];
// initialing calender with week days
        calender[0][0] = "S ";
        calender[0][1] = "M ";
        calender[0][2] = "T ";
        calender[0][3] = "W ";
        calender[0][4] = "TH";
        calender[0][5] = "F ";
        calender[0][6] = "ST";

        /*this loop will create the caleder
        by getting day number and week number.
        for sunday it returns 7, so we have to replace 7 with 0
         */
        for (int i = 1; i <= monthenddate.getDayOfMonth(); i++) {
            date = DateTime.getDate(i, month, year);

            int day = DateTime.getDayNum(date);
            int week = DateTime.getWeeKNum(date);

            if (day == 7) {
                day = 0;
            }
            calender[week][day] = "" + (i < 10 ? "0" + i : i);
        }
    }
}
