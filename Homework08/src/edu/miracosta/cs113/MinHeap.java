package edu.miracosta.cs113;

/**
 * MinHeap.java
 * 
 * Class Invariant: Assumes a compareTo method is defined for E
 * 
 * @author Zachary Chao <zach.chao@yahoo.com>
 * @version 1.0
 */
public class MinHeap<E> extends Heap<E> {

	/**
	 * Custom compare method which will return -1 if left is less
	 * than right, 1 if it is greater and 0 if they are even.
	 * 
	 * @return The compareTo value
	 */
	@Override
	public int compare(E left, E right) {
		if(comparator != null){
			return comparator.compare(left,  right);
		}else{
			return ((Comparable<E>) left).compareTo(right);
		}
	}
	
}
