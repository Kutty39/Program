package com.blbz.addressbook.model;

public class PhoneBookModel {
    private static boolean continueflag;

    public static boolean isContinueflag() {
        return continueflag;
    }

    public static void setContinueflag(boolean continueflag) {
        PhoneBookModel.continueflag = continueflag;
    }
}
