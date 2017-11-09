package edu.miracosta.cs113;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Heap.java
 * 
 * Class Invariant: Assumes a compareTo method is defined for E
 * 
 * @author Zachary Chao <zach.chao@yahoo.com>
 * @version 1.0
 * 
 * Algorithm - 
 * 	Heap class
 * 		heap is essentially a binary tree that is always complete
 * 		parents are always less than the child in value
 * 		because it is so specific we can implement using an arrayList
 * 	Has an arrayList for the data and a comparator to determine what is meant by "less"
 * 	Constructor with a comparator and constructor without.
 * 
 */
public abstract class Heap<E> extends PriorityQueue<E> implements Comparator<E>{
	protected ArrayList<E> data = new ArrayList<E>();
	protected Comparator<E> comparator = null;
	
	/**
	 * Default constructor, leaves comparator as null
	 */
	public Heap(){
	}
	
	/**
	 * Constructor which takes a custom comparator
	 * @param comparator
	 */
	public Heap(Comparator<E> comparator){
		this.comparator = comparator;
	}
	
	/**
	 * Overrides PriorityQueue's offer
	 * 
	 * @param obj
	 */
	@Override
	public boolean offer(E obj){
		//Soft add
		data.add(obj);
		//Check if object is larger than its parent
		int childPos = data.size() - 1;
		int parentPos;
		//If the child is the right child
		if(childPos % 2 == 0){
			parentPos = (childPos / 2) - 1;
		//Else its the left child
		}else{
			parentPos = (childPos - 1) / 2;
		}
		//If youre not at the head and the child is less than the parent
		while(parentPos >= 0 && compare(data.get(childPos), data.get(parentPos)) < 0){
			swap(parentPos, childPos);
			childPos = parentPos;
			//If the child is the right child
			if(childPos % 2 == 0){
				parentPos = (childPos / 2) - 1;
				//Else its the left child
			}else{
				parentPos = (childPos - 1) / 2;
			}
		}
		return true;
	}
	
	/**
	 * Takes the root off then makes the new root and refactors
	 * the tree then returns the value
	 * 
	 * @return The value removed from the top
	 */
	@Override
	public E poll(){
		if(data.isEmpty()){
			return null;
		}
		
		E result = data.get(0);
		
		//Special case of one
		if(data.size() == 1){
			data.remove(0);
			return result;
		}
		
		data.set(0, data.remove(data.size() - 1));
		
		int parentPos = 0;
		
		while(true){
			int leftPos = 2 * parentPos + 1;
			if (leftPos >=  data.size()){
				break;
			}
			
			int rightPos = leftPos + 1;
			
			//Assumes left child is smaller
			int minPos = leftPos;
			
			if(rightPos < data.size() && compare(data.get(leftPos), data.get(rightPos)) > 0){
				minPos = rightPos;
			}
			
			if(compare(data.get(parentPos), data.get(minPos)) > 0){
				swap(parentPos, minPos);
				parentPos = minPos;
			}else{
				break;
			}
		}
		return result;
	}
	
	/**
	 * Swaps two indices for the list
	 * @param parentPos The index of the parent node
	 * @param childPos Index for the child node
	 */
	private void swap(int parentPos, int childPos){
		//Hold the parent data
		E temp = data.get(parentPos);
		//Swap 'em
		data.set(parentPos, data.get(childPos));
		data.set(childPos, temp);
	}
	
	/**
	 * Abstract method for min and max heaps as they will 
	 * be different in that minHeap will check if the parent is 
	 * less than the child whilst max will do the opposite
	 * 
	 * @return Returns 1 if left is greater, -1 if lesser and 0 if the two are even
	 */
	public abstract int compare(E left, E right);
	
	/**
	 * A to string which will print out the current state of the 
	 * arrayList
	 * 
	 * @return Returns a string representation of the heap
	 */
	public String toString(){
		String returnString = "[";
		
		for(int i = 0; i < data.size() - 1; i++){
			returnString += data.get(i) + ", ";
		}
		
		return returnString + data.get(data.size() - 1) + "]";
	}
}
