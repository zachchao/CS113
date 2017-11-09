package edu.miracosta.cs113;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

abstract class Heap<E> extends PriorityQueue<E> implements Comparator<E>{
	protected ArrayList<E> data = null;
	protected Comparator<E> comparator = null;
	
	public Heap(){
		this.data = new ArrayList<E>();
	}
	
	public Heap(Comparator<E> comparator){
		this.data = new ArrayList<E>();
		this.comparator = comparator;
	}
	
	public boolean offer(E obj){
		//Soft add
		data.add(obj);
		//Check if object is larger than its parent
		int childPos = data.size() - 1;
		int parentPos;
		//If the child is the right child
		if(childPos % 2 == 0){
			parentPos = (childPos / 2) - 1;
		}else{
			parentPos = (childPos - 1) / 2;
		}
		while(parentPos >= 0 && compare(data.get(childPos), data.get(parentPos)) < 0){
			swap(parentPos, childPos);
			childPos = parentPos;
			//If the child is the right child
			if(childPos % 2 == 0){
				parentPos = (childPos / 2) - 1;
			}else{
				parentPos = (childPos - 1) / 2;
			}
		}
		return true;
	}
	
	@Override
	public E poll(){
		if(isEmpty()){
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
	
	private void swap(int parentPos, int childPos){
		E temp = data.get(parentPos);
		data.set(parentPos, data.get(childPos));
		data.set(childPos, temp);
	}
	
	public abstract int compare(E left, E right);
	
	public String toString(){
		String returnString = "";
		
		for(int i = 0; i < data.size() - 1; i++){
			returnString += data.get(i) + ", ";
		}
		
		return returnString + data.get(data.size() - 1);
	}
}
