package edu.miracosta.cs113;

public class PrinterJob {
	private String name;
	private int pages;
	//0-2 representation of sm, md, lg
	private int type;
	
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
	
	/*
	 * If the pages are below 0 then the job is already done
	 * @return Whether or not the job has been finished
	 */
	public boolean notDone(){
		if(pages > 0){
			return true;
		}
		return false;
	}
	
	/*
	 * Acts out printing ten pages
	 */
	public void print(){
		this.pages -= 10;
	}

	public int getPages() {
		return pages;
	}

	public void setPages(int pages) {
		this.pages = pages;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}
	
	public boolean equals(PrinterJob other){
		if (this.name.equals(other.getName())){
			if (this.pages == other.getPages()){
				return true;
			}
		}
		return false;
	}
	
	public String toString(){
		return name + " - " + pages + " pages remaining.";
	}
}
