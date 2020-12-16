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

        input = "asdf is V\r\n"
                + "asdf dd is 54 Credits ";
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
