# GalacticTrade
Requirement
Maven
JDK 11.0.8

Build:
mvn package

Run Main File:
java -cp target\GalacticTrade-1.0-SNAPSHOT.jar com.prospace.galactictrade.Main input.txt

-------------------------
Class Hierachy		
-------------------------


	|-----------------|		          |------------|
	| InputProcessor  |<----------------------| MainPanel  |
	|-----------------|			  |------------|
   		|
                |
	        |
	  	v
	|----------------|                        |-----------|
	|GalacticSymbols |----------------------->|RomanRule  |
	|--------------- |			  |-----------|
		|   
		|
		v
        |<<Emum>>	|
	|---------------|
	|RomanChar	|
	|---------------|

 




InputProcessor
~String Process(String text)
-ProcessLine(String lineInput)
-String SetSymbol(String lineInput)
-String SetPrice(String lineInput)
-String CalculateTotalCredit(String lineInput)
-String CalculateGalacticNumber(String lineInput)

GalacticSymbol
+void SetSymbol(String symbol, RomanChar romanChar)
~boolean Contains(String symbol)
+String ToRomanSymbol(String galacticSymbols)
+void SetPrice(String itemName, Double price)
+Double GetPrice(String itemName)
+int CalculateGalacticNumber(String galacticNumber)
+String GetTotalCredit(String galacticNumber, String itemName)
+void Clear()

RomanRule
+boolean IsValid(String input, GalacticSymbol galacticSymbol)
+boolean IsValidRoman(String romanNumber)
-boolean checkNo3DuplicateInARow(String romanNumber)
-boolean checkNoMore4TimeAppear(String romanNumber)
-boolean checkBigToSmall(String romanNumber)
+int GetValue(String validRomanNumber)

RomanChar
I
V
X
L
C
D
M