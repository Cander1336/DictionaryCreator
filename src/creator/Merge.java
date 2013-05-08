package creator;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.IOException;

//merge two wordlists, overwrite duplicates (in orignal from addition)
public class Merge {
	public static void main(String[] args) throws IOException {
		double startTime = System.currentTimeMillis();	

		//choose input/output files
		final String outputWordFile = "dictionary-full.txt";
		
		//merge auto generated wordlist with manual added words
//		final String orignalWordFile = "dictionary-generated.txt";
//		final String additionWordFile = "dictionary-additions.txt";	
		
		//merge wordlist with the theme "silly"
//		final String orignalWordFile = "dictionary-full.txt";
//		final String additionWordFile = "theme_silly_manual.txt";
		
		//merge wordlist with the theme "body"
		//final String orignalWordFile = "dictionary-full.txt";
		//final String additionWordFile = "theme_body_manual.txt";
		
		//merge wordlist with the theme "time"
		//final String orignalWordFile = "dictionary-full.txt";
		//final String additionWordFile = "theme_time_manual.txt";
		
		//merge wordlist with the theme "stockholm"
		//final String orignalWordFile = "dictionary-full.txt";
		//final String additionWordFile = "theme_stockholm_manual.txt";
		
		//merge wordlist with the theme "art"
		//final String orignalWordFile = "dictionary-full.txt";
		//final String additionWordFile = "theme_art_manual.txt";
		
		//merge wordlist with the theme "emotion"
		//final String orignalWordFile = "dictionary-full.txt";
		//final String additionWordFile = "theme_emotion_manual.txt";
		
		//merge wordlist with the theme "all"
		final String orignalWordFile = "dictionary-full.txt";
		final String additionWordFile = "theme_all_manual.txt";
		
		Scanner readerOrginal = new Scanner(new File(orignalWordFile));
		ArrayList<String> orginal = new ArrayList<String>();
		while (readerOrginal.hasNextLine())
			orginal.add(readerOrginal.nextLine());
		readerOrginal.close();
		
		BufferedWriter writer = new BufferedWriter(new FileWriter(new File(outputWordFile)));
		Scanner readerAdditions = new Scanner(new File(additionWordFile));
		ArrayList<String> additions = new ArrayList<String>();
		String nextLine;
		while (readerAdditions.hasNextLine())
		{
			nextLine = readerAdditions.nextLine();
			additions.add(nextLine);
			writer.write(nextLine);
			writer.newLine();
		}
		readerAdditions.close();
		
		dicgenloop:
		for (String orginalLine : orginal) {
			for (String additionsLine : additions)
				if (orginalLine.substring(0, orginalLine.indexOf("|")).equalsIgnoreCase(additionsLine.substring(0, additionsLine.indexOf("|"))))
					continue dicgenloop;
			writer.write(orginalLine);
			writer.newLine();
		}
		writer.close();
		System.out.println("execution time: " + ((System.currentTimeMillis() - startTime) / 1000) + " seconds");
	}
}