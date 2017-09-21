/**
 *TermDriver.java : Main class for creating polynomials using a 
 *linked list of terms
 *
 *Class Invariant : Assumes only one variable, x 
 *
 *@author   Zachary Chao <zach.chao@yahoo.com>
 *@version  1.0
 *   
 * Algorithm - 
 * 	Assignment is to take in user input of terms in the form "2x^2"
 * 	then create a linked list of these terms, ordering them by 
 * 	ascending order of exponents. Ex 2x^2 + 4x^4
 * 	This will be done using a linked list of type term
 * 	Input taken in using Scanner and regex matcher to make it easier
 * 	Will have a stopping case of 's'
 *  Then input it into the linked list at the correct position
 * 
 */
package edu.miracosta.cs113;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/** 
 * Main driver for creating the polynomial
 * 
 * @param none, takes user input in with Scanner
 *Algorithm -
 *	1. Read in user input as a line with Scanner in a loop
 *  2. Parse it with regex
 *  3. Create temporary object
 *  4. Find position for insertion - 
 *  	a. If it is the lowest exponent of all it goes first
 *  	b. If it is between two if will be added at that position
 *  	c. If it is the largest it goes at the end
 *  	d. If it is equal it will use the set method
 *  5. Insert at the correct position
 *  6. Continue the loop
 */
public class TermDriver {
	private static Scanner keyboard;
	public static void main(String[] args){
		LinkedList<Term> termList = new LinkedList<Term>();
		keyboard = new Scanner(System.in);
		
		int coefficient, exponent; //Holds results of the regex before constructing the term
		String expression; //The expression which is taken in as a line
		boolean cont = true; //The program runs until this is false
		//Stops when user inputs an s to stop.
		while(cont){
			System.out.println("Please input a new value to add to the term sequence. Enter 'S' to stop the program.");
			expression = keyboard.nextLine();
			//Looks for the stopping s case
			if (expression.equalsIgnoreCase("s")){
				System.out.println("Stopping");
				cont = false;
			}else{
				//Simple patter to match either form 2x^2 or the lazy form 2x2
				String pattern = "([0-9]+)([A-Za-z]+)(\\^|)([0-9]+)";
				Pattern p = Pattern.compile(pattern);
				Matcher m = p.matcher(expression);
				if (m.find( )){
					//Use the regex to match the term expression
					coefficient = Integer.parseInt(m.group(1));
					exponent = Integer.parseInt(m.group(4));
					//Construct the term which will be added as data
					Term tempTerm = new Term(coefficient, exponent);
					int counter = 0;
					Term node = (Term) termList.get(counter);
					//If it is the first to be added to the list 
					if (node == null){
						termList.add(tempTerm);
					//If the list has nodes in it
					}else{
						while (termList.get(counter) != null){
							//If the term is lower than the current node it must be placed after
							if(tempTerm.compareTo(termList.get(counter)) == -1){
								//If it is the smallest to be placed in the list so far
								if (counter == 0){
									termList.add(counter, tempTerm);
									break;
								//If the next is larger it should be placed between the two
								}else if (tempTerm.compareTo(termList.get(counter-1)) == 1){
									termList.add(counter, tempTerm);
									break;
								}
							//If the two are equal add the two coefficients
							}else if(tempTerm.compareTo(termList.get(counter)) == 0){
								tempTerm = new Term(tempTerm.getCoefficient() + termList.get(counter).getCoefficient(), exponent);
								termList.set(counter, tempTerm);
								break;
							}
							counter += 1;
							//If the end of the list is hit implying the largest in the polynomial
							if (termList.get(counter) == null){
								termList.add(tempTerm);
								break;
							}
						}
					}
				//If regex is not matched
				}else{
					System.out.println("Invalid form - please put in form 2x^2");
				}
				//Prints the term list everytime a new term is inputed
				System.out.println("Term List - " + termList.toString(" + "));
				
			}
		}//End of while loop
		System.out.println("Term List - " + termList.toString(" + "));
	}
}
