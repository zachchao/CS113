package edu.miracosta.cs113;
/**
 *NewMethods.java : The new methods defined in 2.1 on page 69
 *
 *Class Invariant : Assumes no user input or command line arguments
 *
 *@author   Zachary Chao <zach.chao@yahoo.com>
 *@version  1.0
 *
 */

import java.util.ArrayList;

public class NewMethods {
	public static ArrayList<String> manipList = new ArrayList<String>();
	/** 
	 * Main method driver that will call the new methods created
	 * 
	 * @param args Not used
	 * 
	 * @return None
	 */
	public static void main(String[] args){
		//Adding to the list to create it
		manipList.add("Orange");
		manipList.add("Red");
		manipList.add("Blue");
		manipList.add("Green");
		manipList.add("Blue");
		manipList.add("Yellow");
		manipList.add("Blue");
		
		displayArray(manipList);
		System.out.println("\nAfter\n");
		
		delete(manipList, "Blue");
		replace(manipList, "Blue", "Turqouise");
		displayArray(manipList);
		
	}
	
	/**
	 * Simple for loop to print the array for testing purposes
	 * 
	 * @param aList The arrayList to print
	 * 
	 * @return None
	 */
	public static void displayArray(ArrayList<String> aList){
		for(String string : aList){
			System.out.println(string);
		}
	}
	
	/**
	 *  Replaces each occurence of oldItem in aList with newItem
	 *  
	 * @param aList The item to replace the items within
	 * @param oldItem The old string to look for and replace
	 * @param newItem The new string to replace the old one with
	 * 
	 * @return None
	 */
	public static void replace(ArrayList<String> aList, String oldItem, String newItem){
		int counter = 0;
		for (String string : aList){
			if(string.equals(oldItem)){
				aList.set(counter, newItem);
			}
			//Regardless of if if happened
			counter += 1;
		}
	}
	
	/**
	 * Deletes the first occurence in the given arrayList of the given target
	 * 
	 * @param aList The list to delete the target from
	 * @param target The string to search for and delete
	 * 
	 * @return None
	 */
	public static void delete(ArrayList<String> aList, String target){
		int counter = 0;
		for (String string : aList){
			if(string.equals(target)){
				aList.remove(counter);
				break;
			}
			//Regardless of if if happened
			counter += 1;
		}
	}
}
