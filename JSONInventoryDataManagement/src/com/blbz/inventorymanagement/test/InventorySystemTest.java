package com.blbz.inventorymanagement.test;

import com.blbz.inventorymanagement.service.InventoryManager;
import com.blbz.inventorymanagement.serviceimp.InventorySystem;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class InventorySystemTest {
    InventoryManager inm;
    /*Before all the test case it will run this part of code.
    that is why we are initialized the class here. so that the changes which is done by previous test case will not affect our current test
     */
    @BeforeEach
    public void init(){
        inm=new InventorySystem();
    }

    /*
    Here i have pass all the test cases by using ParameteizedTest
    Why csvSource, is becouse we need to have two inputs that is why we have taken two inputs as CSV format.
     */
    @ParameterizedTest
    @CsvSource( {"All,3725","Rice,3000","Pulses,600","Wheat,125"})
    @DisplayName("Test to calculation")
    void testCalculate(String item,double expected) {
        double tot= inm.calculate(item);
        assertEquals(expected,tot);
    }


}