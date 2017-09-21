package edu.miracosta.cs113;
/**
 *DirectoryEntry.java : Object for entries into a directory
 *
 *Class Invariant : Very limited class just to be used with an ArrayList
 *
 *@author   Zachary Chao <zach.chao@yahoo.com>
 *@version  1.0
 *
 */
public class DirectoryEntry {
	String name;
	String number;
	
	/**
	 * Basic constructor
	 * @param name The name of the entry
	 * @param number The phone number for the entry
	 */
	public DirectoryEntry(String name, String number){
		this.name = name;
		this.number = number;
	}
	
	/**
	 * Setter for the name
	 * 
	 * @param name The name for the entry to be added
	 */
	public void setName(String name){
		this.name = name;
	}
	
	/**
	 * The getter for the name
	 * 
	 * @return The name of the entry
	 */
	public String getName(){
		return name;
	}
	
	/**
	 * Setter for the phone number
	 * 
	 * @param number The phone number to set the entry to
	 */
	public void setNumber(String number){
		this.number = number;
	}
	
	/**
	 * Getter for the phone number
	 * 
	 * @return The phone number for the entry
	 */
	public String getNumber(){
		return number;
	}
	
	/**
	 * Basic toString method to make an entry a string
	 * 
	 * @return the String representation
	 */
	public String toString(){
		return name + " - " + number;
	}
	
	/**
	 * equals method
	 * 
	 * @param other The other entry to test equality with
	 * 
	 * @return True or false if they are equal or not
	 */
	public boolean equals(DirectoryEntry other){
		if (other.getName() == this.name){
			if (other.getNumber() == this.number){
				return true;
			}
		}
		return false;
	}
}
