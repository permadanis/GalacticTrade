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
        //String[] lines = text.split(System.getProperty("line.separator"));
        String[] lines = text.split("\n");
        for(String line: lines){
            line = line.trim();
            String[] words = line.split(" ");
            String lastWord = words[words.length - 1];
            
             String[] param = line.split(" is ");
            if(RomanChar.Get(lastWord) != null){
                RomanChar romanchar = RomanChar.Get(param[1].trim());
                galacticSymbol.SetSymbol(param[0], romanchar);
            }
            else if(lastWord.toLowerCase().equals("credits")){
                int lastSpaceIdx = param[0].trim().lastIndexOf(" ");
                String galacticNumber = param[0].substring(0, lastSpaceIdx);
                int totalItem = galacticSymbol.Calculate(galacticNumber);
                
                String[] priceStr = param[1].split(" ");
                double price = Double.parseDouble(priceStr[0]);
                
                String itemName = param[0].substring(lastSpaceIdx).trim();
                galacticSymbol.SetPrice(itemName, price/(double)totalItem);
            }else if(lastWord.contains("?") && param[0].trim().toLowerCase().equals("how much")){
                int lastQuestMark = param[1].trim().lastIndexOf("?");
                
                String galacticNumber = param[1].substring(0, lastQuestMark);
                int total =  galacticSymbol.Calculate(galacticNumber);
                output += galacticNumber +" is "+total+"\n\r";
             }
            else if(lastWord.contains("?") && param[0].trim().toLowerCase().equals("how many credits")){
                int lastQuestMark = param[1].trim().lastIndexOf("?");
                String tmp = param[1].substring(0, lastQuestMark);
                
                int lastSpaceIdx = tmp.trim().lastIndexOf(" ");
               
                String galacticNumber = param[1].substring(0, lastSpaceIdx);
                String itemName = param[1].substring(lastSpaceIdx, lastQuestMark).trim();
                output += galacticSymbol.GetTotalCredits(galacticNumber, itemName)+"\r\n";
            }             
            else{
                output+= "I have no idea what you are talking about\r\n";
            }
                
            
        }
        return output;
    }
}
