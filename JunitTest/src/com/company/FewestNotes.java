package com.company;


class FewestNotes {
    private final static int[] notes = {1000,500,100,50,10,5,2,1};
    private int notecount=0;

    int[][] Notescount(int amount) {
            int[][] notelist;
            int j = 0;
            int tmpamount;

 /*           Scanner sc = new Scanner(System.in);
            System.out.println("Please enter the amount to be changed :");
            int amount = sc.nextInt();*/
            tmpamount= amount;
            notelist = new int[notes.length][2];
            for(int rs:notes) {
                notelist[j][0] = rs;
                while (rs <= tmpamount) {
                    tmpamount = tmpamount - rs;
                    ++notelist[j][1];
                    setNotecount(getNotecount() + 1);
                }
                ++j;
            }
          /*  System.out.println("No of note given is :" + getNotecount());
            System.out.println("Rs Notes and Counts :");
            for (int[] rw:notelist) {
                if (rw[1] != 0) {
                    System.out.println(rw[0] + "*" + rw[1] + "=" + (rw[0]* rw[1]));
                }
            }
            System.out.println("In total :"+amount);*/
            return notelist;
    }

    int getNotecount() {
        return notecount;
    }

    private void setNotecount(int notecount) {
        this.notecount = notecount;
    }
}
