package edu.miracosta.cs113;

/**
 * MaxHeap.java
 * 
 * Class Invariant: Assumes a compareTo method is defined for E
 * 
 * @author Zachary Chao <zach.chao@yahoo.com>
 * @version 1.0
 */
public class MaxHeap<E> extends Heap<E> {

	/**
	 * Custom compare method which will return -1 if left is greater
	 * than right, 1 if it is lesser and 0 if they are even.
	 * 
	 * @return The inverse of the compareTo value
	 */
	@Override
	public int compare(E left, E right) {
		if(comparator != null){
			return comparator.compare(left,  right) * -1;
		}else{
			return ((Comparable<E>) left).compareTo(right) * -1;
		}
	}
	
}
