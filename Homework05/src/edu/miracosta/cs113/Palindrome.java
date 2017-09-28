package edu.miracosta.cs113;
/**
* Palindrome.java
* 
* Class Invariant: 
* 
* @author Zachary Chao <zach.chao@yahoo.com>
* @version 1.0
* 

*/
import java.util.Scanner;
public class Palindrome {
	private static ArrayStack<Character> stack1 = new ArrayStack<Character>();
	private static ArrayStack<Character> stack2 = new ArrayStack<Character>();
	private static Scanner keyboard = new Scanner(System.in);
	/**
	 * The driver to use stacks to check if the string entered is a 
	 * palindrome
	 * * Algorithm - Given a string, find if it is a palindrome using a stack
		* 	This will be done by using two stacks
		* 	As well, there are two cases for this
		* 	Even number of characters - 
		* 		Add all characters to stack1, then pop half of them out of 
		* 		the stack1 into stack2, if these two stacks are equal 
		* 		then the string was a palindrome
		* 	Odd number of characters - 
		* 		Add all characters to stack1, then pop half of them out, 	
		* 		rounded up (eg, if 5 characters, pop out 3). and add them 
		* 		to stack2, except for the last one taken out
		* 		if these two stacks are equal
		* 		then the string was a palindrome
		* 
	 * @param args Command line not used
	 */
	public static void main(String[] args){
		System.out.println("Enter your string and I will tell you if it"
				+ " is a palindrome");
		String possiblePalindrome = keyboard.nextLine();
		int length = possiblePalindrome.length();
		String[] palindromeArray = possiblePalindrome.split("");
		//Whether it is odd or even add all characters to stack1
		for (String s : palindromeArray){
			stack1.push((Character)s.toLowerCase().charAt(0));
		}
		//This will happen half of the length of the string
		//rounded down
		for(int i = 0; i < length / 2; i++){
			//Add the last character entered into stack1
			//into stack2
			stack2.push(stack1.pop());
		}
		//If there was an even amount, pop another from stack1
		if(length % 2 == 1){
			stack1.pop();
		}
		//Make the stacks strings so that they can be compared
		String stackString1 = "";
		String stackString2 = "";
		//You only need to check if stack1 is empty because
		//they will both always be the same size
		while(stack1.empty() == false){
			stackString1 += stack1.pop();
			stackString2 += stack2.pop();
		}
		//If the two strings are equal then the string was
		// a palindrome
		if(stackString1.equals(stackString2)){
			System.out.println("That is a palindrome!");
		}else{
			System.out.println("That is not a palindrome.");
		}
	}
}
