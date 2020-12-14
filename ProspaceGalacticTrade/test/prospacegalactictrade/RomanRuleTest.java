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
       
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    @Test
    public void IsValidRomanWithErrorInput(){
        RomanRule romanrule = new RomanRule();
        boolean value = romanrule.IsValidRoman("");
        assertEquals(false, value);
        
        value = romanrule.IsValidRoman("VIIIII");
        assertEquals(false, value);
        
        value = romanrule.IsValidRoman("ILCM");
        assertEquals(false, value);
        
        value = romanrule.IsValidRoman("XXXIXIX");
        assertEquals(false, value);
        
        
    }
    
    @Test
    public void IsValidRomanWithValidInput(){
        RomanRule romanrule = new RomanRule();
        boolean value = romanrule.IsValidRoman("III");
        assertEquals(true, value);
        
        value = romanrule.IsValidRoman("VIII");
        assertEquals(true, value);
        
        value = romanrule.IsValidRoman("XIV");
        assertEquals(true, value);
        
    }
    
    @Test
    public void GetValue(){
        RomanRule romanrule = new RomanRule();
        int value = romanrule.GetValue("I");
        assertEquals(1, value);
        value = romanrule.GetValue("III");
        assertEquals(3, value);
        value = romanrule.GetValue("IV");
        assertEquals(4, value);
        value = romanrule.GetValue("XIV");
        assertEquals(14, value);
    
    }
    /**
     * Test of IsValid method, of class RomanRule.
     */
  
    /*@Test
    public void testIsValid() {
        System.out.println("IsValid");
        String input = "prok prok prok prok";
        
        boolean expResult = false;
        boolean result = instance.IsValid(input);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }
    */
   /* @Test
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
*/
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
