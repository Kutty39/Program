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
    @BeforeEach
    public void init(){
        inm=new InventorySystem();
    }

    @ParameterizedTest
    @CsvSource( {"All,3725","Rice,3000","Pulses,600","Wheat,125"})
    @DisplayName("Test to calculation")
    void testCalculate(String item,double expected) {
        double tot= inm.calculate(item);
        assertEquals(expected,tot);
    }


}