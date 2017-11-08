package edu.miracosta.cs113;

public class MinHeap<E> extends Heap<E> {

	@Override
	public int compare(E left, E right) {
		if(comparator != null){
			return comparator.compare(left,  right);
		}else{
			return ((Comparable<E>) left).compareTo(right);
		}
	}
	
}
