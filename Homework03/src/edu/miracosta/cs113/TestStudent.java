/**
 *TestStudent.java Tests the student class constructor
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
 * Tests the student class for implementation of comparable and the 
 * 	constructor
 * 
 * @param commandLine params not taken
 *
 * @return None
 */
public class TestStudent {
	public static void main (String[] args){
		Student jack = new Student("Jack", "Burness");
		Student jill = new Student("Jill", "Burness");
		
		//Should return -1
		System.out.println(jack.compareTo(jill));
		//Should return 1
		System.out.println(jill.compareTo(jack));
		//Should return 0
		System.out.println(jill.compareTo(jill));
	}
}
