package edu.miracosta.cs113;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class MorseTest {
	private static BinaryTree tree = new BinaryTree();
	private static HashMap<String, String> morseMapping = new HashMap<String, String>();
	public static final String FILE_NAME = "src/MorseCode";
	
	public static void main(String[] args) throws IOException {
		File directory = new File(FILE_NAME);
		FileReader in = new FileReader(directory);
		BufferedReader br = new BufferedReader(in);
		String line;
		
		while((line = br.readLine()) != null)
		{
			String[] lineRay = line.split(" ");
			morseMapping.put(lineRay[1], lineRay[0]);
		}
		
		System.out.println(morseMapping.get("*--*"));
		MorseTree tree = new MorseTree();
		
		
	}
}
