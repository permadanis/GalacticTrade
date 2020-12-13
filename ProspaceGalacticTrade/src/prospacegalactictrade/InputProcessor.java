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
      
        GalacticSymbols galacticSymbol = new GalacticSymbols();
       
        String output = "";
        String[] lines = text.split(System.getProperty("line.separator"));
        for(String line: lines){
            line = line.trim();
            String[] words = line.split(" ");
            String lastWord = words[words.length - 1];
            
             String[] param = line.split("is");
            if(RomanChar.Get(lastWord) != null){
                galacticSymbol.SetSymbol(param[0], RomanChar.Get(param[1]));
            }
            else if(lastWord.toLowerCase().equals("credits")){
                int lastSpaceIdx = param[0].lastIndexOf(" ");
                
                int totalItem = galacticSymbol.Calculate(param[0].substring(0, lastSpaceIdx));
                
                String[] priceStr = param[1].split(" ");
                int price = Integer.parseInt(priceStr[0]);
                
                String itemName = param[0].substring(lastSpaceIdx);
                galacticSymbol.SetPrice(itemName, price/totalItem);
            }
            else if(lastWord.contains("?") && param[0].trim().toLowerCase().equals("how many credits")){
                int lastSpaceIdx = param[1].trim().lastIndexOf(" ");
                String galacticNumber = param[1].substring(0, lastSpaceIdx);
                String itemName = param[1].substring(lastSpaceIdx);
                output += galacticSymbol.GetTotalCredits(galacticNumber, itemName);
            }
            else{
                output+= "I have no idea what you are talking about\r\n";
            }
                
            
        }
        return output;
    }
}
