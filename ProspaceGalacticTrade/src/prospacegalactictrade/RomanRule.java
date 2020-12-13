/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prospacegalactictrade;

import java.util.HashMap;

/**
 *
 * @author YTR
 */
public class RomanRule {
    // if smaller number before bigger number then substract
    // no more 3 character in a row
    static final HashMap<String, String> substractedRole = new HashMap<>();
    {
        
        substractedRole.put("V", "I");
        substractedRole.put("X", "I");
        substractedRole.put("L", "X");
        substractedRole.put("C", "X");
        substractedRole.put("D", "C");
        substractedRole.put("M", "C");
        
    }
    public boolean IsValid(String input, GalacticSymbols numericSymbol){
        
        String romanNumber = numericSymbol.ToRomanSymbols(input);
        if(romanNumber.isEmpty())
            return false;
        
        if(!checkNo3DuplicateInARow(romanNumber))
            return false;
        
        if(!checkBigToSmall(romanNumber))
            return false;
        
        return true;
    }
    boolean checkNo3DuplicateInARow(String romanNumber){
        String[] symbols = romanNumber.split("");
        String lastSymbol = "";
        int count = 0;
        for(String s: symbols){
            
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
    
    private boolean checkBigToSmall(String romanNumber) {
        String[] symbols = romanNumber.split("");
        for(int i=1; i<symbols.length; i++){
            int before = RomanChar.Get(symbols[i - 1]).Value();
            int current = RomanChar.Get(symbols[i]).Value();
            
            if(before < current){
                String charBefore = symbols[i - 1];
                String charCurrent = symbols[i];
                
                if(!charBefore.equals(substractedRole.get(charCurrent)))
                    return false;
            }
        }
        return true;
        
    }
    public int GetValue(String validRomanNumber){
        int total = 0;
        String [] tmp = validRomanNumber.split("");
        int lastvalue = 0;
        for(String roman: tmp){
            int value = RomanChar.Get(roman).Value();
            total += value;
            if(lastvalue != 0){
                if(lastvalue < value)
                    total -= 2 * lastvalue;
            }
            lastvalue = value;
        }
        return total;
        
    }

    
}
