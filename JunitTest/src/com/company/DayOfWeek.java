package com.company;

class DayOfWeek {
    static int dayOftheWeek(int date, int month, int year) {
        double y0 = year - (14 - month) / 12;
        double x = y0 + y0 / 4 - y0 / 100 + y0 / 400;
        double m0 = month + 12 * ((14 - month) / 12) - 2;
        return (int)(date + x + 31 * m0 / 12) % 7;
    }
}
