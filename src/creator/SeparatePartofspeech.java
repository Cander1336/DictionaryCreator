package creator;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class SeparatePartofspeech {

	public static void main(String[] args) throws IOException {
		double startTime = System.currentTimeMillis();	
		Scanner reader = new Scanner(new File("dictionary-full.txt"));
		BufferedWriter writer = new BufferedWriter(new FileWriter(new File("dictionary-full_separated_partofspeech.txt")));

		String line;
		String text;
		String word;
		ArrayList<String> posh;
		for (int i = 1; reader.hasNextLine(); i++) {
			line = reader.nextLine();
			word = line.substring(0, line.indexOf("|"));
			text = line.substring(0, line.lastIndexOf("|")+1);
			String[] partofspeeches = line.substring(line.lastIndexOf("|")+1).split("\\.");
			posh = new ArrayList<String>();
			for (String p : partofspeeches)
				posh.add(p);
			
			if(word.charAt(word.length() - 1) == 's' && posh.contains("plural noun") && posh.contains("noun"))
				posh.remove("noun");		
			
			for (int j = 0; j < posh.size(); j++) {
				writer.write(text + posh.get(j));
				writer.newLine();
			}
			

		}
		reader.close();
		writer.close();
		System.out.println("execution time: " + ((System.currentTimeMillis() - startTime) / 1000) + " seconds");

	}

}
