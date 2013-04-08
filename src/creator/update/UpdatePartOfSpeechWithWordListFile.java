package creator.update;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;



public class UpdatePartOfSpeechWithWordListFile {
	
	public static void main(String[] args){
		try {
			double startTime = System.currentTimeMillis();
			
			File partofspeech = new File("partofspeech2.txt"); // reads from here
			File partofspeech2 = new File("partofspeech3.txt"); // Writes here
			File wordList = new File("SINGLE.txt");
			File wordsLeft = new File("leftofsinglepartofspeech.txt");
			
			ArrayList<PartOfSpeechWord> words = new ArrayList<PartOfSpeechWord>();
			ArrayList<String> wordsThatDoesNotExist = new ArrayList<String>();
			
			String word;
			String wordType;
			
			BufferedReader readerPartOfSpeech;
			BufferedWriter writerPartOfSpeech = new BufferedWriter(new FileWriter(partofspeech2));
			BufferedReader readerWordList = new BufferedReader(new FileReader(wordList));
			BufferedWriter writerWordsLeft = new BufferedWriter(new FileWriter(wordsLeft));
			
			String text;
			int pos;
			
			boolean exists;
			boolean endsWithES = false;
			boolean checkPlural;
			
			boolean endsWithED;
			
			boolean endsWithING;
			boolean endsWithABLE;
			boolean endsWithNESS;
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
			
			String tempWordEND;
			String tempWordSTART;
			
			while ((word = readerWordList.readLine()) != null) {
				tempWordEND = null;
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
				if(word.length() > 1 && word.charAt(word.length()-1) == 's'){ // plural form
					if(word.charAt(word.length()-2) == 'e'){
						endsWithES = true;						
					}
					else{
						endsWithES = false;
					}
					checkPlural = true;
				}
				if(word.length() > 1 && word.charAt(word.length()-1) == 'd' && word.charAt(word.length()-2) == 'e'){
					endsWithED = true;
				}
				if(word.length() > 2 && word.charAt(word.length()-1) == 'g' && word.charAt(word.length()-2) == 'n' && word.charAt(word.length()-3) == 'i'){
					endsWithING = true;
				}
				if(word.length() > 3 && word.charAt(word.length()-4) == 'a' && word.charAt(word.length()-3) == 'b' && word.charAt(word.length()-2) == 'l' && word.charAt(word.length()-1) == 'e'){
					endsWithABLE = true;
				}
				if(word.length() > 3 && word.charAt(word.length()-4) == 'n' && word.charAt(word.length()-3) == 'e' && word.charAt(word.length()-2) == 's' && word.charAt(word.length()-1) == 's'){
					endsWithNESS = true;
				}
				if(word.length() > 1 && word.charAt(word.length()-2) == 'l' && word.charAt(word.length()-1) == 'y'){
					endsWithLY = true;
				}
				if(word.length() > 1 && word.charAt(word.length()-2) == 'e' && word.charAt(word.length()-1) == 'r'){
					endsWithER = true;
				}
				if(word.length() > 2 && word.charAt(word.length()-3) == 'e' && word.charAt(word.length()-2) == 's' && word.charAt(word.length()-1) == 't'){
					endsWithEST = true;
				}
				if(word.length() > 6 && word.charAt(word.length()-5) == 'a' && word.charAt(word.length()-5) == 'b' && word.charAt(word.length()-5) == 'i' && word.charAt(word.length()-4) == 'l' && word.charAt(word.length()-3) == 'i' && word.charAt(word.length()-2) == 't' && word.charAt(word.length()-1) == 'y'){
					endsWithABILITY = true;
				}
				if(word.length() > 3 && word.charAt(word.length()-4) == 'l' && word.charAt(word.length()-3) == 'e' && word.charAt(word.length()-2) == 's' && word.charAt(word.length()-1) == 's'){
					endsWithLESS = true;
				}
				if(word.length() > 2 && word.charAt(word.length()-3) == 'i' && word.charAt(word.length()-2) == 's' && word.charAt(word.length()-1) == 'h'){
					endsWithISH = true;
				}
				
				// Starts with
				if(word.length() > 2 && word.charAt(0) == 'm' && word.charAt(1) == 'i' && word.charAt(2) == 's'){
					startsWithMIS = true;
				}
				if(word.length() > 3 && word.charAt(0) == 'd' && word.charAt(1) == 'e' && word.charAt(2) == 'm' && word.charAt(3) == 'i'){
					startsWithDEMI = true;
				}
				if(word.length() > 2 && word.charAt(0) == 'd' && word.charAt(1) == 'i' && word.charAt(2) == 's'){
					startsWithDIS = true;
				}
				if(word.length() > 1 && word.charAt(0) == 'd' && word.charAt(1) == 'e'){
					startsWithDE = true;
				}
				if(word.length() > 2 && word.charAt(0) == 'p' && word.charAt(1) == 'r' && word.charAt(2) == 'e'){
					startsWithPRE = true;
				}
				if(word.length() > 2 && word.charAt(0) == 'p' && word.charAt(1) == 'r' && word.charAt(2) == 'o'){
					startsWithPRO = true;
				}
				if(word.length() > 3 && word.charAt(0) == 'a' && word.charAt(1) == 'n' && word.charAt(2) == 't' && word.charAt(3) == 'i'){
					startsWithANTI = true;
				}
				if(word.length() > 2 && word.charAt(0) == 'n' && word.charAt(1) == 'o' && word.charAt(2) == 'n'){
					startsWithNON = true;
				}
				if(word.length() > 1 && word.charAt(0) == 'r' && word.charAt(1) == 'e'){
					startsWithRE = true;
				}
				
				// försök att hitta ordet i Syllables ordlistan
				readerPartOfSpeech = new BufferedReader(new FileReader(partofspeech));
				
				
				while ((text = readerPartOfSpeech.readLine()) != null) {
					if(word.equalsIgnoreCase(text.substring(0,text.indexOf("=")))){
						exists = true;
						break;
					}
					if(checkPlural && (word.substring(0, word.length()-1).equalsIgnoreCase(text.substring(0,text.indexOf("=")))
							|| endsWithES && word.length() > 2 && word.substring(0, word.length()-2).equalsIgnoreCase(text.substring(0,text.indexOf("="))))){
						tempWordEND = text;
					}
					else if(endsWithED
							&& (word.substring(0, word.length()-1).equalsIgnoreCase(text.substring(0,text.indexOf("=")))
								|| word.length() > 2 && word.substring(0, word.length()-2).equalsIgnoreCase(text.substring(0,text.indexOf("="))))){
						tempWordEND = text;
					}
					else if(endsWithING && word.length() > 3 && (word.substring(0, word.length()-3).equalsIgnoreCase(text.substring(0,text.indexOf("="))))){
						tempWordEND = text;
					}
					else if(endsWithING && word.length() > 3 && word.substring(0, word.length()-3).equalsIgnoreCase(text.substring(0,text.indexOf("=")-1))){
						// t.ex. hope -> hoping
						tempWordEND = text;
					}
					else if(endsWithABLE && word.length() > 4 && word.substring(0, word.length()-4).equalsIgnoreCase(text.substring(0,text.indexOf("=")))){
						tempWordEND = text;
					}
					else if(endsWithNESS && word.length() > 4 && word.substring(0, word.length()-4).equalsIgnoreCase(text.substring(0,text.indexOf("=")))){
						tempWordEND = text;
					}
					else if(endsWithLY && word.length() > 2 && word.substring(0, word.length()-2).equalsIgnoreCase(text.substring(0,text.indexOf("=")))){
						tempWordEND = text;
					}
					else if(endsWithER && word.length() > 2 && word.substring(0, word.length()-2).equalsIgnoreCase(text.substring(0,text.indexOf("=")))){
						tempWordEND = text;
					}
					else if(endsWithER && word.length() > 2 && word.substring(0, word.length()-2).equalsIgnoreCase(text.substring(0,text.indexOf("=")-1))){
						// t.ex. blue -> bluer
						tempWordEND = text;
					}
					else if(endsWithEST && word.length() > 3 && word.substring(0, word.length()-3).equalsIgnoreCase(text.substring(0,text.indexOf("=")))){
						tempWordEND = text;
					}
					else if(endsWithEST && word.length() > 3 && word.substring(0, word.length()-3).equalsIgnoreCase(text.substring(0,text.indexOf("=")-1))){
						// t.ex. blue -> bluest
						tempWordEND = text;
					}
					else if(endsWithABILITY && word.length() > 7 && word.substring(0, word.length()-7).equalsIgnoreCase(text.substring(0,text.indexOf("=")))){
						tempWordEND = text;
					}
					else if(endsWithLESS && word.length() > 4 && word.substring(0, word.length()-4).equalsIgnoreCase(text.substring(0,text.indexOf("=")))){
						tempWordEND = text;
					}
					else if(endsWithISH && word.length() > 3 && word.substring(0, word.length()-3).equalsIgnoreCase(text.substring(0,text.indexOf("=")))){
						tempWordEND = text;
					}
					else if(endsWithISH && word.length() > 3 && word.substring(0, word.length()-3).equalsIgnoreCase(text.substring(0,text.indexOf("=")-1))){
						// t.ex. blue -> bluish
						tempWordEND = text;
					}
					
					// starts with
					if(startsWithMIS && word.length() > 3 && word.substring(3).equalsIgnoreCase(text.substring(0,text.indexOf("=")))){
						tempWordSTART = text;
					}
					else if(startsWithDEMI && word.length() > 4 && word.substring(4).equalsIgnoreCase(text.substring(0,text.indexOf("=")))){
						tempWordSTART = text;
					}
					else if(startsWithDIS && word.length() > 3 && word.substring(3).equalsIgnoreCase(text.substring(0,text.indexOf("=")))){
						tempWordSTART = text;
					}
					else if(startsWithDE && word.length() > 2 && word.substring(2).equalsIgnoreCase(text.substring(0,text.indexOf("=")))){
						tempWordSTART = text;
					}
					else if(startsWithPRE && word.length() > 3 && word.substring(3).equalsIgnoreCase(text.substring(0,text.indexOf("=")))){
						tempWordSTART = text;
					}
					else if(startsWithPRO && word.length() > 3 && word.substring(3).equalsIgnoreCase(text.substring(0,text.indexOf("=")))){
						tempWordSTART = text;
					}
					else if(startsWithANTI && word.length() > 4 && word.substring(4).equalsIgnoreCase(text.substring(0,text.indexOf("=")))){
						tempWordSTART = text;
					}
					else if(startsWithNON && word.length() > 3 && word.substring(3).equalsIgnoreCase(text.substring(0,text.indexOf("=")))){
						tempWordSTART = text;
					}
					else if(startsWithRE && word.length() > 2 && word.substring(2).equalsIgnoreCase(text.substring(0,text.indexOf("=")))){
						tempWordSTART = text;
					}
				}
				
				
				
				
				if(!exists && tempWordEND != null){
					// använd temprWordEND om det finns
					wordType = "";
					if(checkPlural){ // found a plural form, could also be singular form if it's a verb.
						wordType = tempWordEND.substring(tempWordEND.indexOf("=")+1);
						if(wordType.indexOf('N') != -1){
							// Noun
							if(wordType.indexOf('p') == -1){
								wordType = wordType + "p";
							}
						}
						if(wordType.indexOf('V') != -1 || wordType.indexOf('t') != -1 || wordType.indexOf('i') != -1){
							// Verb
							if(wordType.indexOf('s') == -1){
								wordType = wordType + "s";
							}
						}
					}
					else if(endsWithED){
						// if it is a verb it is a past-tense verb
						wordType = tempWordEND.substring(tempWordEND.indexOf("=")+1);
						if((wordType.indexOf('V') != -1 || wordType.indexOf('t') != -1 || wordType.indexOf('i') != -1)
								&& wordType.indexOf('T') == -1){
							wordType = wordType + "T";
						}
						if((pos = wordType.indexOf('N')) != -1){
							// remove N
							if(pos == wordType.length()-1){
								// last element
								wordType = wordType.substring(0, pos);
							}
							else{
								// first or somewhere in the middle
								wordType = wordType.substring(0, pos) + wordType.substring(pos+1);
							}
							// add A (positive adjective)
							wordType = wordType + "A";
						}
					}
					else if(endsWithING){
						wordType = "G";
					}
					else if(endsWithABLE){
						wordType = "A";
					}
					else if(endsWithNESS){
						wordType = "N";
					}
					else if(endsWithLY){
						wordType = "v";
					}
					else if(endsWithER){
						wordType = "c";
					}
					else if(endsWithEST){ 
						wordType = "S";
					}
					else if(endsWithABILITY){
						wordType = "N";
					}
					else if(endsWithLESS){
						wordType = "A";
					}
					else if(endsWithISH){ 
						wordType = "A";
					}
					else{
						// This should NEVER happen
						wordsThatDoesNotExist.add(word);
						System.out.println(wordsThatDoesNotExist.size() + ": Word was not added: " + wordsThatDoesNotExist.get(wordsThatDoesNotExist.size()-1));
						continue;
					}
					words.add(new PartOfSpeechWord(word, wordType));
					System.out.println(words.size() + ": Word added: " + words.get(words.size()-1).toString());
				}
				else if(!exists && tempWordSTART != null // adding a start to the word doesn't change the wordtype
						&& (startsWithMIS || startsWithDEMI || startsWithDIS || startsWithDE || startsWithPRE
								|| startsWithPRO || startsWithANTI || startsWithNON || startsWithRE)){
					wordType = tempWordSTART.substring(tempWordSTART.indexOf("=")+1);
					words.add(new PartOfSpeechWord(word, wordType));
					System.out.println(words.size() + ": Word added: " + words.get(words.size()-1).toString());
				}
				else if(exists){
					// kanske vill ändra på ordets ordtyp
					wordType = text.substring(text.indexOf('=')+1);
					if(endsWithING){
						// gerund form = G
						// ta bort V (stort V)
						if((pos = wordType.indexOf('V')) != -1){ // V finns
							if(pos == wordType.length()-1){
								// sista elementet
								wordType = wordType.substring(0, pos);
							}
							else{
								// nån stans i mitten eller först
								wordType = wordType.substring(0, pos) + wordType.substring(pos+1);
							}
						}
						// Lägg till G
						if(wordType.indexOf('G') == -1){
							wordType = wordType + "G";
						}
					}
					else if(checkPlural){ // found a plural form of a noun or a singular form of a verb.
						if(wordType.indexOf('V') != -1 && wordType.indexOf('t') != -1 && wordType.indexOf('i') != -1){
							// it's a verb 
							// t.ex. abbreviate -> abbreviates or run -> runs
							if(wordType.indexOf('s') == -1){
								wordType = wordType + "s";
							}
						}
					}
					else if(endsWithER){
						// Comparative Adjective = c
						// remove A
						if((pos = wordType.indexOf('A')) != -1){ // A exists
							if(pos == wordType.length()-1){
								// last element
								wordType = wordType.substring(0, pos);
							}
							else{
								// first or somewhere in the middle
								wordType = wordType.substring(0, pos) + wordType.substring(pos+1);
							}
						}
						// add c
						if(wordType.indexOf('c') == -1){
							wordType = wordType + "c";
						}
					}
					else if(endsWithEST){
						// Superlative Adjective = S
						// remove A
						if((pos = wordType.indexOf('A')) != -1){ // A exists
							if(pos == wordType.length()-1){
								// last element
								wordType = wordType.substring(0, pos);
							}
							else{
								// first or somewhere in the middle
								wordType = wordType.substring(0, pos) + wordType.substring(pos+1);
							}
						}
						// add S
						if(wordType.indexOf('S') == -1){
							wordType = wordType + "S";
						}
					}
					else if(endsWithED){
						// if it is a verb it is a past-tense verb
						if((wordType.indexOf('V') != -1 || wordType.indexOf('t') != -1 || wordType.indexOf('i') == -1)
								&& wordType.indexOf('T') == -1){
							wordType = wordType + "T";
						}
					}
					words.add(new PartOfSpeechWord(word, wordType));
					System.out.println(words.size() + ": Word added: " + words.get(words.size()-1).toString());
				}
				else{
					// hittade inte ordet
					wordsThatDoesNotExist.add(word);
					System.out.println(wordsThatDoesNotExist.size() + ": Word was not added: " + wordsThatDoesNotExist.get(wordsThatDoesNotExist.size()-1));
				}
			}
			System.out.println("Words size: " + words.size());
			System.out.println("Words not found " + wordsThatDoesNotExist.size());
			for(int i = 0; i < words.size(); i++){
				writerPartOfSpeech.write(words.get(i).toString());
				writerPartOfSpeech.newLine();
			}
			
			for(int i = 0; i < wordsThatDoesNotExist.size(); i++){
				writerWordsLeft.write(wordsThatDoesNotExist.get(i));
				writerWordsLeft.newLine();
			}
			
			writerPartOfSpeech.close();
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
