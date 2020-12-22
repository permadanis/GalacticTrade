/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prospace.galactictrade;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author YTR
 */
public class GalacticSymbolsTest {
    
    public GalacticSymbolsTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of SetSymbol method, of class GalacticSymbols.
     */
    @Test
    public void testSetSymbol() {
        System.out.println("SetSymbol");
        String symbol = "";
        RomanChar romanChar = null;
        GalacticSymbols instance = new GalacticSymbols();
        instance.SetSymbol("test", RomanChar.I);
        // TODO review the generated test code and remove the default call to fail.
        boolean result = instance.Contains("test");
        assertEquals(true, result);
    
     }

    /**
     * Test of Contains method, of class GalacticSymbols.
     */
    @Test
    public void testContains() {
        System.out.println("Contains");
        GalacticSymbols instance = new GalacticSymbols();
        instance.SetSymbol("symbol1", RomanChar.I);
        instance.SetSymbol("symbol5", RomanChar.V);
        instance.SetSymbol("symbol10", RomanChar.X);
        instance.SetSymbol("symbol50", RomanChar.L);

        boolean expResult = false;
        boolean result = instance.Contains("inExistItem");
        assertEquals(expResult, result);
        result = instance.Contains("symbol1");
        assertEquals(true, result);
        
        result = instance.Contains("symbol5");
        assertEquals(true, result);
        
        result = instance.Contains("symbol10");
        assertEquals(true, result);
        
        result = instance.Contains("symbol50");
        assertEquals(true, result);
// TODO review the generated test code and remove the default call to fail.
      
    }

    /**
     * Test of ToRomanSymbols method, of class GalacticSymbols.
     */
    @Test
    public void testToRomanSymbols() {
        System.out.println("ToRomanSymbols");
        String input = "symbol1 symbol10";
        GalacticSymbols instance = new GalacticSymbols();
        instance.SetSymbol("symbol1", RomanChar.I);
        instance.SetSymbol("symbol5", RomanChar.V);
        instance.SetSymbol("symbol10", RomanChar.X);
        instance.SetSymbol("symbol50", RomanChar.L);

        String expResult = "IX";
        String result = instance.ToRomanSymbols(input);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
      
    }

    /**
     * Test of SetPrice method, of class GalacticSymbols.
     */
    @Test
    public void testSetPrice() {
        System.out.println("SetPrice");
        Double price = null;
        GalacticSymbols instance = new GalacticSymbols();
        instance.SetPrice("Silver", 12.0);
        
        price = instance.GetPrice("Silver");
        
        boolean result = price == 12.0;
        assertEquals(true, result);
        // TODO review the generated test code and remove the default call to fail.
      
    }

    /**
     * Test of GetPrice method, of class GalacticSymbols.
     */
    @Test
    public void testGetPrice() {
        System.out.println("GetPrice");
        String item = "";
        GalacticSymbols instance = new GalacticSymbols();
        Double expResult = null;
        Double result = instance.GetPrice(item);
        assertEquals(expResult, result);
       
        expResult = 12.0;
        instance.SetPrice("Silver", expResult);
        result = instance.GetPrice("Silver");
        assertEquals(expResult, result);
    }

    /**
     * Test of Calculate method, of class GalacticSymbols.
     */
    @Test
    public void testCalculate() {
        System.out.println("Calculate");
        GalacticSymbols instance = new GalacticSymbols();
        int result = instance.Calculate("inExistSymbol");
        assertEquals(-1, result);
        
        instance.SetSymbol("symbol1", RomanChar.I);
        instance.SetSymbol("symbol5", RomanChar.V);
        instance.SetSymbol("symbol6", RomanChar.X);
        instance.SetSymbol("symbol50", RomanChar.L);
        
        result = instance.Calculate("symbol1 inExistSymbol");
        assertEquals(-1, result);
        
        int expResult = 4;
        String galacticNumber = "symbol1 symbol5";
        result = instance.Calculate(galacticNumber);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       
    }

    /**
     * Test of GetTotalCredits method, of class GalacticSymbols.
     */
    @Test
    public void testGetTotalCredits() {
        System.out.println("GetTotalCredits");
        GalacticSymbols instance = new GalacticSymbols();
        instance.SetSymbol("symbol1", RomanChar.I);
        instance.SetSymbol("symbol5", RomanChar.V);
        instance.SetSymbol("symbol6", RomanChar.X);
        instance.SetSymbol("symbol50", RomanChar.L);
       
        instance.SetPrice("Silver", 12.0);
        
        
        String galacticNumber = "symbol1 symbol1";
        String itemName = "Silver";
       
        Double expResult = 24.0;
        Double result = instance.GetTotalCredits(galacticNumber, itemName);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
