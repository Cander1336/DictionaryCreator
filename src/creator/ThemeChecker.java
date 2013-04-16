package creator;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.IOException;

//look up words from a theme wordlist in the dictionary, if there exist there copy that line (to a new output .txt file) 
//with the syllable/part of speech information
//otherwise write out the unfound word
public class ThemeChecker {
	public static void main(String[] args) throws IOException {
		double startTime = System.currentTimeMillis();	
		
		final String dictionary = "dictionary-full.txt";
		
		//theme_silly
		final String themeWordList = "theme_silly.txt";
		final String outputWordFile = "theme_silly_generated.txt";
		
		Scanner readerDic = new Scanner(new File(dictionary));
		Scanner readerTheme = new Scanner(new File(themeWordList));
		BufferedWriter writer = new BufferedWriter(new FileWriter(new File(outputWordFile)));
		
		ArrayList<String> dic = new ArrayList<String>();
		while (readerDic.hasNextLine())
			dic.add(readerDic.nextLine());
		readerDic.close();
		
		String themeLine;
		
		themeLoop:
		while (readerTheme.hasNextLine()) {
			themeLine = readerTheme.nextLine();		
			for (String dicLine : dic)
				if (themeLine.equalsIgnoreCase(dicLine.substring(0, dicLine.indexOf("|")))) { //word was found it dictionary, use that one
					writer.write(dicLine);
					writer.newLine();
					continue themeLoop;
				}
				writer.write(themeLine); //otherwise write plain word out for after manual editing
				writer.newLine();
		}
			
		readerTheme.close();
		writer.close();
		System.out.println("execution time: " + ((System.currentTimeMillis() - startTime) / 1000) + " seconds");
	}
}