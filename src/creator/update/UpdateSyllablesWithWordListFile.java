package creator.update;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

// syllables2.txt är en (manuell) ihopslagning av Syllables.txt och SyllablesUpdate.txt
// syllables2.txt är alltså "default" filen

public class UpdateSyllablesWithWordListFile {
	
	public static void main(String[] args){
		try {
			double startTime = System.currentTimeMillis();
			
			File syllablesRead = new File("syllables3.txt");
			File syllablesWrite = new File("syllables4.txt");
			File wordList = new File("SINGLE.txt");
			File wordsLeft = new File("leftofsingle.txt");
			
			ArrayList<SyllableWord> words = new ArrayList<SyllableWord>();
			ArrayList<String> wordsThatDoesNotExist = new ArrayList<String>();
			
			String word;
			String syllables;
			
			BufferedReader readerSyllables;
			BufferedWriter writerSyllables = new BufferedWriter(new FileWriter(syllablesWrite));
			BufferedReader readerWordList = new BufferedReader(new FileReader(wordList));
			BufferedWriter writerWordsLeft = new BufferedWriter(new FileWriter(wordsLeft));
			
			String textSyllables;
			
			boolean exists;
			boolean endsWithES = false;
			boolean checkPlural;
			
			boolean endsWithED;
			
			boolean endsWithING;
			boolean removeLastLetter = false;
			boolean endsWithABLE;
			boolean endsWithNESS;
			boolean endsWithILY;
			boolean endsWithLY;
			boolean endsWithER;
			boolean endsWithEST;
			boolean endsWithABILITY;
			boolean endsWithLESS;
			boolean endsWithISH;
			
			boolean startsWithMIS;
			boolean startsWithDEMI;
			boolean startsWithDIS;
			boolean startsWithDE;
			boolean startsWithPRE;
			boolean startsWithPRO;
			boolean startsWithANTI;
			boolean startsWithNON;
			boolean startsWithRE;
			
			String tempWord;
			String tempWordSTART;
			
			while ((word = readerWordList.readLine()) != null) {
				tempWord = null;
				tempWordSTART = null;
				exists = false;
				// ordet ska inte läggas in igen
				for(int i = 0; i < words.size(); i++){
					if(words.get(i).getWord().equalsIgnoreCase(word)){
						exists = true;
						break;
					}
				}
				if(exists){
					continue;
				}
				checkPlural = false;
				endsWithED = false;
				endsWithING = false;
				endsWithABLE = false;
				endsWithNESS = false;
				endsWithILY = false;
				endsWithLY = false;
				endsWithER = false;
				endsWithEST = false;
				endsWithABILITY = false;
				endsWithLESS = false;
				endsWithISH = false;
				
				startsWithMIS = false;
				startsWithDEMI = false;
				startsWithDIS = false;
				startsWithDE = false;
				startsWithPRE = false;
				startsWithPRO = false;
				startsWithANTI = false;
				startsWithNON = false;
				startsWithRE = false;
				word = word.toLowerCase(); // just in case
				if(word.length() > 1 && word.charAt(word.length()-1) == 'd' && word.charAt(word.length()-2) == 'e'){
					endsWithED = true;
				}
				else if(word.length() > 2 && word.charAt(word.length()-1) == 'g' && word.charAt(word.length()-2) == 'n' && word.charAt(word.length()-3) == 'i'){
					endsWithING = true;
				}
				else if(word.length() > 3 && word.charAt(word.length()-4) == 'a' && word.charAt(word.length()-3) == 'b' && word.charAt(word.length()-2) == 'l' && word.charAt(word.length()-1) == 'e'){
					endsWithABLE = true;
				}
				else if(word.length() > 3 && word.charAt(word.length()-4) == 'n' && word.charAt(word.length()-3) == 'e' && word.charAt(word.length()-2) == 's' && word.charAt(word.length()-1) == 's'){
					endsWithNESS = true;
				}
				else if(word.length() > 2 && word.charAt(word.length()-3) == 'i' && word.charAt(word.length()-2) == 'l' && word.charAt(word.length()-1) == 'y'){
					endsWithILY = true;
				}
				else if(word.length() > 1 && word.charAt(word.length()-2) == 'l' && word.charAt(word.length()-1) == 'y'){
					endsWithLY = true;
				}
				else if(word.length() > 1 && word.charAt(word.length()-2) == 'e' && word.charAt(word.length()-1) == 'r'){
					endsWithER = true;
				}
				else if(word.length() > 2 && word.charAt(word.length()-3) == 'e' && word.charAt(word.length()-2) == 's' && word.charAt(word.length()-1) == 't'){
					endsWithEST = true;
				}
				else if(word.length() > 6 && word.charAt(word.length()-5) == 'a' && word.charAt(word.length()-5) == 'b' && word.charAt(word.length()-5) == 'i' && word.charAt(word.length()-4) == 'l' && word.charAt(word.length()-3) == 'i' && word.charAt(word.length()-2) == 't' && word.charAt(word.length()-1) == 'y'){
					endsWithABILITY = true;
				}
				else if(word.length() > 3 && word.charAt(word.length()-4) == 'l' && word.charAt(word.length()-3) == 'e' && word.charAt(word.length()-2) == 's' && word.charAt(word.length()-1) == 's'){
					endsWithLESS = true;
				}
				else if(word.length() > 2 && word.charAt(word.length()-3) == 'i' && word.charAt(word.length()-2) == 's' && word.charAt(word.length()-1) == 'h'){
					endsWithISH = true;
				}
				else if(word.length() > 1 && word.charAt(word.length()-1) == 's'){ // plural form
					if(word.charAt(word.length()-2) == 'e'){
						endsWithES = true;						
					}
					else{
						endsWithES = false;
					}
					checkPlural = true;
				}
				
				// Starts with
				if(word.length() > 2 && word.charAt(0) == 'm' && word.charAt(1) == 'i' && word.charAt(2) == 's'){
					startsWithMIS = true;
				}
				else if(word.length() > 3 && word.charAt(0) == 'd' && word.charAt(1) == 'e' && word.charAt(2) == 'm' && word.charAt(3) == 'i'){
					startsWithDEMI = true;
				}
				else if(word.length() > 2 && word.charAt(0) == 'd' && word.charAt(1) == 'i' && word.charAt(2) == 's'){
					startsWithDIS = true;
				}
				else if(word.length() > 1 && word.charAt(0) == 'd' && word.charAt(1) == 'e'){
					startsWithDE = true;
				}
				else if(word.length() > 2 && word.charAt(0) == 'p' && word.charAt(1) == 'r' && word.charAt(2) == 'e'){
					startsWithPRE = true;
				}
				else if(word.length() > 2 && word.charAt(0) == 'p' && word.charAt(1) == 'r' && word.charAt(2) == 'o'){
					startsWithPRO = true;
				}
				else if(word.length() > 3 && word.charAt(0) == 'a' && word.charAt(1) == 'n' && word.charAt(2) == 't' && word.charAt(3) == 'i'){
					startsWithANTI = true;
				}
				else if(word.length() > 2 && word.charAt(0) == 'n' && word.charAt(1) == 'o' && word.charAt(2) == 'n'){
					startsWithNON = true;
				}
				else if(word.length() > 1 && word.charAt(0) == 'r' && word.charAt(1) == 'e'){
					startsWithRE = true;
				}
				
				// försök att hitta ordet i Syllables ordlistan
				readerSyllables = new BufferedReader(new FileReader(syllablesRead));
				
				
				while ((textSyllables = readerSyllables.readLine()) != null) {
					if(word.equalsIgnoreCase(textSyllables.substring(0,textSyllables.indexOf("=")))){
						exists = true;
						// lägg till ordet i listan
						words.add(new SyllableWord(word, textSyllables.substring(textSyllables.indexOf("=")+1)));
						System.out.println(words.size() + ": Word added: " + words.get(words.size()-1).toString());
						break;
					}
					if(checkPlural && (word.substring(0, word.length()-1).equalsIgnoreCase(textSyllables.substring(0,textSyllables.indexOf("=")))
							|| endsWithES && word.length() > 2 && word.substring(0, word.length()-2).equalsIgnoreCase(textSyllables.substring(0,textSyllables.indexOf("="))))){
						tempWord = textSyllables;
					}
					else if(endsWithED
							&& (word.substring(0, word.length()-1).equalsIgnoreCase(textSyllables.substring(0,textSyllables.indexOf("=")))
								|| word.length() > 2 && word.substring(0, word.length()-2).equalsIgnoreCase(textSyllables.substring(0,textSyllables.indexOf("="))))){
						tempWord = textSyllables;
					}
					else if(endsWithING && word.length() > 3 && (word.substring(0, word.length()-3).equalsIgnoreCase(textSyllables.substring(0,textSyllables.indexOf("="))))){
						tempWord = textSyllables;
						removeLastLetter = false;
					}
					else if(endsWithING && word.length() > 3 && word.substring(0, word.length()-3).equalsIgnoreCase(textSyllables.substring(0,textSyllables.indexOf("=")-1))){
						// t.ex. hope -> hoping
						tempWord = textSyllables;
						removeLastLetter = true;
					}
					else if(endsWithABLE && word.length() > 4 && word.substring(0, word.length()-4).equalsIgnoreCase(textSyllables.substring(0,textSyllables.indexOf("=")))){
						tempWord = textSyllables;
					}
					else if(endsWithNESS && word.length() > 4 && word.substring(0, word.length()-4).equalsIgnoreCase(textSyllables.substring(0,textSyllables.indexOf("=")))){
						tempWord = textSyllables;
					}
					else if(endsWithILY && word.length() > 3 && word.substring(0, word.length()-3).equalsIgnoreCase(textSyllables.substring(0,textSyllables.indexOf("=")))){
						tempWord = textSyllables;
						removeLastLetter = false;
					}
					else if(endsWithILY && word.length() > 3 && word.substring(0, word.length()-3).equalsIgnoreCase(textSyllables.substring(0,textSyllables.indexOf("=")-1))){
						// t.ex. floppy -> floppily
						tempWord = textSyllables;
						removeLastLetter = true;
					}
					else if(endsWithLY && word.length() > 2 && word.substring(0, word.length()-2).equalsIgnoreCase(textSyllables.substring(0,textSyllables.indexOf("=")))){
						tempWord = textSyllables;
					}
					else if(endsWithER && word.length() > 2 && word.substring(0, word.length()-2).equalsIgnoreCase(textSyllables.substring(0,textSyllables.indexOf("=")))){
						tempWord = textSyllables;
						removeLastLetter = false;
					}
					else if(endsWithER && word.length() > 2 && word.substring(0, word.length()-2).equalsIgnoreCase(textSyllables.substring(0,textSyllables.indexOf("=")-1))){
						// t.ex. blue -> bluer
						tempWord = textSyllables;
						removeLastLetter = true;
					}
					else if(endsWithEST && word.length() > 3 && word.substring(0, word.length()-3).equalsIgnoreCase(textSyllables.substring(0,textSyllables.indexOf("=")))){
						tempWord = textSyllables;
						removeLastLetter = false;
					}
					else if(endsWithEST && word.length() > 3 && word.substring(0, word.length()-3).equalsIgnoreCase(textSyllables.substring(0,textSyllables.indexOf("=")-1))){
						// t.ex. blue -> bluest
						tempWord = textSyllables;
						removeLastLetter = true;
					}
					else if(endsWithABILITY && word.length() > 7 && word.substring(0, word.length()-7).equalsIgnoreCase(textSyllables.substring(0,textSyllables.indexOf("=")))){
						tempWord = textSyllables;
					}
					else if(endsWithLESS && word.length() > 4 && word.substring(0, word.length()-4).equalsIgnoreCase(textSyllables.substring(0,textSyllables.indexOf("=")))){
						tempWord = textSyllables;
					}
					else if(endsWithISH && word.length() > 3 && word.substring(0, word.length()-3).equalsIgnoreCase(textSyllables.substring(0,textSyllables.indexOf("=")))){
						tempWord = textSyllables;
						removeLastLetter = false;
					}
					else if(endsWithISH && word.length() > 3 && word.substring(0, word.length()-3).equalsIgnoreCase(textSyllables.substring(0,textSyllables.indexOf("=")-1))){
						// t.ex. blue -> bluish
						tempWord = textSyllables;
						removeLastLetter = true;
					}
					
					// starts with
					if(startsWithMIS && word.length() > 3 && word.substring(3).equalsIgnoreCase(textSyllables.substring(0,textSyllables.indexOf("=")))){
						tempWordSTART = textSyllables;
					}
					else if(startsWithDEMI && word.length() > 4 && word.substring(4).equalsIgnoreCase(textSyllables.substring(0,textSyllables.indexOf("=")))){
						tempWordSTART = textSyllables;
					}
					else if(startsWithDIS && word.length() > 3 && word.substring(3).equalsIgnoreCase(textSyllables.substring(0,textSyllables.indexOf("=")))){
						tempWordSTART = textSyllables;
					}
					else if(startsWithDE && word.length() > 2 && word.substring(2).equalsIgnoreCase(textSyllables.substring(0,textSyllables.indexOf("=")))){
						tempWordSTART = textSyllables;
					}
					else if(startsWithPRE && word.length() > 3 && word.substring(3).equalsIgnoreCase(textSyllables.substring(0,textSyllables.indexOf("=")))){
						tempWordSTART = textSyllables;
					}
					else if(startsWithPRO && word.length() > 3 && word.substring(3).equalsIgnoreCase(textSyllables.substring(0,textSyllables.indexOf("=")))){
						tempWordSTART = textSyllables;
					}
					else if(startsWithANTI && word.length() > 4 && word.substring(4).equalsIgnoreCase(textSyllables.substring(0,textSyllables.indexOf("=")))){
						tempWordSTART = textSyllables;
					}
					else if(startsWithNON && word.length() > 3 && word.substring(3).equalsIgnoreCase(textSyllables.substring(0,textSyllables.indexOf("=")))){
						tempWordSTART = textSyllables;
					}
					else if(startsWithRE && word.length() > 2 && word.substring(2).equalsIgnoreCase(textSyllables.substring(0,textSyllables.indexOf("=")))){
						tempWordSTART = textSyllables;
					}
				}
				
				
				
				
				if(!exists && tempWord != null){
					// använd temprWord om det finns
					if(checkPlural){ // found a plural form
						if(tempWord.charAt(tempWord.length()-1) == 'e'){
							if(tempWord.length() > 1 && tempWord.charAt(tempWord.length()-2) == 's'){ // t.ex. house -> hous·es
								syllables = tempWord.substring(tempWord.indexOf("=")+1);
								syllables = syllables.substring(0, syllables.length()-1) + "·es"; // ta bort sista e:et och byt ut det mot ·es
								words.add(new SyllableWord(word, syllables));
							}
							else{ // t.ex. ride -> rides
								syllables = tempWord.substring(tempWord.indexOf("=")+1) + "s";
								words.add(new SyllableWord(word, syllables));
							}
						}
						else if(endsWithES){ // t.ex. mass -> mass·es
							syllables = tempWord.substring(tempWord.indexOf("=")+1) + "·es";
							words.add(new SyllableWord(word, syllables));
						}
						else{ // t.ex. star -> stars
							syllables = tempWord.substring(tempWord.indexOf("=")+1) + "s";
							words.add(new SyllableWord(word, syllables));
						}
					}
					else if(endsWithED){ //
						if(tempWord.charAt(tempWord.length()-1) == 'e'){ // the e is already there. t.ex. hope -> hop·ed
							syllables = tempWord.substring(tempWord.indexOf("=")+1);
							syllables = syllables.substring(0, syllables.length()-1) + "·ed"; // ta bort sista e:et och byt ut det mot ·ed
							words.add(new SyllableWord(word, syllables));
						}
						else{ // adds ed at the end. t.ex. jump -> jump·ed
							syllables = tempWord.substring(tempWord.indexOf("=")+1) + "·ed";
							words.add(new SyllableWord(word, syllables));
						}
					}
					else if(endsWithING){
						if(removeLastLetter){// removes the last letter and adds ing at the end. t.ex. hope -> hop·ing
							syllables = tempWord.substring(tempWord.indexOf("=")+1, tempWord.length()-1) + "·ing";
							words.add(new SyllableWord(word, syllables));
						}
						else{ // adds ing at the end. t.ex. jump -> jump·ing
							syllables = tempWord.substring(tempWord.indexOf("=")+1) + "·ing";
							words.add(new SyllableWord(word, syllables));
						}
					}
					else if(endsWithABLE){ // adds a·ble at the end. t.ex. jump -> jump·a·ble
						syllables = tempWord.substring(tempWord.indexOf("=")+1) + "·a·ble";
						words.add(new SyllableWord(word, syllables));
					}
					else if(endsWithNESS){ // adds ness at the end.
						syllables = tempWord.substring(tempWord.indexOf("=")+1) + "·ness";
						words.add(new SyllableWord(word, syllables));
					}
					else if(endsWithILY){ 
						if(removeLastLetter){// removes the last letter and adds i·ly at the end. t.ex. flop·py -> flop·pi·ly
							syllables = tempWord.substring(tempWord.indexOf("=")+1, tempWord.length()-1) + "i·ly";
							words.add(new SyllableWord(word, syllables));
						}
						// must remove the last letter?
					}
					else if(endsWithLY){ // adds ly at the end.
						syllables = tempWord.substring(tempWord.indexOf("=")+1) + "·ly";
						words.add(new SyllableWord(word, syllables));
					}
					else if(endsWithER){
						if(removeLastLetter){// removes the last letter and adds er at the end. t.ex. blue -> blu·er
							syllables = tempWord.substring(tempWord.indexOf("=")+1, tempWord.length()-1) + "·er";
							words.add(new SyllableWord(word, syllables));
						}
						else{ // adds er at the end. t.ex. red -> red·er
							syllables = tempWord.substring(tempWord.indexOf("=")+1) + "·er";
							words.add(new SyllableWord(word, syllables));
						}
					}
					else if(endsWithEST){ 
						if(removeLastLetter){// removes the last letter and adds est at the end. t.ex. blue -> blu·est
							syllables = tempWord.substring(tempWord.indexOf("=")+1, tempWord.length()-1) + "·est";
							words.add(new SyllableWord(word, syllables));
						}
						else{ // adds est at the end. t.ex. red -> red·est
							syllables = tempWord.substring(tempWord.indexOf("=")+1) + "·est";
							words.add(new SyllableWord(word, syllables));
						}
					}
					else if(endsWithABILITY){ // adds ability at the end.
						syllables = tempWord.substring(tempWord.indexOf("=")+1) + "·a·bil·i·ty";
						words.add(new SyllableWord(word, syllables));
					}
					else if(endsWithLESS){ // adds less at the end.
						syllables = tempWord.substring(tempWord.indexOf("=")+1) + "·less";
						words.add(new SyllableWord(word, syllables));
					}
					else if(endsWithISH){ 
						if(removeLastLetter){// removes the last letter and adds est at the end. t.ex. blue -> blu·ish
							syllables = tempWord.substring(tempWord.indexOf("=")+1, tempWord.length()-1) + "·ish";
							words.add(new SyllableWord(word, syllables));
						}
						else{ // adds ish at the end. t.ex. high -> high·ish
							syllables = tempWord.substring(tempWord.indexOf("=")+1) + "·ish";
							words.add(new SyllableWord(word, syllables));
						}
					}
					System.out.println(words.size() + ": Word added: " + words.get(words.size()-1).toString());
				}
				else if(!exists && tempWordSTART != null){
					if(startsWithMIS){ // adds mis at the start
						syllables = "mis·" + tempWordSTART.substring(tempWordSTART.indexOf("=")+1);
						words.add(new SyllableWord(word, syllables));
					}
					else if(startsWithDEMI){ // adds demi at the start
						syllables = "de·mi·" + tempWordSTART.substring(tempWordSTART.indexOf("=")+1);
						words.add(new SyllableWord(word, syllables));
					}
					else if(startsWithDIS){ // adds dis at the start
						syllables = "dis·" + tempWordSTART.substring(tempWordSTART.indexOf("=")+1);
						words.add(new SyllableWord(word, syllables));
					}
					else if(startsWithDE){ // adds de at the start
						syllables = "de·" + tempWordSTART.substring(tempWordSTART.indexOf("=")+1);
						words.add(new SyllableWord(word, syllables));
					}
					else if(startsWithPRE){ // adds pre at the start
						syllables = "pre·" + tempWordSTART.substring(tempWordSTART.indexOf("=")+1);
						words.add(new SyllableWord(word, syllables));
					}
					else if(startsWithPRO){ // adds pro at the start
						syllables = "pro·" + tempWordSTART.substring(tempWordSTART.indexOf("=")+1);
						words.add(new SyllableWord(word, syllables));
					}
					else if(startsWithANTI){ // adds anti at the start
						syllables = "an·ti·" + tempWordSTART.substring(tempWordSTART.indexOf("=")+1);
						words.add(new SyllableWord(word, syllables));
					}
					else if(startsWithNON){ // adds non at the start
						syllables = "non·" + tempWordSTART.substring(tempWordSTART.indexOf("=")+1);
						words.add(new SyllableWord(word, syllables));
					}
					else if(startsWithRE){ // adds re at the start
						syllables = "re·" + tempWordSTART.substring(tempWordSTART.indexOf("=")+1);
						words.add(new SyllableWord(word, syllables));
					}
					System.out.println(words.size() + ": Word added: " + words.get(words.size()-1).toString());
				}
				else if(!exists){
					// hittade inte ordet och ingen singular version av det
					wordsThatDoesNotExist.add(word);
					System.out.println(wordsThatDoesNotExist.size() + ": Word was not added: " + wordsThatDoesNotExist.get(wordsThatDoesNotExist.size()-1));
				}
			}
			System.out.println("Words size: " + words.size());
			System.out.println("Words not found " + wordsThatDoesNotExist.size());
			for(int i = 0; i < words.size(); i++){
				writerSyllables.write(words.get(i).toString());
				writerSyllables.newLine();
			}
			
			for(int i = 0; i < wordsThatDoesNotExist.size(); i++){
				writerWordsLeft.write(wordsThatDoesNotExist.get(i));
				writerWordsLeft.newLine();
			}
			
			writerSyllables.close();
			writerWordsLeft.close();
			
			double execTime = System.currentTimeMillis()-startTime;
			int seconds = (int)execTime/1000;
			int minutes = seconds/60;
			seconds = seconds%60;
			int hours = minutes/60;
			minutes = minutes%60;
			System.out.println("Time (HH:MM:SS): " + hours + ":" + minutes + ":" + seconds);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
