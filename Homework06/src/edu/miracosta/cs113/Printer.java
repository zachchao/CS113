package edu.miracosta.cs113;
/**
 * Printer.java
 * 
 * Class Invariant: Assumes to be used with OSPrinter
 * 
 * @author Zachary Chao <zach.chao@yahoo.com>
 * @version 1.0
 * 
 * Algorithm - 
 * Each printer will have a name for output and an active job 
 * for jobs which are not finished on the first run!
 * 
 */
public class Printer {
	private String name;
	private PrinterJob activeJob;
	
	/**
	 * Constructor
	 * @param name The name of the printer
	 */
	public Printer(String name){
		this.name = name;
	}
	
	/**
	 * Begin printing a given job, if the job does not finish printing
	 * aka, it is beyond 10 pages, then it will be set as its active job
	 * and will be continued printing as long as the printer job still
	 * has papers to print
	 * 
	 * @param job The printerJob to print
	 */
	public void print(PrinterJob job){
		this.activeJob = job;
		System.out.println(this.name + " is printing " + activeJob);
		activeJob.print();
		if(!activeJob.notDone()){
			activeJob = null;
		}
	}
	
	/**
	 * Print the currently active job, this will output what printer
	 * is printing as well as what job it is printing
	 * it will the invoke the print method of the job, decreasing its
	 * pages by 10, this may set the job to done, if it is
	 * set the activeJob to null, freeing the printer for a new job
	 */
	public void print(){
		System.out.println(this.name + " is printing " + activeJob);
		activeJob.print();
		if(!activeJob.notDone()){
			activeJob = null;
		}
	}

	/**
	 * Getter for the active job object
	 * @return The activeJob
	 */
	public PrinterJob getActiveJob() {
		return activeJob;
	}

	/**
	 * Setter for the activeJob
	 * @param activeJob The activeJob to set for the printer
	 */
	public void setActiveJob(PrinterJob activeJob) {
		this.activeJob = activeJob;
	}
}
