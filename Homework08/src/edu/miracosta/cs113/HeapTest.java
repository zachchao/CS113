package edu.miracosta.cs113;

public class HeapTest {
	public static void main(String[] args){
		int[] testVals = {56,7,9,2,65,4,23,1};
		
		MinHeap<Integer> minHeap = new MinHeap<Integer>();
		MaxHeap<Integer> maxHeap = new MaxHeap<Integer>();
		
		for(int i : testVals){
			minHeap.offer(i);
			System.out.println(minHeap);
		}
		
		for(int i : testVals){
			maxHeap.offer(i);
			System.out.println(maxHeap);
		}
		
	}
}
