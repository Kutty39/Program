package com.blbz.inventorymanagement.test;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.fail;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class StandardTests {
/*

    @BeforeAll
    static void initAll() {
    }

    @BeforeEach
    void init() {

    }
*/

    @Test
    @Order(1)
    void succeedingTest() {
        String[] expected={"rice","svs","50","60"};
        String[] actual={"need methode to create this string"};
        assertArrayEquals(expected,actual);
    }

    @Test
    @Order(2)
    void failingTest() {
        fail("a failing test");
    }

/*
    @Test
    @Disabled("for demonstration purposes")
    void skippedTest() {
        // not executed
    }
*/

    @Test
    void abortedTest() {
        assumeTrue("abc".contains("Z"));
        fail("test should have been aborted");
    }

    @AfterEach
    void tearDown() {
    }

    @AfterAll
    static void tearDownAll() {
    }

}