package edu.miracosta.cs113;

import java.util.ArrayList;

public class DirectoryEntryDriver {
	public static ArrayList<DirectoryEntry> theDirectory = new ArrayList<DirectoryEntry>();
	public static void main(String[] args){
		theDirectory.add(new DirectoryEntry("Nicholas", "7608288765"));
		theDirectory.add(new DirectoryEntry("Johnathon", "9877896587"));
		theDirectory.add(new DirectoryEntry("Bertha", "9877896587"));
		theDirectory.add(new DirectoryEntry("Jillathon", "9877896587"));
		theDirectory.add(new DirectoryEntry("Jamsonathon", "9877896587"));
		
		for (DirectoryEntry dE : theDirectory){
			System.out.println(dE);
		}
		
		
	}

}
