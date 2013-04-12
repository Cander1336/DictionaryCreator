package creator.sql;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;
import java.io.IOException;

//creates .txt files with SQL INSERT commands from a word list in a .txt file
public class SqlCreator {
	public static void main(String[] args) throws IOException {  
		double startTime = System.currentTimeMillis();	
		
		//create SQL INSERT's for table Word from wordlist dictionary-wordtype.txt
		Scanner reader = new Scanner(new File("dictionary-alfabetical.txt"));
		BufferedWriter writer = new BufferedWriter(new FileWriter(new File("haiku_db_sql_word_dictionary_alfabetical.txt")));
		
		String line;
		String text;
		String syllables;
		for (int i = 1; reader.hasNextLine(); i++) {
			line = reader.nextLine();
			text = line.substring(0, line.indexOf("|"));
			syllables = line.substring(line.indexOf("|")+1, line.lastIndexOf("|"));
			syllables = syllables.replace('·', '*');
			
			//CREATE TABLE Word(_id INTEGER PRIMARY KEY, text TEXT, syllables TEXT);
			writer.write("INSERT INTO Word VALUES(" + i + ",'" + text + "','" + syllables + "');");
			writer.newLine();
		}
		
		reader.close();
		writer.close();
		System.out.println("SqlCreator execution time: " + ((System.currentTimeMillis() - startTime) / 1000) + " seconds");
	}

}
