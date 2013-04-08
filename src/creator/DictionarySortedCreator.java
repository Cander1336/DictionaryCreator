package creator;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Creates a dictionary sorted by part-of-speech type by using the dictionary sorted by alfabetical order
 * @author Fredrik
 *
 */
public class DictionarySortedCreator {
	
	public static void main(String[] args){
		try {
			double startTime = System.currentTimeMillis();
			
			File dictionaryAlfabetical = new File("dictionary-alfabetical.txt");
			File dictionaryWordType = new File("dictionary-wordtype.txt");
			
			ArrayList<Word> words = new ArrayList<Word>();
			
			String word;
			String syllables;
			String wordType;
		
			BufferedReader readerDictionary = new BufferedReader(new FileReader(dictionaryAlfabetical));
			BufferedWriter writerDictionary = new BufferedWriter(new FileWriter(dictionaryWordType));
			
			String text;
			
//			readerDictionary.readLine(); // skip the first line, should not be used if the text file doesn't have a special first row
			while ((text = readerDictionary.readLine()) != null) {
				word = text.substring(0, text.indexOf('|'));
				text = text.substring(text.indexOf('|')+1);
				syllables = text.substring(0, text.indexOf('|'));
				wordType = text.substring(text.lastIndexOf('|')+1);
				words.add(new Word(word, syllables, wordType));
			}
			// write
			writerDictionary.write("The types(search for these):");
			writerDictionary.newLine();
			writerDictionary.write("Noun = N");
			writerDictionary.newLine();
			writerDictionary.write("Plural Noun = p");
			writerDictionary.newLine();
			writerDictionary.write("Noun Phrase = h");
			writerDictionary.newLine();
			writerDictionary.write("Verb (usu participle) = V");
			writerDictionary.newLine();
			writerDictionary.write("Gerund = G");
			writerDictionary.newLine();
			writerDictionary.write("Transitive Verb = t");
			writerDictionary.newLine();
			writerDictionary.write("Intransitive Verb = i");
			writerDictionary.newLine();
			writerDictionary.write("Singular Verb = s");
			writerDictionary.newLine();
			writerDictionary.write("Past-tense = T");
			writerDictionary.newLine();
			writerDictionary.write("Positive Adjective = A");
			writerDictionary.newLine();
			writerDictionary.write("Comparative Adjective = c");
			writerDictionary.newLine();
			writerDictionary.write("Superlative Adjective = S");
			writerDictionary.newLine();
			writerDictionary.write("Adverb = v");
			writerDictionary.newLine();
			writerDictionary.write("Conjunction = C");
			writerDictionary.newLine();
			writerDictionary.write("Preposition = P");
			writerDictionary.newLine();
			writerDictionary.write("Interjection = !");
			writerDictionary.newLine();
			writerDictionary.write("Pronoun = r");
			writerDictionary.newLine();
			writerDictionary.write("Definite Article = D");
			writerDictionary.newLine();
			writerDictionary.write("Indefinite Article = I");
			writerDictionary.newLine();
			writerDictionary.write("Nominative = o");
			
			writerDictionary.newLine();
			writerDictionary.write("--------------------------------------------------------------------");
			writerDictionary.newLine();
			writerDictionary.newLine();
			// N	Noun
			writerDictionary.write("Noun = N");
			writerDictionary.newLine();
			writerDictionary.newLine();
			for(int i = 0; i < words.size(); i++){
				if(words.get(i).getWordType().contains("N")){
					writerDictionary.write(words.get(i).toString());
					writerDictionary.newLine();
				}
			}
			writerDictionary.newLine();
			writerDictionary.write("--------------------------------------------------------------------");
			writerDictionary.newLine();
			writerDictionary.newLine();
			// P	Plural
			writerDictionary.write("Plural Noun = P");
			writerDictionary.newLine();
			writerDictionary.newLine();
			for(int i = 0; i < words.size(); i++){
				if(words.get(i).getWordType().contains("p")){
					writerDictionary.write(words.get(i).toString());
					writerDictionary.newLine();
				}
			}
			writerDictionary.newLine();
			writerDictionary.write("--------------------------------------------------------------------");
			writerDictionary.newLine();
			writerDictionary.newLine();
			// h	Noun Phrase
			writerDictionary.write("Noun Phrase = h");
			writerDictionary.newLine();
			writerDictionary.newLine();
			for(int i = 0; i < words.size(); i++){
				if(words.get(i).getWordType().contains("h")){
					writerDictionary.write(words.get(i).toString());
					writerDictionary.newLine();
				}
			}
			writerDictionary.newLine();
			writerDictionary.write("--------------------------------------------------------------------");
			writerDictionary.newLine();
			writerDictionary.newLine();
			// V	Verb (usu participle)
			writerDictionary.write("Verb (usu participle) = V");
			writerDictionary.newLine();
			writerDictionary.newLine();
			for(int i = 0; i < words.size(); i++){
				if(words.get(i).getWordType().contains("V")){
					writerDictionary.write(words.get(i).toString());
					writerDictionary.newLine();
				}
			}
			writerDictionary.newLine();
			writerDictionary.write("--------------------------------------------------------------------");
			writerDictionary.newLine();
			writerDictionary.newLine();
			// G	Gerund
			writerDictionary.write("Gerund = G");
			writerDictionary.newLine();
			writerDictionary.newLine();
			for(int i = 0; i < words.size(); i++){
				if(words.get(i).getWordType().contains("G")){
					writerDictionary.write(words.get(i).toString());
					writerDictionary.newLine();
				}
			}
			writerDictionary.newLine();
			writerDictionary.write("--------------------------------------------------------------------");
			writerDictionary.newLine();
			writerDictionary.newLine();
			// t	Verb (transitive)
			writerDictionary.write("Transitive Verb = t");
			writerDictionary.newLine();
			writerDictionary.newLine();
			for(int i = 0; i < words.size(); i++){
				if(words.get(i).getWordType().contains("t")){
					writerDictionary.write(words.get(i).toString());
					writerDictionary.newLine();
				}
			}
			writerDictionary.newLine();
			writerDictionary.write("--------------------------------------------------------------------");
			writerDictionary.newLine();
			writerDictionary.newLine();
			// i	Verb (intransitive)
			writerDictionary.write("Intransitive Verb = i");
			writerDictionary.newLine();
			writerDictionary.newLine();
			for(int i = 0; i < words.size(); i++){
				if(words.get(i).getWordType().contains("i")){
					writerDictionary.write(words.get(i).toString());
					writerDictionary.newLine();
				}
			}
			writerDictionary.newLine();
			writerDictionary.write("--------------------------------------------------------------------");
			writerDictionary.newLine();
			writerDictionary.newLine();
			// Singular Verb = s
			writerDictionary.write("Singular Verb = s");
			writerDictionary.newLine();
			writerDictionary.newLine();
			for(int i = 0; i < words.size(); i++){
				if(words.get(i).getWordType().contains("s")){
					writerDictionary.write(words.get(i).toString());
					writerDictionary.newLine();
				}
			}
			writerDictionary.newLine();
			writerDictionary.write("--------------------------------------------------------------------");
			writerDictionary.newLine();
			writerDictionary.newLine();
			// T	Past-tense
			writerDictionary.write("Past-tense = T");
			writerDictionary.newLine();
			writerDictionary.newLine();
			for(int i = 0; i < words.size(); i++){
				if(words.get(i).getWordType().contains("T")){
					writerDictionary.write(words.get(i).toString());
					writerDictionary.newLine();
				}
			}
			writerDictionary.newLine();
			writerDictionary.write("--------------------------------------------------------------------");
			writerDictionary.newLine();
			writerDictionary.newLine();
			// A	Positive Adjective
			writerDictionary.write("Positive Adjective = A");
			writerDictionary.newLine();
			writerDictionary.newLine();
			for(int i = 0; i < words.size(); i++){
				if(words.get(i).getWordType().contains("A")){
					writerDictionary.write(words.get(i).toString());
					writerDictionary.newLine();
				}
			}
			writerDictionary.newLine();
			writerDictionary.write("--------------------------------------------------------------------");
			writerDictionary.newLine();
			writerDictionary.newLine();
			// c	Comparative Adjective
			writerDictionary.write("Comparative Adjective = c");
			writerDictionary.newLine();
			writerDictionary.newLine();
			for(int i = 0; i < words.size(); i++){
				if(words.get(i).getWordType().contains("c")){
					writerDictionary.write(words.get(i).toString());
					writerDictionary.newLine();
				}
			}
			writerDictionary.newLine();
			writerDictionary.write("--------------------------------------------------------------------");
			writerDictionary.newLine();
			writerDictionary.newLine();
			// S	Superlative Adjective
			writerDictionary.write("Superlative Adjective = S");
			writerDictionary.newLine();
			writerDictionary.newLine();
			for(int i = 0; i < words.size(); i++){
				if(words.get(i).getWordType().contains("S")){
					writerDictionary.write(words.get(i).toString());
					writerDictionary.newLine();
				}
			}
			writerDictionary.newLine();
			writerDictionary.write("--------------------------------------------------------------------");
			writerDictionary.newLine();
			writerDictionary.newLine();
			// v	Adverb
			writerDictionary.write("Adverb = v");
			writerDictionary.newLine();
			writerDictionary.newLine();
			for(int i = 0; i < words.size(); i++){
				if(words.get(i).getWordType().contains("v")){
					writerDictionary.write(words.get(i).toString());
					writerDictionary.newLine();
				}
			}
			writerDictionary.newLine();
			writerDictionary.write("--------------------------------------------------------------------");
			writerDictionary.newLine();
			writerDictionary.newLine();
			// C	Conjunction
			writerDictionary.write("Conjunction = C");
			writerDictionary.newLine();
			writerDictionary.newLine();
			for(int i = 0; i < words.size(); i++){
				if(words.get(i).getWordType().contains("C")){
					writerDictionary.write(words.get(i).toString());
					writerDictionary.newLine();
				}
			}
			writerDictionary.newLine();
			writerDictionary.write("--------------------------------------------------------------------");
			writerDictionary.newLine();
			writerDictionary.newLine();
			// P	Preposition
			writerDictionary.write("Preposition = P");
			writerDictionary.newLine();
			writerDictionary.newLine();
			for(int i = 0; i < words.size(); i++){
				if(words.get(i).getWordType().contains("P")){
					writerDictionary.write(words.get(i).toString());
					writerDictionary.newLine();
				}
			}
			writerDictionary.newLine();
			writerDictionary.write("--------------------------------------------------------------------");
			writerDictionary.newLine();
			writerDictionary.newLine();
			// !	Interjection
			writerDictionary.write("Interjection = !");
			writerDictionary.newLine();
			writerDictionary.newLine();
			for(int i = 0; i < words.size(); i++){
				if(words.get(i).getWordType().contains("!")){
					writerDictionary.write(words.get(i).toString());
					writerDictionary.newLine();
				}
			}
			writerDictionary.newLine();
			writerDictionary.write("--------------------------------------------------------------------");
			writerDictionary.newLine();
			writerDictionary.newLine();
			// r	Pronoun
			writerDictionary.write("Pronoun = r");
			writerDictionary.newLine();
			writerDictionary.newLine();
			for(int i = 0; i < words.size(); i++){
				if(words.get(i).getWordType().contains("r")){
					writerDictionary.write(words.get(i).toString());
					writerDictionary.newLine();
				}
			}
			writerDictionary.newLine();
			writerDictionary.write("--------------------------------------------------------------------");
			writerDictionary.newLine();
			writerDictionary.newLine();
			// D	Definite Article
			writerDictionary.write("Definite Article = D");
			writerDictionary.newLine();
			writerDictionary.newLine();
			for(int i = 0; i < words.size(); i++){
				if(words.get(i).getWordType().contains("D")){
					writerDictionary.write(words.get(i).toString());
					writerDictionary.newLine();
				}
			}
			writerDictionary.newLine();
			writerDictionary.write("--------------------------------------------------------------------");
			writerDictionary.newLine();
			writerDictionary.newLine();
			// I	Indefinite Article
			writerDictionary.write("Indefinite Article = I");
			writerDictionary.newLine();
			writerDictionary.newLine();
			for(int i = 0; i < words.size(); i++){
				if(words.get(i).getWordType().contains("I")){
					writerDictionary.write(words.get(i).toString());
					writerDictionary.newLine();
				}
			}
			writerDictionary.newLine();
			writerDictionary.write("--------------------------------------------------------------------");
			writerDictionary.newLine();
			writerDictionary.newLine();
			// o	Nominative
			writerDictionary.write("Nominative = o");
			writerDictionary.newLine();
			writerDictionary.newLine();
			for(int i = 0; i < words.size(); i++){
				if(words.get(i).getWordType().contains("o")){
					writerDictionary.write(words.get(i).toString());
					writerDictionary.newLine();
				}
			}
			writerDictionary.close();
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
