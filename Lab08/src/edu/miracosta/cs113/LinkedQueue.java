package edu.miracosta.cs113;

import java.util.Collection;
import java.util.NoSuchElementException;
import java.util.LinkedList;
import java.util.Iterator;
/**
 * LinkedQueue.java
 * 
 * Class Invariant: Assumes you only want to use offer, remove
 * 	poll, peek and element 
 * 
 * @author Zachary Chao <zach.chao@yahoo.com>
 * @version 1.0
 * 
 * Algorithm - A queue data structure built with an linked list
 * 	A queue should do five things, offer, remove, poll, peek, element
 * 	Offer - 
 * 		Adding an object to the front of the queue
 * 		This will be done by calling addLast onto the linkedList
 * 		Always returns true
 * 	Remove - 
 * 		Removes the entry at the front of queue
 * 		Done by calling removeFirst
 * 		If the queue is empty will throw NoSuchElementException
 * 	Poll - 
 * 		Exactly the same as remove but returns null if empty
 * 	Peek - 
 * 		Returns the entry at the front of the queue without removing it
 * 		returns null if it is empty
 * 	Element - 
 * 		Exactly the same as peek but throw a NoSuchElementException
 * 		if the queue is empty
 */
public class LinkedQueue<E> implements Collection<E>{
	 // Data Field
    private LinkedList<E> theQueue = new LinkedList<E>(); // LinkedList that is the queue.

    /**
     * Inserts an item at the rear of the queue.
     * @param item The element to add
     * @return true (always successful)
     */
    public boolean offer(E item) {
        theQueue.addLast(item);
        return true;
    }
    
    /**
     * Removes the object at the front of the queue
     * If the queue was empty throw NoSuchElementException
     * @return The object removed 
     */
    public E remove(){
    	if (theQueue.size() == 0){
    		throw new NoSuchElementException();
    	}else{
    		return theQueue.removeFirst();
    	}
    }

    /**
     * Removes the entry at the front of the queue and returns it.
     * @return The item removed if successful, or null if not
     */
    public E poll() {
        if (theQueue.size() == 0) {
            return null;
        } else {
            return theQueue.get(0);
        }
    }

    /**
     * Returns the item at the front of the queue without removing it.
     * @return The item at the front if successful; null if not
     */
    public E peek() {
        if (theQueue.size() == 0) {
            return null;
        } else {
            return theQueue.getFirst();
        }
    }
    
    /**
     * Return the entry at the front of queue without removing it.
     * If the queue is empty, throw a NoSuchElementException
     * @return The item at the front
     */
    public E element(){
    	if (theQueue.size() == 0) {
            throw new NoSuchElementException();
        } else {
            return theQueue.getFirst();
        }
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    //Stubs
	@Override
	public boolean add(Object e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAll(Collection c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean contains(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsAll(Collection c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterator iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean remove(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeAll(Collection c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean retainAll(Collection c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object[] toArray(Object[] a) {
		// TODO Auto-generated method stub
		return null;
	}

// Insert solution to programming exercise 2, section 3, chapter 4 here
}
/*</listing>*/

