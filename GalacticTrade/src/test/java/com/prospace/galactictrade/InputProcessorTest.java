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
public class InputProcessorTest {

    public InputProcessorTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of Process method, of class InputProcessor.
     */
    @Test
    public void testProcess() {
    }

    @Test
    public void testProcessLine() {
        System.out.println("Test Process input per line");
        InputProcessor inputProcessor = new InputProcessor();
        String input = "asdf";
        String result = inputProcessor.Process(input);
        String expected = ErrorCode.NoIdea.toString();
        assertEquals(expected, result);

        input = "asdf is invlaidroman";
        result = inputProcessor.Process(input);
        expected = ErrorCode.NoIdea.toString();
        assertEquals(expected, result);

        input = "asdf is V";
        result = inputProcessor.Process(input);
        expected = "";
        assertEquals(expected, result);

        input = "asdf   is    V             ";
        result = inputProcessor.Process(input);
        expected = "";
        assertEquals(expected, result);

        input = "asdf is V\r\n"
                + "asdf dd is 54 Credits ";
        result = inputProcessor.Process(input);
        expected = "";
        assertEquals(expected, result);

        input = "asdf        is        V\r\n"
                + "asdf dd is      54         Credits                     ";
        result = inputProcessor.Process(input);
        expected = "";
        assertEquals(expected, result);

        input = "asdf is V\r\n"
                + "asdf dd is 54 Credit ";
        result = inputProcessor.Process(input);
        expected = ErrorCode.NoIdea.toString();
        assertEquals(expected, result);

        input = "a is i\n"
                + "b is v\n"
                + "c is x\n"
                + "a b bread is 12 Credits";
        result = inputProcessor.Process(input);
        expected = "";
        assertEquals(expected, result);

        input = "a is i\n"
                + "b is v\n"
                + "c is x\n"
                + "a b bread is 12 Credits\n"
                + "c c rice is 40 Credits";
        result = inputProcessor.Process(input);
        expected = "";
        assertEquals(expected, result);

        input = "a is i\n"
                + "b is v\n"
                + "a b bread is 12 Credits\n"
                + "c c rice is 40 Credits\n";
        result = inputProcessor.Process(input);
        expected = ErrorCode.InvalidGalacticNumber.toString();
        assertEquals(expected, result);

        input = "a is i\n"
                + "b is v\n"
                + "c is x\n"
                + "a b bread is 12 Credits\n"
                + "c c rice is 40 Credits\n"
                + "c c c is c c c";
        result = inputProcessor.Process(input);
        expected = ErrorCode.SetSymbol_Failed.toString();
        assertEquals(expected, result);

        input = "how many is a b c?";
        result = inputProcessor.Process(input);
        expected = ErrorCode.NoIdea.toString();
        assertEquals(expected, result);

        input = "a is i\n"
                + "b is v\n"
                + "c is x\n"
                + "a b bread is 12 Credits\n"
                + "c c rice is 40 Credits\n"
                + "how much is a b c?";
        result = inputProcessor.Process(input);
        expected = ErrorCode.InvalidGalacticNumber.toString();
        assertEquals(expected, result);

        input = "a is i\n"
                + "b is v\n"
                + "c is x\n"
                + "a b bread is 12 Credits\n"
                + "c c rice is 40 Credits\n"
                + "how much is c b a?";
        result = inputProcessor.Process(input).trim();
        expected = "c b a is 16";
        assertEquals(expected, result);

    }

    @Test
    public void AddSpaceAfterSentensesTest() {
        System.out.println("Add Space After Sentenses Test");
        InputProcessor inputProcessor = new InputProcessor();
        String input = "                    glob is I \n"
                + "prok           is        V        \n"
                + "pish is X            \n"
                + "tegj is L               \n"
                + "glob glob Silver is 34         Credits       \n"
                + "glob prok Gold is 57800          Credits         \n"
                + "pish pish Iron is 3910      Credits          \n"
                + "how          much is pish tegj glob glob               ?        \n"
                + "how many Credits is glob prok Silver    ?                \n"
                + "how            many Credits is glob prok Gold             ? \n"
                + "how         many Credits is glob prok Iron          ? \n"
                + "how much wood could a woodchuck chuck if a woodchuck could chuck wood ?";

        String result = inputProcessor.Process(input);
        String expected = "pish tegj glob glob is 42\n"
                + "glob prok Silver is 68 Credits\n"
                + "glob prok Gold is 57800 Credits\n"
                + "glob prok Iron is 782 Credits\n"
                + "I have no idea what you are talking about\n";
        
        String[] lineExpected = expected.split("\n");
        String[] lineResult = result.split("\n");
        
        
        for(int i = 0; i<lineExpected.length; i++){
            
            String exp = lineExpected[i].trim();
            String res = lineResult[i].trim();
           
            
             assertEquals(exp, res);

            
        }
        assertEquals(lineExpected.length, lineResult.length);
    }

    @Test
    public void testSetSymbol() {

    }

    @Test
    public void testSetPrice() {

    }

    @Test
    public void testCalculateTotalCredit() {

    }

    @Test
    public void CalculateGalacticNumber() {

    }

}
