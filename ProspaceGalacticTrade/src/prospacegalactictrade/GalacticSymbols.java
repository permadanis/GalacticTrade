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
public class GalacticSymbols {
    private HashMap<String, RomanChar> symbols = new HashMap<>();
    public void SetSymbol(String symbol, RomanChar romanChar){
        symbols.put(symbol, romanChar);
    }

    boolean Contains(String s) {
        return symbols.containsKey(s);
    }
    
    public String ToRomanSymbols(String input){
        String result = "";
        String[] arr = input.split(" ");
        for(String s: arr){
            if(!symbols.containsKey(s))
                return "";
            
            result+= symbols.get(s).toString();
        }
        return result;
    }
}
