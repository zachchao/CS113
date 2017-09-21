package edu.miracosta.cs113;
/**
 *DirectoryEntryDriver.java : Create and test the functions in 
 *
 *Class Invariant : Very limited class just to be used with an ArrayList 2.2 pg 71.
 *
 *@author   Zachary Chao <zach.chao@yahoo.com>
 *@version  1.0
 *
 */
import java.util.ArrayList;

public class DirectoryEntryDriver {
	public static ArrayList<DirectoryEntry> theDirectory = new ArrayList<DirectoryEntry>();
	/**
	 * main method for testing the two methods and DirectoryEntry class
	 * 
	 * @param args Not used
	 */
	public static void main(String[] args){
		//Fill the list to use it
		theDirectory.add(new DirectoryEntry("Nicholas", "7608288765"));
		theDirectory.add(new DirectoryEntry("Johnathon", "9877896587"));
		theDirectory.add(new DirectoryEntry("Bertha", "9877896587"));
		theDirectory.add(new DirectoryEntry("Jillathon", "9877896587"));
		theDirectory.add(new DirectoryEntry("Jamsonathon", "9877896587"));
		
		//Display and use the methods to test it
		displayList(theDirectory);
		addOrChangeEntry("Jackobathon", "23492039");
		displayList(theDirectory);
		addOrChangeEntry("Jamsonathon", "23492039");
		displayList(theDirectory);
		removeEntry("Jamsonathon");
		displayList(theDirectory);
		
	}
	
	/**
	 * Basic method for printing the array to use it
	 * 
	 * @param aList The directory to print
	 */
	public static void displayList(ArrayList<DirectoryEntry> aList){
		System.out.println("_________________________________");
		for (DirectoryEntry dE : aList){
			System.out.println(dE);
		}
		System.out.println("_________________________________");
	}
	
	/** Add an entry to theDirectory or change an existing entry.
	 * 
	 * @param aName The name of the person being added or changed
	 * @param newNumber The new number to be assigned
	 * 
	 * @return The old number, or if a new entry, null
	 */
	public static String addOrChangeEntry(String aName, String newNumber){
		int counter = 0;
		for (DirectoryEntry dE : theDirectory){
			if (dE.getName().equals(aName)){
				String oldNum = theDirectory.get(counter).getNumber();
				theDirectory.set(counter, new DirectoryEntry(aName, newNumber));
				//Will exit the program
				return oldNum;
			}
			//Only will happen if the name hasnt been found yet
			counter += 1;
		}
		//If it hasn't exited yet and has traversed the entire list then
		//  the person was never found
		theDirectory.add(new DirectoryEntry(aName, newNumber));
		return null;
	}
	
	/** Remove an entry.
	 * 
	 * @param aName The name of the person being removed
	 * 
	 * @return The entry removed, or null if there is no entry for aName
	 */
	public static DirectoryEntry removeEntry(String aName){
		int counter = 0;
		for (DirectoryEntry dE: theDirectory){
			if (dE.getName().equals(aName)){
				DirectoryEntry removed = theDirectory.get(counter);
				theDirectory.remove(counter);
				return removed;
			}
			//Only if aName was not found
			counter += 1;
		}
		//Only happens if the name was never found
		return null;
	}
}
