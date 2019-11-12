package com.company;

import org.junit.jupiter.api.Test;


import static com.company.DayOfWeek.dayOftheWeek;
import static com.company.MonthlyPayment.payment;
import static com.company.TemperaturConvertor.cToF;
import static com.company.TemperaturConvertor.fToC;
import static org.junit.jupiter.api.Assertions.*;

class JunitTest {
    @Test
    void testFewestnotes() {
        FewestNotes fewestNotes = new FewestNotes();
        int[][] expected = {{1000, 5}, {500, 0}, {100, 4}, {50, 1}, {10, 1}, {5, 1}, {2, 2}, {1, 0}};
        int[][] actual = fewestNotes.Notescount(5469);
        int expectedcount = 14;
        assertArrayEquals(expected, actual);
        assertEquals(expectedcount, fewestNotes.getNotecount());

    }

    @Test
    void testdayoftheweek() {
        int[][] date = {{3, 11, 2019}, {4, 11, 2019}, {5, 11, 2019}, {6, 11, 2019}, {10, 11, 2019}};
        int[][] date1={{3, "a", 2019}, {4.3, 11, "2019"}};
        int[] dayofweek = {0, 1, 2, 3, 0};
        int i = 0;
        for (int[] dt : date1) {
            assertEquals(dayofweek[i], dayOftheWeek(dt[0], dt[1], dt[2]));
            ++i;
        }

    }

    @Test
    void testTempConv() {
        double[] heatinc = {29, 50, 10, -78, 90};
        double[] heatinf = {84.2, 122, 50, -108.4, 194};
        for (double c : heatinc) {
            assertEquals(c, cToF(c));
        }
        for (double f : heatinf) {
            assertEquals(f, fToC(f));
        }
    }

    @Test
    void testMonthlyPayment(){
        double[][] ypi={{5,100000,10},{3,100000,10},{5,100000,13},{3,100000,13}};
        double[] emi ={2125,3227,2275,3369};
        int j=0;
        for(double[] d:ypi){
            assertEquals(emi[j],payment(d[0],d[1],d[2]));
            ++j;
        }
    }
}