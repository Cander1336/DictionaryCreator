package creator;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Creator {
	
	public static void main(String[] args){
		try {
			double startTime = System.currentTimeMillis();
			
			File syllablesFile = new File("syllables4.txt");
			File partOfSpeech = new File("partofspeech3.txt");
			File dictionaryAlfabetical = new File("dictionary-full.txt");
			
			ArrayList<Word> words = new ArrayList<Word>();
			
			String word;
			String syllables;
			String wordType = null;
		
			BufferedReader readerSyllables = new BufferedReader(new FileReader(syllablesFile));
			BufferedReader readerPartOfSpeech;
			BufferedWriter writerDictionary = new BufferedWriter(new FileWriter(dictionaryAlfabetical));
			
			String textSyllables = null;
			String textPartOfSpeech = null;
			boolean exists;
			
			while ((textSyllables = readerSyllables.readLine()) != null) {
				exists = false;
				word = textSyllables.substring(0,textSyllables.indexOf("="));
				// om ordet redan finns i words listan så ska det inte läggas in igen (kan finnas dubletter i text filen)
				for(int i = 0; i < words.size(); i++){
					if(words.get(i).getWord().equals(word)){
						exists = true;
						break;
					}
				}
				if(exists){
					continue;
				}
				// Hitta ordet i andra ordlistan
				readerPartOfSpeech = new BufferedReader(new FileReader(partOfSpeech));
				while ((textPartOfSpeech = readerPartOfSpeech.readLine()) != null) {
					if(word.equals(textPartOfSpeech.substring(0, textPartOfSpeech.indexOf('=')))){
						exists = true;
						textPartOfSpeech = textPartOfSpeech.substring(textPartOfSpeech.indexOf('=')+1);
						wordType = textPartOfSpeech;
						break;
					}
				}
				readerPartOfSpeech.close();
				if(!exists){
					continue;
				}
				// Ordet finns i båda ordlistorna
				syllables = textSyllables.substring(textSyllables.indexOf("=")+1);
				words.add(new Word(word, syllables, wordType));
				System.out.println( words.size() + ": " + "Word added: " + words.get(words.size()-1).toString());
			}
			// Alla ord är lästa
			// Skapa en "innehållsförtecking"
			System.out.println("Write");
//			int numberOfRows = 1; // första indexet är 1
//			char firstLetter = '0';
//			String firstRow = "";
//			for(int i = 0; i < words.size(); i++){
//				numberOfRows++; // först eftersom den måste räkna med den första raden också
//				if(words.get(i).getWord().charAt(0) != firstLetter){
//					// new first letter
//					firstLetter = words.get(i).getWord().charAt(0);
//					firstRow = firstRow + firstLetter + "=" + numberOfRows + "|";
//				}
//			}
//			writerDictionary.write(firstRow);
//			writerDictionary.newLine();
			// Lägg in alla ord
			for(int i = 0; i < words.size(); i++){
				writerDictionary.write(words.get(i).toString());
				writerDictionary.newLine();
			}
			writerDictionary.close();
			System.out.println("Done! " + words.size() + " words");
			double execTime = System.currentTimeMillis()-startTime;
			int seconds = (int)execTime/1000;
			int minutes = seconds/60;
			seconds = seconds%60;
			int hours = minutes/60;
			minutes = minutes%60;
			System.out.println("Time (HH:MM:SS): " + hours + ":" + minutes + ":" + seconds);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
