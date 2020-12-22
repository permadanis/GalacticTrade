/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prospace.galactictrade;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author YTR
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        if (args.length < 1) {
            System.err.println("Please provide an input file!");
            System.exit(0);
        }
        File inputFile = new File(args[0]);
        if (!inputFile.exists()) {
            System.err.println("File does not exist");
            System.exit(0);
        }

        Scanner myReader;
        String inputText = "";

        try {
            myReader = new Scanner(inputFile);
            while (myReader.hasNextLine()) {
                inputText += myReader.nextLine()+"\r\n";
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            System.exit(0);
        }

        InputProcessor inputProcessor = new InputProcessor();
        System.out.println(inputProcessor.Process(inputText));
    }

}
