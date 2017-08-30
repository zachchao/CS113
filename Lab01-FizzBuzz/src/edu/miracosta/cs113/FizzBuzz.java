package edu.miracosta.cs113;
/**
 *FizzBuzz.java
 *
 *Class Invariant : Assumes 1 to 100 is non inclusive of one hundred.
 *
 *@author   Zachary Chao <zach.chao@yahoo.com>
 *@version  1.0
 *
 *Algorithm
 *Iterate through 100 with a for loop
 *Catch all that are divisible by both 3 and 5 by testing divisibility by 15
 *Use else if to catch everything which is not divisible by both but may be
 *divisible by just three or five. If it is not divisible print the number itself.
 */
 public class FizzBuzz{
 	/**
 	 *For numbers one to one hundred, print "Fizz" if the number is evenly
 	 *divisible by three, print "Buzz" if divisible by five, but if the number
 	 *is divisible by both three and five print "FizzBuzz", otherwise, print the
 	 *number.
 	 *
 	 *No parameters
 	 *
 	 *No return value
 	 */
 	public static void main(String args[]){
 		for(int i = 1; i < 100; i++){
 			//Divisible by both three and five
 			if(i % 15 == 0){
 				System.out.println("Fizzbuzz");
 			//Divisible by three
 			}else if(i % 3 == 0){
 				System.out.println("Fizz");	
 			//Divisible by five
 			}else if(i % 5 == 0){
 				System.out.println("Buzz");
 			//If not divisible by three or five
 			}else{
 				System.out.println(i);
 			}
 		}
 	}
 }