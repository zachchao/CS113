package edu.miracosta.cs113;
/**
 *PowersOfTwo.java
 *
 *Class Invariant : Assumes 1 is included as a power of 2 being 2^0.
 *
 *@author	Zachary Chao <zach.chao@yahoo.com>
 *@version 	1.0
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
 	 *
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

