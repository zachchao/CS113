package edu.miracosta.cs113;
/** PrinterJob.java
* 
* Class Invariant: 
* 
* @author Zachary Chao <zach.chao@yahoo.com>
* @version 1.0
* 
* Algorithm - 
* Holds the printerJobs name, pages and type
* Name - 
* 	Will just hold a name like Job1, Job2 for output
* Pages - 
* 	The amount of pages left in the job to print
* Type - 
* 	The type, small, medium large job
* Constructor will set the type by searching its page size
* Method notDone() Will check if the job is finished, when the pages are all printed
* 
*/
public class PrinterJob {
	private String name;
	private int pages;
	//0-2 representation of sm, md, lg
	private int type;
	/**
	 * Sets the type and the instance variables
	 * @param name The name of the job, aka Job1
	 * @param pages The amount of pages it is initalized with
	 */
	public PrinterJob(String name, int pages){
		this.setName(name);
		this.setPages(pages);
		if(this.getPages() < 10){
			this.setType(0);
		}else if(this.getPages() >= 10 && this.getPages() < 20){
			this.setType(1);
		}else{
			this.setType(2);
		}
	}
	
	/**
	 * If the pages are below 0 then the job is already done
	 * @return Whether or not the job has been finished
	 */
	public boolean notDone(){
		if(pages > 0){
			return true;
		}
		return false;
	}
	
	/**
	 * Acts out printing ten pages
	 */
	public void print(){
		this.pages -= 10;
	}
	
	/**
	 * Getter for pages variable
	 * @return The amount of pages left
	 */
	public int getPages() {
		return pages;
	}
	
	/**
	 * Set the amount of pages left, though this 
	 * shouldnt really ever be used
	 * @param pages The amount of pages to print
	 */
	public void setPages(int pages) {
		this.pages = pages;
	}

	/**
	 * Getter for the name for output
	 * @return The name of the job
	 */
	public String getName() {
		return name;
	}

	/** 
	 * Setter for the name for output
	 * @param name The name of the job
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Get the type, sm md or lg
	 * @return The type as an integer,
	 * sm = 0, md = 1, lg = 2
	 */
	public int getType() {
		return type;
	}

	/**
	 * Setter for the type 
	 * @param type The type of printJob
	 */
	public void setType(int type) {
		this.type = type;
	}
	
	/**
	 * Checks if the two jobs are equal
	 * @param other The other PrinterJob to check for equality
	 * @return Boolean if they are equal
	 */
	public boolean equals(PrinterJob other){
		if (this.name.equals(other.getName())){
			if (this.pages == other.getPages()){
				return true;
			}
		}
		return false;
	}
	
	/**
	 * A string represetnation of the job
	 * @return The string representation of the job
	 */
	public String toString(){
		return name + " - " + pages + " pages remaining.";
	}
}
