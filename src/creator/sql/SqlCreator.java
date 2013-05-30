package creator.sql;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.IOException;

//creates .txt files with SQL INSERT commands from a word list in a .txt file
public class SqlCreator {
	public static void main(String[] args) throws IOException {  
		double startTime = System.currentTimeMillis();	
		
/*		//create SQL INSERT's for table word
		Scanner reader = new Scanner(new File("dictionary-full.txt"));
		BufferedWriter writer = new BufferedWriter(new FileWriter(new File("deletebyhaiku_db_sql_word_dictionary_full.txt")));
		
		String line;
		String text;
		String syllables;
		for (int i = 1; reader.hasNextLine(); i++) {
			line = reader.nextLine();
			text = line.substring(0, line.indexOf("|"));
			syllables = line.substring(line.indexOf("|")+1, line.lastIndexOf("|"));
			
			//CREATE TABLE Word(_id INTEGER PRIMARY KEY, text TEXT, syllables TEXT);
			writer.write("INSERT INTO word VALUES(" + i + ", '" + text + "', '" + syllables + "');");
			writer.newLine();
		}
*/
		
/*		
		//create SQL INSERT's for table theme_word
		Scanner reader = new Scanner(new File("dictionary-full.txt"));
		Scanner allReader = new Scanner(new File("theme_all_manual.txt"));
		Scanner artReader = new Scanner(new File("theme_art_manual.txt"));
		Scanner bodyReader = new Scanner(new File("theme_body_manual.txt"));
		Scanner emotionReader = new Scanner(new File("theme_emotion_manual.txt"));
		Scanner sillyReader = new Scanner(new File("theme_silly_manual.txt"));
		Scanner stockholmReader = new Scanner(new File("theme_stockholm_manual.txt"));
		Scanner timeReader = new Scanner(new File("theme_time_manual.txt"));
		
		BufferedWriter writer = new BufferedWriter(new FileWriter(new File("deletebyhaiku_db_sql_theme_word_dictionary_full.txt")));
		
		final int allid = 1;
		final int artid = 2;
		final int bodyid = 3;
		final int emotionid = 4;
		final int sillyid = 5;
		final int stockholmid = 6;
		final int timeid = 7;
		
		ArrayList<String> all = new ArrayList<String>();
		ArrayList<String> art = new ArrayList<String>();
		ArrayList<String> body = new ArrayList<String>();
		ArrayList<String> emotion = new ArrayList<String>();
		ArrayList<String> silly = new ArrayList<String>();
		ArrayList<String> stockholm = new ArrayList<String>();
		ArrayList<String> time = new ArrayList<String>();
		
		String line;
		String text;

		while (allReader.hasNextLine())
		{
			line = allReader.nextLine();
			all.add(line.substring(0, line.indexOf("|")));
		}
		while (artReader.hasNextLine())
		{
			line = artReader.nextLine();
			art.add(line.substring(0, line.indexOf("|")));
		}
		while (bodyReader.hasNextLine())
		{
			line = bodyReader.nextLine();
			body.add(line.substring(0, line.indexOf("|")));
		}
		while (emotionReader.hasNextLine())
		{
			line = emotionReader.nextLine();
			emotion.add(line.substring(0, line.indexOf("|")));
		}
		while (sillyReader.hasNextLine())
		{
			line = sillyReader.nextLine();
			silly.add(line.substring(0, line.indexOf("|")));
		}
		while (stockholmReader.hasNextLine())
		{
			line = stockholmReader.nextLine();
			stockholm.add(line.substring(0, line.indexOf("|")));
		}
		while (timeReader.hasNextLine())
		{
			line = timeReader.nextLine();
			time.add(line.substring(0, line.indexOf("|")));
		}
		
		allReader.close();
		artReader.close();
		bodyReader.close();
		emotionReader.close();
		sillyReader.close();
		stockholmReader.close();
		timeReader.close();
		
		int theme_word_id = 1;
		for (int wordid = 1; reader.hasNextLine(); wordid++) {
			line = reader.nextLine();
			text = line.substring(0, line.indexOf("|"));
			
			//CREATE TABLE theme_word(_id INTEGER PRIMARY KEY, themeid INTEGER, wordid INTEGER, FOREIGN KEY(themeid) REFERENCES theme(_id), FOREIGN KEY(wordid) REFERENCES word(_id));
			//INSERT INTO theme_word VALUES (1, 1, 4234);
			//INSERT INTO theme_word VALUES (2, 1, 7654);
			
			for (String text2 : all) //loop through theme wordlists to see if word (text) exist there
				if (text.equals(text2)) {
					writer.write("INSERT INTO theme_word VALUES(" + theme_word_id++ + ", " + allid + ", " + wordid + ");");
					writer.newLine();
					break;
				}

			for (String text2 : art)
				if (text.equals(text2)) {
					writer.write("INSERT INTO theme_word VALUES(" + theme_word_id++ + ", " + artid + ", " + wordid + ");");
					writer.newLine();
					break;
				}

			for (String text2 : body)
				if (text.equals(text2)) {
					writer.write("INSERT INTO theme_word VALUES(" + theme_word_id++ + ", " + bodyid + ", " + wordid + ");");
					writer.newLine();
					break;
				}

			for (String text2 : emotion)
				if (text.equals(text2)) {
					writer.write("INSERT INTO theme_word VALUES(" + theme_word_id++ + ", " + emotionid + ", " + wordid + ");");
					writer.newLine();
					break;
				}

			for (String text2 : silly)
				if (text.equals(text2)) {
					writer.write("INSERT INTO theme_word VALUES(" + theme_word_id++ + ", " + sillyid + ", " + wordid + ");");
					writer.newLine();
					break;
				}

			for (String text2 : stockholm)
				if (text.equals(text2)) {
					writer.write("INSERT INTO theme_word VALUES(" + theme_word_id++ + ", " + stockholmid + ", " + wordid + ");");
					writer.newLine();
					break;
				}

			for (String text2 : time)
				if (text.equals(text2)) {
					writer.write("INSERT INTO theme_word VALUES(" + theme_word_id++ + ", " + timeid + ", " + wordid + ");");
					writer.newLine();
					break;
				}
		
		}
*/
		//create SQL INSERT's for table word_partofspeech
		Scanner reader = new Scanner(new File("dictionary-full.txt"));
		BufferedWriter writer = new BufferedWriter(new FileWriter(new File("deletebyhaiku_db_sql_word_partofspeech_dictionary_full.txt")));

		ArrayList<String> partofspeechs = new ArrayList<String>();
		partofspeechs.add("noun");
		partofspeechs.add("plural noun");
		partofspeechs.add("noun phrase");
		partofspeechs.add("verb (usu participle)");
		partofspeechs.add("gerund");
		partofspeechs.add("transitive verb");
		partofspeechs.add("intransitive verb");
		partofspeechs.add("singular verb");
		partofspeechs.add("past tense");
		partofspeechs.add("positive adjective");
		partofspeechs.add("comparative adjective");
		partofspeechs.add("superlative adjective");
		partofspeechs.add("adverb");
		partofspeechs.add("conjunction");
		partofspeechs.add("preposition");
		partofspeechs.add("interjection");
		partofspeechs.add("pronoun");
		partofspeechs.add("definite article");
		partofspeechs.add("indefinite article");
		partofspeechs.add("nominative");
		partofspeechs.add("pronoun + verb (usu participle)");

		int word_partofspeech_id = 1;
		String line;
		for (int wordid = 1; reader.hasNextLine(); wordid++) {
			line = reader.nextLine();
			String[] text = line.substring(line.lastIndexOf("|")+1).split("\\.");
			
			//CREATE TABLE word_partofspeech(_id INTEGER PRIMARY KEY, wordid INTEGER, partofspeechid INTEGER, FOREIGN KEY(wordid) REFERENCES word(_id), FOREIGN KEY(partofspeechid) REFERENCES partofspeech(_id));
			//INSERT INTO word_partofspeech(1, 233, 12)				
			
			for (String pos : text) {	
					writer.write("INSERT INTO word_partofspeech VALUES(" + word_partofspeech_id++ + ", " + wordid + ", " + (partofspeechs.indexOf(pos)+1) + ");");
					writer.newLine();
			}
		}
		
		reader.close();
		writer.close();
		System.out.println("SqlCreator execution time: " + ((System.currentTimeMillis() - startTime) / 1000) + " seconds");
	}

}
