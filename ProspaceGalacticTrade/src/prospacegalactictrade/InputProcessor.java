/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prospacegalactictrade;

/**
 *
 * @author YTR
 */
class InputProcessor {

    String Process(String text) {
      
        String output = "";
        String[] lines = text.split(System.getProperty("line.separator"));
        for(String line: lines){
            line = line.trim();
            boolean question = line.substring(line.length() - 2).equals("?");
            
            
        }
        return output;
    }
    enum InputCategory{
        SET_VARIABLE, SET_ROLE, QUESTION
    }
}
