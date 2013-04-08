package creator.update;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import creator.Word;


public class UpdatePartOfSpeech {
	
	public static void main(String[] args){
		try {
			double startTime = System.currentTimeMillis();
			
			File partOfSpeech1 = new File("part-of-speech.txt");
			File partOfSpeech2 = new File("partofspeech.txt");
			
			ArrayList<PartOfSpeechWord> words = new ArrayList<PartOfSpeechWord>();
			
			String word;
			String wordType;
		
			BufferedReader readerPartOfSpeech = new BufferedReader(new FileReader(partOfSpeech1));
			BufferedWriter writerPartOfSpeech = new BufferedWriter(new FileWriter(partOfSpeech2));
			
			String textPartOfSpeech = null;
			boolean exists;
			
			while ((textPartOfSpeech = readerPartOfSpeech.readLine()) != null) {
				exists = false;
				word = textPartOfSpeech.substring(0,textPartOfSpeech.indexOf("\t"));
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
				if(word.contains(" ") || word.contains("-")){ // more than one word
					System.out.println("Word not added: " + word);
					continue;
				}
				wordType = textPartOfSpeech.substring(textPartOfSpeech.indexOf('\t')+1);
				if(textPartOfSpeech.contains("|")){
					wordType = textPartOfSpeech.substring(textPartOfSpeech.indexOf('|')+1);
				}
				words.add(new PartOfSpeechWord(word, wordType));
				System.out.println(words.size() + ": Word added: " + words.get(words.size()-1).toString());
			}
			
			for(int i = 0; i < words.size(); i++){
				writerPartOfSpeech.write(words.get(i).toString());
				writerPartOfSpeech.newLine();
			}
			writerPartOfSpeech.close();
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
