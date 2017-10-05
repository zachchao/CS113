package edu.miracosta.cs113;

import java.util.ArrayList;

public class OSPrinterDriver {
	public static void main(String[] args){
		ArrayList<Integer> jobs = new ArrayList<Integer>();
		Integer[] jobRay = {1, 23, 10, 11, 8, 3, 33, 52};
		//Populate the job arraylist
		for (int i : jobRay){
			jobs.add(i);
		}
		OSPrinter osPrinter = new OSPrinter(2);
		
		//While there are jobs to send still
		while(!jobs.isEmpty()){
			osPrinter.recieveJob(jobs.remove(0));
			osPrinter.runJobs();
		}
		osPrinter.runUntilDone();
	}
}
