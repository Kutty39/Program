package com.company;

import java.util.Random;

public class CouponNumber {

    public String distictcoupon(int coupcount) {
        String cpn = "";
        int a=0;
        Random rm = new Random();
        for (int i = 0; i <coupcount ; i++) {
            a=rm.nextInt(999999);
            while(cpn.contains(a+",")) {
                a = rm.nextInt(999999);
            }
            cpn=cpn+a+",";
        }
        cpn=cpn.replace(a+",",""+a);
        return cpn;
    }
}
