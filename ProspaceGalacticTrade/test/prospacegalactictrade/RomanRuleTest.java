/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prospacegalactictrade;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author YTR
 */
public class RomanRuleTest {
    static RomanRule instance = null;
    public RomanRuleTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        GalacticSymbols galacticSymbol = new GalacticSymbols();
        galacticSymbol.SetSymbol("prok", RomanChar.I);
        instance = new RomanRule(galacticSymbol);
       
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of IsValid method, of class RomanRule.
     */
    @Test
    public void testIsValid() {
        System.out.println("IsValid");
        String input = "prok prok prok prok";
        
        boolean expResult = false;
        boolean result = instance.IsValid(input);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }
    
    @Test
    public void testInValidInput(){
        System.out.println("IsValid");
        String input = "prok prok prok prok";
        
        boolean expResult = false;
        boolean result = instance.IsValid(input);
        assertEquals(expResult, result);
        
        input = "prok asdf asdf dkdk";
        result = instance.IsValid(input);
        assertEquals(false, result);
    }

    /**
     * Test of GetValue method, of class RomanRule.
     */
    /*
    @Test
    public void testGetValue() {
        System.out.println("GetValue");
        String input = "";
        RomanRule instance = null;
        int expResult = 0;
        int result = instance.GetValue(input);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/
    
}
