/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prospace.galactictrade;

/**
 *
 * @author YTR
 */
class InputProcessor {

    GalacticSymbols galacticSymbol = new GalacticSymbols();

    String Process(String text) {

        galacticSymbol.Clear();
        String output = "";
        //String[] lines = text.split(System.getProperty("line.separator"));
        String[] lines = text.split("\n");
        for (String line : lines) {
            line = line.trim();
            output += processLine(line);

        }
        return output;
    }

    private String processLine(String lineInput) {
        String[] words = lineInput.split(" ");
        String lastWord = words[words.length - 1];

        if(!lineInput.contains(" is "))
            return ErrorCode.NoIdea.toString();
        
        String[] param = lineInput.split(" is ");
        param[0] = param[0].toLowerCase().trim();
       
       //  param[1] = param[1].toLowerCase().trim();
        if (RomanChar.Get(lastWord) != null) {
            String result = SetSymbol(lineInput);
            if (!result.equals("")) {
                return result;
            }
        } else if (lastWord.toLowerCase().equals("credits")) {
            String result = SetPrice(lineInput);
            if (!result.equals("")) {
                return result;
            }
        } else if (lastWord.contains("?") && param[0].contains("how") && param[0].contains("much")
                && param[0].indexOf("how") < param[0].indexOf("much")) {
            int result = CalculateGalacticNumber(lineInput);

            if (result < 0) {
                return ErrorCode.CalculateGalacticNumberFailed.toString();
            } else {
                int lastQuestMark = param[1].trim().lastIndexOf("?");
                String galacticNumber = param[1].trim().substring(0, lastQuestMark);
                return galacticNumber.trim() + " is " + result + "\n\r";
            }

        } else if (lastWord.contains("?") && param[0].contains("how") && param[0].contains("many") && param[0].contains("credits")
                   && param[0].indexOf("how") < param[0].indexOf("many")
                   && param[0].indexOf("many") < param[0].indexOf("credits")) {
            return CalculateTotalCredit(lineInput);
        } else {
            return ErrorCode.NoIdea.toString();
        }

        return "";
    }

    private String SetSymbol(String lineInput) {
        String[] param = lineInput.split(" is ");
        for (String s : param) {
            if (s.trim().contains(" ")) {
                return ErrorCode.SetSymbol_Failed.toString();
            }

        }
        try {
            RomanChar romanchar = RomanChar.Get(param[1].trim());
            galacticSymbol.SetSymbol(param[0].trim(), romanchar);
        } catch (Exception ex) {
            ex.printStackTrace();
            return ErrorCode.SetSymbol_Failed.toString();
        }
        return "";

    }

    private String SetPrice(String lineInput) {
        String[] param = lineInput.split(" is ");
        try {
            int lastSpaceIdx = param[0].trim().lastIndexOf(" ");
            String galacticNumber = param[0].trim().substring(0, lastSpaceIdx);
            int totalItem = galacticSymbol.Calculate(galacticNumber);
            if (totalItem < 0) {
                return ErrorCode.InvalidGalacticNumber.toString();
            }
            String[] priceStr = param[1].trim().split(" ");
            double price = Double.parseDouble(priceStr[0]);

            String itemName = param[0].trim().substring(lastSpaceIdx).trim();
            galacticSymbol.SetPrice(itemName, price / (double) totalItem);
        } catch (Exception ex) {
            ex.printStackTrace();
            return ErrorCode.SetPrice_Failed.toString();
        }

        return "";
    }

    private String CalculateTotalCredit(String lineInput) {
        String[] param = lineInput.split(" is ");

        int lastQuestMark = param[1].trim().lastIndexOf("?");
        String tmp = param[1].trim().substring(0, lastQuestMark);

        int lastSpaceIdx = tmp.trim().lastIndexOf(" ");

        String galacticNumber = param[1].trim().substring(0, lastSpaceIdx);
        String itemName = param[1].trim().substring(lastSpaceIdx, lastQuestMark).trim();
        Double totalCredit = galacticSymbol.GetTotalCredits(galacticNumber, itemName);
        if (totalCredit == null) {
            return ErrorCode.CalculateTotalCreditFailed.toString();
        } else {
            return galacticNumber + " " + itemName + " is " + ((Number) totalCredit).intValue() + " Credits\n\r";
        }

    }

    private int CalculateGalacticNumber(String lineInput) {
        String[] param = lineInput.split(" is ");

        int lastQuestMark = param[1].trim().lastIndexOf("?");

        String galacticNumber = param[1].trim().substring(0, lastQuestMark);
        int total = galacticSymbol.Calculate(galacticNumber);
        return total;

    }

}

enum ErrorCode {
    SetSymbol_Failed("<<Error: Galactic Setting Symbols Failed. Please check your input. example: glob is I>>\n\r"),
    SetPrice_Failed("<<Error: Can not Set Price. Please check your inputs. Example glob glob Silver is 34 Credits>>"),
    InvalidGalacticNumber("<<Error: Invalid symbols. Please Set Galactic Symbols to Roman numerals.>>\n\r"),
    CalculateGalacticNumberFailed("<<Error: Invalid symbols. Please Set Galactic Symbols to Roman numerals.>>\n\r"),
    CalculateTotalCreditFailed("<<Error: Can not Calculate Credits. Please Check your Galactic Symbol and Item Price. Example: glob glob Silver is 34 Credits>>\r\n"),
    NoIdea("I have no idea what you are talking about\r\n");
    String value;

    ErrorCode(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
