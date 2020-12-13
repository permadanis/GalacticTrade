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
public class RomanRule {
    // if smaller number before bigger number then substract
    // no more 3 character in a row
    GalacticSymbols numericSymbol = null;
    public RomanRule(GalacticSymbols symbols){
        this.numericSymbol = symbols;
    }
    public boolean IsValid(String input){
        String[] symbols = input.split("");
        String lastSymbol = "";
        int count = 0;
        for(String s: symbols){
            if(!numericSymbol.Contains(s))
                return false;
            
            if(lastSymbol.equals(s))
                count++;
            else
                count = 0;
            
            
            if(count >=3)
                return false;
            
            lastSymbol = s;
        }
        return true;
    }
    public int GetValue(String input){
        if(!IsValid(input))
            return -1;
        
        int total = 0;
        return total;
    }
}
