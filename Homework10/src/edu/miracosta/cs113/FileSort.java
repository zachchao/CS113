package edu.miracosta.cs113;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * FileSort.java
 * 
 * Class Invariant: only does Integers
 * 
 * @author Zachary Chao <zach.chao@yahoo.com>
 * @version 1.0
 * 
 * Algorithm - 
 * We want to take in a file of integers delimited by a new line and sort it in a really weird way
 * in the beginning we split the input file into bins of size <runSize>, for this example I will use
 * a runSize of 3.
 * If our input is <752946159753>
 * We split it into bins of three, <752>, <946>, <159>, <753>
 * We then sort them using merge sort, giving us <257>, <469>, <159>, <753>
 * We write them alternately to the files so, 
 * OutFile1 - <257159>
 * OutFile2 - <469357>
 * We then merge them back into the input file, merging sets of three
 * So we merge <257> with <469> entering <245679> into the input
 * and merging <159> with <357> entering <135579> into the input
 * So after the initial run we have <245679135579> in our input file
 * We then just repeat this splitting process but on 2* the runSize, so now our bins are six
 * giving us <245679> and <135579> into our respective output files
 * we then merge them in the same way as before
 * giving us the end result of <1234556799>
 * 
 * This will be done recursively, our stopping case is when our runSize is
 * equal to our totalLength, we stopped in the example because the runSize 
 * doubled again and became 12, which was >= our totalLength of 12.
 */ 
public class FileSort {
	File input;
	File output1;
	File output2;
	int totalLength = 0;
	boolean firstRun = false;
	
	/**
	 * Constructor for the filesort, takes in the input file and 
	 * initializes the output files, clearing them and making everything clean
	 * also initializes the totalLength variable
	 * @param input The inputFile of unsorted Integers
	 * @throws IOException
	 */
	public FileSort(File input) throws IOException{
		this.input = input;
		this.output1 = new File("src/output1.txt");
		this.output2 = new File("src/output2.txt");
		
		//Overwrite output files in case they already had been written to before
		clearFile(this.output1);
		clearFile(this.output2);
		
		//Set the totalLength of the inputs
		totalLength = lengthOfFile(this.input);
	}
	
	/**
	 * What the user calls everytime they want the file sorted
	 * sets the instance variable firstRun to true so that it does
	 * the initial sorting and then calls the recursive method
	 * @param runSize The runSize the user would like
	 * @return True if successfully sorted
	 * @throws IOException
	 */
	public boolean sort(int runSize) throws IOException{
		this.firstRun = true;
		return recursiveFileSort(runSize, totalLength);
	}

	/**
	 * Recursively sort the file stopping when the runSize is >=
	 * the totalLength
	 * @param runSize The size each bin should be
	 * @param totalLength The totalLength of the inputs
	 * @return True if successful
	 * @throws IOException
	 */
	private boolean recursiveFileSort(int runSize, int totalLength) throws IOException{
		//Stopping case
		if(runSize >= totalLength){
			return true;
		}else{
			System.out.println("RUNSIZE - " + runSize);
			//Split
			split(runSize);
			//Merge
			mergeFiles(runSize);
			//Recurse
			recursiveFileSort(runSize * 2, totalLength);
		}
		//I think this is unreachable??
		return false;
	}

	/**
	 * Splits the input file into bins of size runSize alternately
	 * then clears the input so its ready to be written to
	 * if firstRun is true, sort before writing
	 * @param runSize Our initial runSize
	 * @return The length of the file
	 * @throws IOException
	 */
	private void split(int runSize) throws IOException{
		FileReader in = new FileReader(this.input);
		BufferedReader br = new BufferedReader(in);
		String line;
		
		int counter = 0;
		//This will be what we write to then sort
		Integer[] unSortedArray = new Integer[runSize];
		//We go through and grab n number of objects,
		//sort them then alternately write them to the ouput files
		while((line = br.readLine()) != null){
			//add to the array
			unSortedArray[counter % runSize] = Integer.parseInt(line);
			counter += 1;
			//If we have filled the array then we sort and write
			if(counter % runSize == 0){
				//Only actually need to sort on the first run
				if(this.firstRun){
					sortArray(unSortedArray);
				}
				//Array is now sorted, write it to the output file
				//We alternate, writing to output1 then output2 etc
				//This will alternate because assuming a runSize of 10
				//When its 10, its 1, 20 is 0, 30 is 1, 40 is 0
				File writeFile;
				if((counter / runSize) % 2 == 1){
					writeFile = this.output1;
				}else{
					writeFile = this.output2;
				}
				writeRayToFile(unSortedArray, writeFile, runSize);
			}
		}
		this.firstRun = false;
		//Clear input so it can be written to
		clearFile(this.input);
		br.close();
	}

	/**
	 * Merges the two output files into the input file given a runSize
	 * @throws IOException 
	 */
	private void mergeFiles(int runSize) throws IOException{		
		//Read both outputs to arrays
		Integer[] outputRay1 = fileToRay(this.output1);
		Integer[] outputRay2 = fileToRay(this.output2);
		
		ArrayList<Integer> partialSortedRay = new ArrayList<Integer>();
		
		int start = 0;
		int end = runSize;
		
		Integer[] left, right;
		Integer[] sorted = new Integer[runSize * 2];
		
		while(end <= totalLength / 2){
			//Split the two outputs into bins
			left = subArray(outputRay1, start, end);
			right = subArray(outputRay2, start, end);
			//Iterate
			start += runSize;
			end += runSize;
			//Merge them
			merge(sorted, left, right);
			System.out.println("MERGED");
			printRay(sorted);
			//Write them
			writeRayToFile(sorted, this.input, runSize * 2);
			//CLear them for the next bins
			clearFile(this.output1);
			clearFile(this.output2);
		}
	}

	/**
	 * Gets the amount of lines given a file
	 * @param fileName Line to measure
	 * @return the amount of lines
	 * @throws IOException
	 */
	private int lengthOfFile(File fileName) throws IOException{
		FileReader in = new FileReader(fileName);
		BufferedReader br = new BufferedReader(in);
		String line;
		int counter = 0;
		while((line = br.readLine()) != null){
			counter += 1;
		}
		return counter;
	}
	
	/**
	 * For readability :)
	 * @param fileToClear The file we want to clear
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	private void clearFile(File fileToClear) throws FileNotFoundException, IOException{
		new FileOutputStream(fileToClear).close();
	}
	
	/**
	 * Gives you a subArray from an array like python
	 * @param ray The array to split
	 * @param start The beginning index
	 * @param end ending index, not included
	 * @return The subArray
	 */
	private Integer[] subArray(Integer[] ray, int start, int end){
		Integer[] returnArray = new Integer[end - start];
		
		for(int i = start; i < end; i ++){
			returnArray[i - start] = ray[i];
		}
		
		return returnArray;
	}
	
	/**
	 * Prints an array
	 * @param ray Array to print
	 */
	private void printRay(Integer[] ray){
		for(Integer i : ray){
			System.out.println(i);
		}
	}
	
	/**
	 * Converts a file of Integers to an array
	 * @param readFile
	 * @return
	 * @throws IOException 
	 */
	private Integer[] fileToRay(File readFile) throws IOException{
		FileReader in = new FileReader(readFile);
		BufferedReader br = new BufferedReader(in);
		
		ArrayList<Integer> rayList = new ArrayList<Integer>();
		String line;
		while((line = br.readLine()) != null){
			rayList.add(Integer.parseInt(line));
		}
		Object[] objRay = rayList.toArray();
		Integer[] returnRay = new Integer[objRay.length];
		for(int i = 0; i < objRay.length; i++){
			returnRay[i] = Integer.parseInt(String.valueOf(objRay[i]));
		}
		return returnRay;
	}
	
	private void writeRayToFile(Integer[] sortedArray, File writeFile, int runSize) throws IOException{
		//We want to append so we use BufferedWriter
		BufferedWriter bw = new BufferedWriter(new FileWriter(writeFile, true));
		//Now write our sorted array
		for(int i = 0; i < runSize; i++){
			bw.write(String.valueOf(sortedArray[i]));
			bw.newLine();
			//System.out.println(sortedArray[i]);
		}
		bw.close();
	}

	private static <T extends Comparable<T>> void sortArray(T[] table) {
        // A table with one element is sorted already, stopping case
        if (table.length > 1) {
            // split table into halves
            int halfSize = table.length / 2;
            T[] leftTable = (T[]) new Comparable[halfSize];
            T[] rightTable = (T[]) new Comparable[table.length - halfSize];
            System.arraycopy(table, 0, leftTable, 0, halfSize);
            System.arraycopy(table, halfSize, rightTable, 0, table.length - halfSize);
            // Sort the halves
            sortArray(leftTable);
            sortArray(rightTable);

            // Merge halves
            merge(table, leftTable, rightTable);
        }
    }
	
	private static <T extends Comparable<T>> void merge(T[] outputSequence, T[] leftSequence, T[] rightSequence) {
        int i = 0; // index into the left input sequence
        int j = 0; // index into the right input sequence
        int k = 0; // index into the output sequence

        // while there is data in both input sequences
        while (i < leftSequence.length && j < rightSequence.length) {
            // find the smaller and
            // insert it into the output sequence.
            if (leftSequence[i].compareTo(rightSequence[j]) < 0) {
                outputSequence[k++] = leftSequence[i++];
            } else {
                outputSequence[k++] = rightSequence[j++];
            }
        }

        // assert: one of the sequences has more items to copy
        // copy remaining input from left sequence into the output
        while (i < leftSequence.length) {
            outputSequence[k++] = leftSequence[i++];
        }
        // copy remaining input from right sequence into output.
        while (j < rightSequence.length) {
            outputSequence[k++] = rightSequence[j++];
            // same as output[k] = right[i]
            // k++
            // i++
        }
    }	
}
