package edu.miracosta.cs113;

import java.util.LinkedList;
/**
 * LinkedStack.java
 * 
 * Class Invariant: does not throw any of its own exceptions
 * 
 * @author Zachary Chao <zach.chao@yahoo.com>
 * @version 1.0
 * 
 * Algorithm - A stack data structure built with a linked list
 * 	A stack should do four things, check if its empty, peek, pop and push
 * 	Empty - 
 * 		This can use the linked list's isEmpty() function to check
 * 		if there is any data within the stack
 * 	Peek - 
 * 		This will return the data without removing it from the
 * 		stack, this will be done by simply using the linked list's
 * 		get function on the last element
 * 	Pop - 
 * 		This will 'pop' the thing that was last inserted
 * 		This will be done by using the linked list's remove function
 * 		as this returns the data and removes it from the data structure
 * 		it will call pop on the last element in thelist
 * 	Push - 
 * 		This will add to the linked list at the end using
 * 		the linked list's .add function.
 */
public class LinkedStack<E> {
	/** The data of the ArrayStack */
	private LinkedList<E> theData = new LinkedList<E>();
	
	/**
	 * Return if the LinkedStack is empty or not
	 * @return Boolean if the LinkedStack is empty or not
	 */
	public boolean empty(){
		return theData.isEmpty();
	}
	
	/**
	 * Return the next object in LinkedStack
	 * @return The next object in LinkedStack
	 */
	public E peek(){
		return theData.get(theData.size() - 1);
	}
	
	/**
	 * Remove and return the next object in LinkedStack
	 * @return The removed object
	 */
	public E pop(){
		return theData.remove(theData.size() - 1);
	}
	
	/**
	 * Add a new object to the LinkedStack
	 * @param data The data to add
	 */
	public void push(E data){
		theData.add(data);
	}
}
