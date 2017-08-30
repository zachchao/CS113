package edu.miracosta.cs113;
/**
 *PowersOfTwo.java
 *
 *Class Invariant : Assumes 1 is included as a power of 2 being 2^0.
 *
 *@author	Zachary Chao <zach.chao@yahoo.com>
 *@version 	1.0
 *
 *Algorithm - 
 * Must create a method which returns a boolean denoting if the argument
 * passed is a power of two. Aka, True for 8 as it is 2^3, and False for 10
 * as it is not a power of two. 
 * This will be done using a recursive function, the stopping cases will be
 * if the integer n is negative, odd, 0, 1 or 2. In the case that the number is
 * 0, negative and odd it will immediately return false and never run the recursive
 * loop. If it is 1 or 2 it will return True. Otherwise it will recursively 
 * call itself with half of its argument by using powerOfTwo(n/2).
 * Every case will be caught as the number will eventually become
 * odd, 1 or 2, or have been placed in as a decimal, negative number or 0.
 */
public class PowersOfTwo {
    /**
 	 *A tester method which calls powerOfTwo on different values
 	 *
 	 *No parameters
 	 *
 	 *No return value
 	 */
    public static void main(String[] args) {
        double testValues[] = {5, 128, 528, 1024, -1024};
        for (double n :testValues){
        	System.out.println(powerOfTwo(n));
        }
    }
    
    /**
 	 *Boolean method that returns true if a number is a power of two
 	 *otherwise returns false
 	 *
 	 *@param n	the double which is to be tested
 	 *@return	a boolean of whether or not n is a power of two
 	 */
    public static boolean powerOfTwo(double n){
    	if(n == 1 || n == 2){
    		return true;
    	}else{
    		if(n % 2 == 0 && n > 0){
    			return powerOfTwo(n/2);
    		}else{
    			return false;
    		}
    	}
    }
}

