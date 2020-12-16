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
    private HashMap<String, Double> itemsPrice = new HashMap<>();
    RomanRule romanRule = new RomanRule();
       
    public void SetSymbol(String symbol, RomanChar romanChar){
        symbols.put(symbol, romanChar);
    }

    boolean Contains(String symbol) {
        return symbols.containsKey(symbol);
    }
    
    public String ToRomanSymbols(String galacticSymbols){
        String result = "";
        String[] arr = galacticSymbols.split(" ");
        for(String s: arr){
            if(!symbols.containsKey(s))
                return "";
            
            result+= symbols.get(s).toString();
        }
        return result;
    }

    void SetPrice(String item, Double price) {
        itemsPrice.put(item, price);
    }
    public Double GetPrice(String item){
        return itemsPrice.get(item);
    }
    int Calculate(String galacticNumber){
        galacticNumber = galacticNumber.trim();
        if(!romanRule.IsValid(galacticNumber, this))
            return -1;
        
        String romanSymbol = ToRomanSymbols(galacticNumber);
        return romanRule.GetValue(romanSymbol);
    }
    Double GetTotalCredits(String galacticNumber, String itemName){
         if(!itemsPrice.containsKey(itemName))
             return null;
         
         int nItem = Calculate(galacticNumber);
         if(nItem < 0)
             return null;
         
         Double price = itemsPrice.get(itemName);
         Double total = nItem * price;
         return total;
         //return galacticNumber +" "+itemName+" is "+((Number)total).intValue()+" Credits";
    }

    void Clear() {
        itemsPrice.clear();
        symbols.clear();
    }
}
