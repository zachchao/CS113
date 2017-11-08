package edu.miracosta.cs113;

public class MaxHeap<E> extends Heap<E> {

	@Override
	public int compare(E left, E right) {
		if(comparator != null){
			return comparator.compare(left,  right) * -1;
		}else{
			return ((Comparable<E>) left).compareTo(right) * -1;
		}
	}
	
}
