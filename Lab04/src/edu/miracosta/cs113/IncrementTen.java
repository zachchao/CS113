package edu.miracosta.cs113;
/**
 *IncrementTen.java
 *
 *Class Invariant : None
 *
 *@author	Zachary Chao <zach.chao@yahoo.com>
 *@version 	1.0
 *
 *Algorithm - 
 * Compare the two functions, y1 and y2
 * y1 is 100 * n + 10
 * y2 is 5 * n * n + 2
 * Compare their values in increments of ten up to 100
 * Do this with a for loop, initializing n as 0
 * Then incrementing by ten until the value exceeds 100
 * Print them out in a table using a simple print f
 * Printing three columns, n, y1's value and y2's value
 */
public class IncrementTen {
	 /**
 	 *A tester method which compares two functions, y1 and y2
 	 *Prints the results in a nice little table
 	 *
 	 *No parameters
 	 *
 	 *No return value
 	 */
	public static void main(String[] args) {
		int y1, y2;
		System.out.printf("%4s  %6s  %6s\n", "n", "y1", "y2");
		for(int n = 0; n <= 100; n+=10) {
			y1 = 100 * n + 10;
			y2 = 5 * n * n + 2;
			System.out.printf("%4d  %6d  %6d\n", n, y1, y2);
		}
	}
}