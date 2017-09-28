package edu.miracosta.cs113;

import java.util.ArrayList;

public class ArrayStack<E> {
	/** The data of the ArrayStack */
	private ArrayList<E> theData = new ArrayList<E>();
	
	/**
	 * Return if the ArrayStack is empty or not
	 * @return Boolean if the ArrayStack is empty or not
	 */
	public boolean empty(){
		return theData.isEmpty();
	}
	
	/**
	 * Return the next object in ArrayStack
	 * @return The next object in ArrayStack
	 */
	public E peek(){
		return theData.get(theData.size() - 1);
	}
	
	/**
	 * Remove and return the next object in ArrayStack
	 * @return The removed object
	 */
	public E pop(){
		return theData.remove(theData.size() - 1);
	}
	
	/**
	 * Add a new object to the ArrayStack
	 * @param data The data to add
	 */
	public void push(E data){
		theData.add(data);
	}
}
