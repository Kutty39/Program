package com.blbz.logical.base;

import java.util.Random;
import java.util.Scanner;

class CrossGame {
    private String[][] board;
    private int rw, cl;
    private boolean x = false, o = false;
    private String tmp;
    private Scanner sc = new Scanner(System.in);

    CrossGame() {
        rw = 0;
        cl = 0;
        String ply = "x";
        tmp = "";
        String result;

        board = new String[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = "-";
            }
        }
        System.out.println("You Start first (Remember you are 'X')");
        do {
            updatevalue(ply);
            System.out.println("-----------------------\n");
            printarrey();
            System.out.println("\n-----------------------\n");
            result = posibilitycheck();
            ply = ply.equals("x") ? "o" : "x";
        } while (result.equals("Continue"));
        System.out.println(result + " Won!!!!");
    }

    private void updatevalue(String ply) {
        if (ply.equals("x")) {
            do {
                System.out.println("Row:");
                rw = getints();
                System.out.println("Column:");
                cl = getints();
            } while (arraynotupdate(rw, cl, ply));
        } else {
            Random r = new Random();
            r.nextInt(3);
            do {
                rw = r.nextInt(3);
                cl = r.nextInt(3);
            } while (arraynotupdate(rw, cl, ply));
        }
    }

    private boolean arraynotupdate(int rw, int cl, String ply) {
        if (board[rw][cl].equals("-")) {
            board[rw][cl] = ply;
            return false;
        } else {
            return true;
        }
    }

    private int getints() {
        do {
            System.out.println("Enter between 1 to 3");
            sc.reset();
            tmp = sc.nextLine();
        } while (isint(tmp) < 1 || isint(tmp) > 3);
        return isint(tmp)-1;
    }

    private int isint(String tmp) {
        try {
            return Integer.parseInt(tmp);
        } catch (Exception e) {
            return -1;
        }
    }

    private void printarrey() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + "|");
            }
            System.out.println();
        }
    }

    private String posibilitycheck() {
        if (board[0][0].equals(board[0][1]) && board[0][1].equals(board[0][2])) {
            o = board[0][0].equals("o");
            x = board[0][0].equals("x");
        } else if (board[1][0].equals(board[1][1]) && board[1][1].equals(board[1][2])) {
            o = board[1][0].equals("o");
            x = board[1][0].equals("x");
        } else if (board[2][0].equals(board[2][1]) && board[2][1].equals(board[2][2])) {
            o = board[2][0].equals("o");
            x = board[2][0].equals("x");
        } else if (board[0][0].equals(board[1][0]) && board[1][0].equals(board[2][0])) {
            o = board[0][0].equals("o");
            x = board[0][0].equals("x");
        } else if (board[0][1].equals(board[1][1]) && board[1][1].equals(board[2][1])) {
            o = board[0][1].equals("o");
            x = board[0][1].equals("x");
        } else if (board[0][2].equals(board[1][2]) && board[1][2].equals(board[2][2])) {
            o = board[0][2].equals("o");
            x = board[0][2].equals("x");
        } else if (board[0][0].equals(board[1][1]) && board[1][1].equals(board[2][2])) {
            o = board[0][0].equals("o");
            x = board[0][0].equals("x");
        } else if (board[2][0].equals(board[1][1]) && board[1][1].equals(board[0][2])) {
            o = board[2][0].equals("o");
            x = board[2][0].equals("x");
        }

        return o ? "Computer" : x ? "Player" : "Continue";
    }
}