package com.company;

import org.junit.jupiter.api.Test;


import static com.company.DayOfWeek.dayOftheWeek;
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
        int[] dayofweek = {0, 1, 2, 3, 0};
        int i=0;
        for (int[] dt : date) {
            assertEquals(dayofweek[i], dayOftheWeek(dt[0],dt[1],dt[2]));
            ++i;
        }

    }

}