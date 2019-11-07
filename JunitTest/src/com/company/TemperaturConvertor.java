package com.company;

class TemperaturConvertor {
    static double cToF(double c) {
        return (c * 9 / 5) + 32;
    }

    static double fToC(double f) {
        return (f - 32) * 5 / 9;
    }
}

