/**
 *StudentDriver.java : Main class for adding students to a roster
 *
 *Class Invariant : User inputs first and last name
 *
 *@author   Zachary Chao <zach.chao@yahoo.com>
 *@version  1.0
 * 
 * Algorithm - 
 * 	Assignment is to take in user input for student names in form "first last"
 * 	then create a linked list of these terms, letting the user choose options
 * 	the options are - 
 * 	1. Add a new student to the end of the roster
 * 	2. Add a new student to the beggining of the roster
 * 	3. Rmove student from the beginning of the roster
 * 	4. Remove a student by name
 * 	5. Exit the program
 * 
 */
package edu.miracosta.cs113;

import java.util.Scanner;
/** 
 * Main driver for creating the polynomial
 * 
 * @param none, takes user input in with Scanner
 *Algorithm -
 *	Get the integer input from the user then feed through an if and else for the following - 
 *	1. For adding a new student to the end of the roster
 *		This is quite simple, just add at the end of the linked list
 *	2. Adding to the beginning is simple as well, using the index just
 *		add to the 0th position
 *	3. Remove from the beginning, just call the remove function I have
 *		created for the linked list using an index of 0
 *	4. Remove a student by name
 *		Must traverse list until the student is found
 *		Have a 'found' boolean value that if false represents that
 *		the student was not found and that it does not exist within the list
 *		If it does, keep track of our current location and remove that index
 *	5. Exit the while loop
 */
public class StudentDriver {
	private static Scanner keyboard;
	public static void main(String[] args){
		DoubleLinkedList<Student> roster = new DoubleLinkedList<Student>();
		keyboard = new Scanner(System.in);
		
		String first, last; //Holds first and last name of the student
		int input = 1; //The integer choice that the user chooses
		boolean cont = true; //The program runs until this is false
		//Stops when user inputs an s to stop.
		while(cont){
			System.out.println("What do you want to do?");
			System.out.println("1. Add a new student to the end of the roster");
			System.out.println("2. Add a new student to the beginning of the roster");
			System.out.println("3. Remove the student from the beginning of the roster");
			System.out.println("4. Remove a student by name");
			System.out.println("5. To exit");
			System.out.println("Please input your choice (1-5)");
			boolean notValid = true;
			while (notValid){
				try{
					input = keyboard.nextInt();
				}catch(Exception InputMismatchException){
					System.out.println("Invalid input. Please try number 1-5");
				}
				if (input >= 1 && input <= 5){
					notValid = false;
					break;
				}else{
					input = 0;
					System.out.println("Invalid option please choose a number between 1 and 5.");
				}
			}
			if (input == 5){
				System.out.println("Stopping");
				System.out.println(roster.toString("\n"));
				cont = false;
				break;
			//Choice three is the only one which does not require a name
			}else if (input == 3){
				if (roster.size() > 0){
					System.out.println(roster.remove(0) + " has been removed from the roster.\n");
				}else{
					System.out.println("No one left to remove!\n");
				}
			//Any other choice requires getting the first and last name and constructing
			// a new student object
			}else if(input >= 1 && input <= 4){
				System.out.println("Please input the first and last name of the student");
				first = keyboard.next();
				//Looks for the stopping s case
				last = keyboard.next();
				Student tempStudent = new Student(first, last);
				if (input == 1){
					roster.add(tempStudent);
				}else if (input == 2){
					roster.addFirst(tempStudent);
				}else{
					if(roster.remove(tempStudent)){
						System.out.println(tempStudent + " was removed from the roster");
					}else{
						System.out.println(tempStudent + " does not exist within the roster.");
					}
				}
				System.out.println("Printing the list - ");
				System.out.println(roster.toString("\n") + "\n");
			}
		}
		
	}
}
