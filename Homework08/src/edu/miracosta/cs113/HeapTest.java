package edu.miracosta.cs113;

/**
 * HeapTest.java
 * 
 * Class Invariant: Assumes args arent used
 * 
 * @author Zachary Chao <zach.chao@yahoo.com>
 * @version 1.0
 */
public class HeapTest {
	/**
	 * Runs simple tests for the min and max heap's offer an poll
	 * functions
	 * 
	 * @param args Not used
	 */
	public static void main(String[] args){
		int[] testVals = {56,7,9,2,65,4,23,1};
		
		MinHeap<Integer> minHeap = new MinHeap<Integer>();
		MaxHeap<Integer> maxHeap = new MaxHeap<Integer>();
		
		for(int i : testVals){
			minHeap.offer(i);
			System.out.println(minHeap);
		}
		
		for(int i = 0; i < testVals.length; i++){
			System.out.print(minHeap.poll() + " ");
		}
		System.out.println("");
		
		for(int i : testVals){
			maxHeap.offer(i);
			System.out.println(maxHeap);
		}
		
		for(int i = 0; i < testVals.length; i++){
			System.out.print(maxHeap.poll() + " ");
		}
		System.out.println("");
	}
}
