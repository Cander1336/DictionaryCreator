package creator;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

//removes all doublets in inputed word list and write result to a new file
public class DoubletRemover {
	public static void main(String[] args) throws IOException {
		
		double startTime = System.currentTimeMillis();	
		
		//theme
		final String inputWordFile = "theme_emotion.txt";
		final String outputWordFile = "theme_emotion.txt";

		Scanner reader = new Scanner(new File(inputWordFile));

		ArrayList<String> words = new ArrayList<String>();
		String temp;
		while (reader.hasNextLine())
			if (!words.contains(temp = reader.nextLine()))
				words.add(temp);
		reader.close();

		BufferedWriter writer = new BufferedWriter(new FileWriter(new File(outputWordFile)));
		for (String word : words) {
			writer.write(word); //otherwise write plain word out for after manual editing
			writer.newLine();
		}
		
		writer.close();
		System.out.println("execution time: " + ((System.currentTimeMillis() - startTime) / 1000) + " seconds");
	}
}
