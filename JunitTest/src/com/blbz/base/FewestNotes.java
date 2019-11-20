package com.blbz.base;


public class FewestNotes {
    private final static int[] notes = {1000, 500, 100, 50, 10, 5, 2, 1};
    private int notecount = 0;

    public int[][] Notescount(int amount) {
        int[][] notelist;
        int j = 0;
        int tmpamount;

        tmpamount = amount;
        notelist = new int[notes.length][2];
        for (int rs : notes) {
            notelist[j][0] = rs;
            while (rs <= tmpamount) {
                tmpamount = tmpamount - rs;
                ++notelist[j][1];
                setNotecount(getNotecount() + 1);
            }
            ++j;
        }

        return notelist;
    }

    public int getNotecount() {
        return notecount;
    }

    private void setNotecount(int notecount) {
        this.notecount = notecount;
    }
}
