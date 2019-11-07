package com.company;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FewestNotesTest {
    @Test
    void test(){
        FewestNotes fewestNotes=new FewestNotes();
        int[][] expected={{1000,5},{500,0},{100,4},{50,1},{10,1},{5,1},{2,2},{1,0}};
        int[][] actual =fewestNotes.Notescount(5469);
        int expectedcount=14;
        assertArrayEquals(expected,actual);
        assertEquals(expectedcount,fewestNotes.getNotecount());

    }

}