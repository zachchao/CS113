package edu.miracosta.cs113;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;
/** OSPrinterDriver.java
* 
* Class Invariant: Not actually multithreaded and does not wait
* a minute because the program would take a long time to run. 
* 
* @author Zachary Chao <zach.chao@yahoo.com>
* @version 1.0
* 
* Algorithm - 
* 	Randomly populates 100 jobs  
* 	Asks the user for the amount of printers they want to use
* 	Runs the jobs through the OS
* 	Runs the os until it shuts down
*/
public class OSPrinterDriver {
	private static int minPages = 1;
	private static int maxPages = 50;
	public static void main(String[] args){
		ArrayList<Integer> jobs = new ArrayList<Integer>();
		/*
		//To test
		Integer[] jobRay = {1, 23, 10, 11, 8, 3, 33, 52};
		//Populate the job arraylist
		for (Integer i : jobRay){
			jobs.add(i);
		}
		*/
		//Randomly populate jobs
		for(int i = 0; i < 100; i++){
			jobs.add(ThreadLocalRandom.current().nextInt(minPages, maxPages + 1));
		}
		//Get number of printers from the user
		Scanner keyboard = new Scanner(System.in);
		System.out.println("How many printers would you like to use?");
		int numPrinters = keyboard.nextInt();
		OSPrinter osPrinter = new OSPrinter(numPrinters);
		keyboard.close();
		
		//While there are jobs to send still
		while(!jobs.isEmpty()){
			osPrinter.recieveJob(jobs.remove(0));
			osPrinter.runJobs();
		}
		osPrinter.runUntilDone();
	}
}
