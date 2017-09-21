package edu.miracosta.cs113;

public class DirectoryEntry {
	String name;
	String number;
	
	public DirectoryEntry(String name, String number){
		this.name = name;
		this.number = number;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public String getName(){
		return name;
	}
	
	public void setNumber(String number){
		this.number = number;
	}
	
	public String getNumber(){
		return number;
	}
	
	public String toString(){
		return name + " - " + number;
	}
	
	public boolean equals(DirectoryEntry other){
		if (other.getName() == this.name){
			if (other.getNumber() == this.number){
				return true;
			}
		}
		return false;
	}
}
