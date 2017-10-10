package edu.miracosta.cs113;
/**
 * OSPrinter.java
 * 
 * Class Invariant: Not actually multithreaded and does not wait
 * a minute because the program would take a long time to run. 
 * 
 * @author Zachary Chao <zach.chao@yahoo.com>
 * @version 1.0
 * 
 * Algorithm - 
 * The os should delegate printers and jobs
 * The jobs should be first prioritized by size
 * 	- Less than ten is a small job
 * 	- Less than twenty but larger than ten is a medium job
 * 	- Greater than twenty is a large job
 * When two jobs are of an equal size they are prioritized by 
 * the order they are entered
 * This will be done using three queues, one for small jobs
 * one for medium and a last one for large jobs
 * When the OSPrinter is fed an amount of pages to print
 * it will construct the object PrinterJob, this will set 
 * the type in an instance variable
 * The type will be gotten and then the jobw ill be put into
 * its designated queue
 * 
 */
public class OSPrinter {
	//Number of printers active, from 0-2
	private int numPrinters;
	//The array of printer objects
	private Printer[] printers;
	//The queues which the jobs will be added into
	private LinkedQueue<PrinterJob> smJobs = new LinkedQueue<PrinterJob>();
	private LinkedQueue<PrinterJob> mdJobs = new LinkedQueue<PrinterJob>();
	private LinkedQueue<PrinterJob> lgJobs = new LinkedQueue<PrinterJob>();
	//The counter to keep track of which job is being ran
	private int jobCounter = 1;
	
	private int minutes = 0;
	
	/**
	 * The constructor, takes in how many printers to use
	 * @param numPrinters The amount of printers to use
	 */
	public OSPrinter(int numPrinters){
		this.numPrinters = numPrinters;
		//Initialize printers
		printers = new Printer[numPrinters];
		for(int i = 0; i < numPrinters; i++){
			printers[i] = new Printer("Printer" + i);
		}
	}
	
	/**
	 * The OS recieving a new job to print
	 * This will create a new object and add it to the queue
	 * @param job The amount of pages to print
	 */
	public void recieveJob(int job){
		//Construct the object
		PrinterJob newJob = new PrinterJob(("Job" + jobCounter), job);
		System.out.println("Recieving job " + newJob);
		//Filter by the getType function and add the job into the appropriate
		//queue
		if(newJob.getType() == 0){
			smJobs.offer(newJob);
		}else if(newJob.getType() == 1){
			mdJobs.offer(newJob);
		}else{
			lgJobs.offer(newJob);
		}
		//Iterate the job count
		jobCounter += 1;
	}
	
	/**
	 * Simulate running the jobs through all the printers
	 * if a job does not finish within the first run of printing 10 pages
	 * the job will be removed from the queue but stored within the printer
	 * It will check if there are any small jobs first, the medium, then finally large
	 */
	public void runJobs(){
		//Execute this for all printers active
		for(int i = 0; i < numPrinters; i++){
			//If the printer is currently free and not working
			//Assign it a job if there exists one within the queue
			if(printers[i].getActiveJob() == null){
				//If a small job exists it gets precedence
				if(smJobs.peek() != null){
					printers[i].print(smJobs.remove());
				//If there are no small jobs and there are md jobs
				}else if(mdJobs.peek() != null){
					printers[i].print(mdJobs.remove());
				//If there are no small jobs or mdjobs but there are large jobs
				}else if(lgJobs.peek() != null){
					printers[i].print(lgJobs.remove());
				//If all queues are empty
				}else{
					System.out.println("No jobs in queue! Printers waiting.");
				}
			//If there is an active job already tell it to print
			//another ten pages and if those were the last ten
			//the active job will be set to null and the printer
			//will be opened up
			}else{
				printers[i].print();
			}
			
			//Add to the time
			minutes += 1;
		}
	}
	
	/**
	 * For when all jobs are sent in and the OS is simply left to 
	 * designate jobs to the printers 
	 */
	public void runUntilDone(){
		//while any of the queues still have jobs to print
		while(smJobs.peek() != null || mdJobs.peek() != null || lgJobs.peek() != null){
			runJobs();
			//Add to the time
			minutes += 1;
		}
		//Finish all active jobs within the printers
		for(int i = 0; i < numPrinters; i++){
			if(printers[i].getActiveJob() != null){
				runJobs();
			}
			//Add to the time
			minutes += 1;
		}
	}	
	
	/**
	 * Getter for minutes
	 * @return The minutes it took
	 */
	public int getMinutes(){
		return this.minutes;
	}
}
