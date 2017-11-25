package edu.miracosta.cs113;

/**
 * RadixSort.java
 * 
 * Class Invariant: its recursive so it probably wont do huge numbers and only does integers
 * 
 * @author Zachary Chao <zach.chao@yahoo.com>
 * @version 1.0
 * 
 * Algorithm - 
 *Does the radix sort by going digit by digit
 *starting at the ones place until the max number
 *tallies how many are in a given digit from 0-9 then 
 *assigns an index for those ending in that indexes digit
 *Then goes through and reassigns based on that places digit
 *Stops when all are out of bounds 
 */ 
public class RadixSort {
	public static void main(String[] args){
		//int[] ray = {101, 165, 879, 163, 154, 112, 168, 656, 465, 786, 123, 786, 126, 100, 120, 121, 521, 631, 23, 1};
		int ray[] = new int[100];
		int max = 1000;
		int min = 0;
		
		for(int i = 0; i < 100; i++){
			int randomNum = min + (int)(Math.random() * ((max - min) + 1));
			ray[i] = randomNum;
		}
		
		ray = radix(ray, 1);
		for(int i : ray){
			System.out.print(i + " ");
		}	
	}
	
	/**
	 * Does the radixSort by
	 * @param ray The array to sort
	 * @param place The digit place we are sorting
	 * @return The sorted array
	 */
	private static int[] radix(int[] ray, int place) {
		//Will be shifted over one, the 0 place will be -1
		//Meaning out of bounds, index 10 is digit place of 9
		//Will be the count of how many have that digit
		int[] digitCountRay = new int[12];
		
		//Get the count of the numbers with that digits place
		for(int i : ray){
			digitCountRay[getDigit(i, place) + 2] += 1;
		}
		//If they are all out of bounds we are beyond for
		//the place and are done
		if(digitCountRay[1] == ray.length){
			return ray;
		}else{
			int index = 0;
			//We now make the digitCountRay where
			//the indexes for those digits should be placed
			for(int i = 0; i < 11; i++){
				index += digitCountRay[i];
				digitCountRay[i] = index;
			}
			
			int[] returnRay = new int[ray.length];
			for(int i : ray){
				int digit = getDigit(i, place) + 1;
				int newIndex = digitCountRay[digit];

				returnRay[newIndex] = i;
				digitCountRay[digit] += 1;
			}
			return radix(returnRay, place + 1);
		}
	}
	
	/**
	 * Gives the number in the place place, aka
	 * for n = 12345 place = 1, return 5, place = 2 return 4
	 * @param n The number to parse
	 * @param place The place to get
	 */
	private static int getDigit(int n, int place){
		try{
			String s = String.valueOf(n);
			return Integer.parseInt(String.valueOf(s.charAt(s.length() - place)));
		}catch (StringIndexOutOfBoundsException e){
			return -1;
		}
	}
}
