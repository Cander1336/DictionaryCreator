package creator;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;
import java.io.IOException;

public class ThemeCreator {
	public static void main(String[] args) throws IOException {

		double startTime = System.currentTimeMillis();	

		Scanner readerDic = new Scanner(new File("dictionary-alfabetical.txt"));
		Scanner readerTheme = new Scanner(new File("theme_silly.txt"));
		BufferedWriter writer = new BufferedWriter(new FileWriter(new File("theme_silly_processed.txt")));
		
		
		
		String themeLine;
		String dicLine;
		boolean foundMatch = false;
		
		while (readerTheme.hasNextLine()) {
			themeLine = readerTheme.nextLine();		
			while (readerDic.hasNextLine()) {
				dicLine = readerDic.nextLine();
				if (themeLine.equals(dicLine.substring(0, dicLine.indexOf("|")))) {
					writer.write(dicLine);
					writer.newLine();
					foundMatch = true;
					break;
				}
			}
			if (!foundMatch) {
				writer.write(themeLine);
				writer.newLine();
			}
			else
				foundMatch = false;
			readerDic = new Scanner(new File("dictionary-alfabetical.txt"));
		}
			
		readerDic.close();
		readerTheme.close();
		writer.close();
		System.out.println("themeCreator execution time: " + ((System.currentTimeMillis() - startTime) / 1000) + " seconds");
		
	}

}
