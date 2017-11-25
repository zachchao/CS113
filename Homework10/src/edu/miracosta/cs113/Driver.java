package edu.miracosta.cs113;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class Driver {
	public static void main(String[] args) throws IOException{
		File input = new File("src/input.txt");
		int max = 1000;
		int min = 0;
		
		//Make some random file
		BufferedWriter bw = new BufferedWriter(new FileWriter(input, true));
		//Now write our sorted array
		for(int i = 0; i < 1280; i++){
			int randomNum = min + (int)(Math.random() * ((max - min) + 1));
			bw.write(String.valueOf(randomNum));
			bw.newLine();
		}
		bw.close();
			
		FileSort sorter = new FileSort(input);
		sorter.sort(10);
		System.out.println("Done");
	}
}
