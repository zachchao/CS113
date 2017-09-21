/**
 *TestTerm.java Tests the Term class constructor
 *and comparable interface
 *
 *Class Invariant : None
 *
 *@author   Zachary Chao <zach.chao@yahoo.com>
 *@version  1.0
 * 
 */
package edu.miracosta.cs113;

/**
 * Tests the term class for implementation of comparable and the 
 * 	constructor
 * 
 * @param commandLine params not taken
 *
 * @return None
 */
public class TestTerm {
	public static void main(String[] args){
		Term t1 = new Term(3, 5);
		Term t2 = new Term(4, 4);
		
		System.out.println("Comparing " + t1 + " to " + t2);
		System.out.println(t1.compareTo(t2));
		System.out.println("Comparing " + t2 + " to " + t1);
		System.out.println(t2.compareTo(t1));
		System.out.println("Comparing " + t1 + " to " + t1);
		System.out.println(t1.compareTo(t1));
	}
}
