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
public enum RomanChar {    
    I("I", 1), V("V",5), X("X", 10), L("L", 50), C("C", 100), D("D", 500), M("M", 100);
    String symbol;
    int value;
    RomanChar(String symbol, int value){
        this.symbol = symbol;
        this.value = value;
    }
    int Value(){
        return value;        
    }
    @Override
    public String toString(){
        return symbol;
    }
    public static RomanChar Get(String symbol){
        RomanChar[] romans =  RomanChar.values();
        for(RomanChar r : romans){
            if(symbol.toUpperCase().equals(r.symbol))
                return r;
        }
        return null;
    }
}
