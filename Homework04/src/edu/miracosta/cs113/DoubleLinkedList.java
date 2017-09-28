package edu.miracosta.cs113;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class DoubleLinkedList<E> implements List<E>{

	private Node<E> head = null;
	private Node<E> tail = null;
	private int size = 0;
	
	/**
	 * add object to list at index
	 * @param index The index to add the object to
	 * @param obj The object to be added
	 * 
	 * @return True always because overridden function
	 */
	@Override
	public void add(int index, E obj) {
		listIterator(index).add(obj);
	}
	
	/**
	 * Add to the tail
	 * @param obj The object to add to the list
	 */
	@Override
	public boolean add(E obj) {
		Node<E> newNode = new Node<E>(obj);
		//If adding the first 
		if (head == null){
			head = newNode;
			size ++;
			return true;
		}else if(tail == null){
			head.next = newNode;
			newNode.prev = head;
			tail = newNode;
			size ++;
			return true;
		}
		//Otherwise
		tail.next = newNode;
		newNode.prev = tail;
		tail = newNode;
		size ++;
		return true;
	}
	
	/**
	 * Adding to the beginning
	 * @param obj The data to add to the list
	 */
	public void addFirst(E obj){
		Node<E> newNode = new Node<E>(obj);
		//If list is empty
		if (head == null){
			head = newNode;
		}else{
			head.prev = newNode;
			newNode.next = head;
			head = newNode;
		}
		size ++;
	}
	
	/**
	 * Add to the end, cases are - 
	 * If empty list
	 * If tail is unfilled
	 * Otherwise
	 * @param obj
	 */
	public void addLast(E obj){
		Node<E> newNode = new Node<E>(obj);
		if(head == null){
			head = newNode;
		}else{
			if(tail == null){
				head.next = newNode;
				newNode.prev = head;
				tail = newNode;
			}else{
				tail.next = newNode;
				newNode.prev = tail;
				tail = newNode;
			}
		}
		size ++;
	}

	/**
	 * Get an object at the given index
	 * 
	 * @param index The index to get
	 */
	@Override
	public E get(int index) {
		return listIterator(index).next();
	}
	
	/**
	 * Return the first node's data
	 * @return The first node's data
	 */
	public E getFirst(){
		return head.data;
	}
	
	/**
	 * Return the last node's data
	 * @return The last node's data
	 */
	public E getLast(){
		return tail.data;
	}
	
	/**
	 * Set at the given index
	 * Cases are -
	 * Setting to null
	 * Otherwise
	 */
	@Override
	public E set(int index, E obj) {
		LinkedListIterator iterator = new LinkedListIterator(index);
		if (iterator.nextItem == null){
			throw new NoSuchElementException();
		}
		E oldData = iterator.nextItem.data;
		iterator.nextItem.data = obj;
		return oldData;
	}

	@Override
	/**
	 * Returns the size of the list
	 * 
	 * @return The size of the list
	 */
	public int size() {
		return this.size;
	}
	
	/**
	 * Return a list iterator at the start of the list
	 */
	@Override
	public ListIterator<E> listIterator() {
		return new LinkedListIterator(0);
	}

	/**
	 * Return a list iterator at the given index
	 */
	@Override
	public ListIterator<E> listIterator(int index) {
		return new LinkedListIterator(index);
	}
	
	/**
	 * Return the index of the first occurence of a given object in the list
	 * Don't need iterator here because its one sequential search through
	 * @param obj The object we are searching for
	 */
	@Override
	public int indexOf(Object obj) {
		/*
		int index = 0;
		Node<E> testNode = head;
		//If Empty list
		if (testNode == null){
			return -1;
		//if its the head node
		}else if (head.data.equals(obj)){
			return 0;
		}else{
			while(testNode.next != null){
				testNode = testNode.next;
				index += 1;
				if(testNode.data.equals(obj)){
					return index;
				}
			}
			return -1;
		}
		*/
		LinkedListIterator iterator = new LinkedListIterator(0);
		int index = 0;
		while(iterator.hasNext()){
			if(iterator.next().equals(obj)){
				return index;
			}
			//Only happens if not equal
			index++;
		}
		//If the object was never found as it was never returned
		return -1;
	}
	
	/** 
	 * Remove the first occurence of the given object
	 * @param obj The object we are trying to remove from the list
	 */
	@Override
	public boolean remove(Object obj) {
		int index = indexOf(obj);
		if (index == -1){
			return false;
		}
		LinkedListIterator iterator = new LinkedListIterator(index);
		//Removing head
		if(index == 0){
			head.next.prev = null;
			head = head.next;
		//Removing tail
		}else if(iterator.nextItem == tail){
			tail.prev.next = null;
			tail = tail.prev;
		}else{
			iterator.nextItem.next.prev = iterator.nextItem.prev;
			iterator.nextItem.prev.next = iterator.nextItem.next;
		}
		return true;
		
	}
	
	@Override
	public E remove(int index) {
		LinkedListIterator iterator = new LinkedListIterator(index);
		if (iterator.hasNext()){
			E returnVal = iterator.next();
			iterator.remove();
			return returnVal;
		}else{
			throw new IllegalStateException();
		}
	}
	
	/**
	 * Return if boolean is empty
	 * 
	 * @return If the size is 0 or not
	 */
	@Override
	public boolean isEmpty() {
		if (this.size == 0){
			return true;
		}
		return false;
	}
	
	/**
	 * a string representation of the double linked list
	 */
	public String toString(){
		String resultString = "";
		LinkedListIterator iterator = new LinkedListIterator(0);
		while(iterator.hasNext()){
			resultString += iterator.next();
			if(iterator.hasNext()){
				resultString += " <=> ";
			}
		}
		return resultString;
	}
	
	/**
	 * a string representation of the double linked list that takes
	 * a custom delimeter
	 * 
	 * Actually don't need the iterator object because we just traverse
	 * through one way, never the other way and never need to keep our
	 * position.
	 * @param delimeter The delimeter to print between nodes
	 */
	public String toString(String delimeter){
		Node<E> tempNode = head;
		if (head == null){
			return "";
		}
		String resultString = "";
		resultString += head.data;
		//LinkedListIterator iterator = new LinkedListIterator(0);
		while (tempNode.next != null){
			resultString += delimeter;
			tempNode = tempNode.next;
			resultString += tempNode.data;
		}
		return resultString;
	}

	
	
	/**
	 * Node inner class
	 * Holds data for data, previous and next node references
	 */
	private static class Node<E>{
		private E data;
		private Node<E> next = null;
		private Node<E> prev = null;
		
		/**
		 * Create the node given data
		 * 
		 * @param data The data to store
		 */
		private Node(E data){
			this.data = data;
		}
	}
	
	
	/**
	 * Iterator inner class to implement ListIterator interface
	 */
	private class LinkedListIterator implements ListIterator<E>{
		private Node<E> nextItem;
		private Node<E> lastItemReturned;
		private int index = 0;
		
		/**
		 * Construct the iterator at the given index
		 * 
		 * @param i The index to move the iterator to
		 */
		public LinkedListIterator(int i){
			// Validate i parameter.
            if (i < 0 || i > size) {
                throw new IndexOutOfBoundsException(
                        "Invalid index " + i);
            }
            lastItemReturned = null; // No item returned yet.
            // Special case of last item.
            if (i == size) {
                index = size;
                nextItem = null;
            } else { // Start at the beginning
                nextItem = head;
                for (index = 0; index < i; index++) {
                    nextItem = nextItem.next;
                }
            }
            
		}
		
		/**
		 * Create a new iterator given an old iterator
		 * 
		 * @param other The old iterator to copy from
		 */
		public LinkedListIterator(LinkedListIterator other){
			LinkedListIterator iter = new LinkedListIterator(0);
			iter.index = other.index;
			iter.lastItemReturned = other.lastItemReturned;
			iter.nextItem = other.nextItem;
		}
		
		/**
		 * Return if there is a nextItem 
		 * return Boolean indicating if there is a next item
		 */
		@Override
		public boolean hasNext(){
			if (nextItem == null){
				return false;
			}else{
				return true;
			}
		}
		
		/**
		 * Return the next item in the list, throw
		 * exception if it does not exist
		 * @return The data of the next object
		 */
		@Override
		public E next(){
			if(hasNext()){
				lastItemReturned = nextItem;
				nextItem = nextItem.next;
				index += 1;
				return lastItemReturned.data;
			}else{
				throw new NoSuchElementException();
			}
		}
		
		
		@Override
		public boolean hasPrevious(){
			return (nextItem == null && size != 0)
                    || nextItem.prev != null;
		}
		
		/**
		 * Gives the index of the object which will be returned by next
		 * @return The index of the object which will be returned by next
		 */
		@Override
		public int nextIndex(){
			return index;
		}
		
		/**
		 * Returned by the index of the item returned by previous
		 * @return The integer index of the item returned by the previous
		 */
		@Override
		public int previousIndex(){
			return index - 1;
		}
		
		/**
		 * return the previous node
		 * @return the previous node
		 */
		@Override
		public E previous(){
			if(hasPrevious() == false){
				throw new NoSuchElementException();
			}
			//When the iterator is past the list, move back to the end of the list
			if(nextItem == null){
				nextItem = tail;
			//If within the list
			}else{
				nextItem = nextItem.prev;
			}
			lastItemReturned = nextItem;
			index--;
			return lastItemReturned.data;
		}
		
		/**
		 * Add an object into the array where the iterator is
		 * 
		 * @param obj The object to add at the index
		 */
		@Override
		public void add(E obj){
			//If adding to an empty list
			if(head == null){
				head = new Node<E>(obj);
				tail = head;
			//We are before the head so we want to make a new head
			} else if (nextItem == head){
				Node<E> newNode = new Node<E>(obj);
				newNode.next = nextItem;
				nextItem.prev = newNode;
				head = newNode;
			//If we are at the end, add to the end
			} else if (nextItem == null){
				Node<E> newNode = new Node<E>(obj);
				tail.next = newNode;
				newNode.prev = tail;
				tail = newNode;
			} else{
				Node<E> newNode = new Node<E>(obj);
				newNode.prev = nextItem.prev;
				nextItem.prev.next = newNode;
				newNode.next = nextItem;
				nextItem.prev = newNode;
			}
			size++;
			index++;
			lastItemReturned = null;
		}

		/**
		 * Remove the lastItemReturned
		 */
		@Override
		public void remove() {
			//The iterator has never had next called or remove has already been called
			if(lastItemReturned != null){
				//If removing the head
				if(lastItemReturned.prev == null){
					//Cut the reference to it
					lastItemReturned.next.prev = null;
					//New head
					head = lastItemReturned.next;
				//Removing the tail
				}else if(lastItemReturned.next == null){
					lastItemReturned.prev.next = null;
					//New tail
					tail = lastItemReturned.prev;
				//If removing anything in the middle of the list
				}else{
					lastItemReturned.prev.next = nextItem;
					nextItem.prev = lastItemReturned.prev;
				}
			}else{
				throw new IllegalStateException();
			}
			
		}
		
		/**
		 * Set the data for the lastItemReturned
		 */
		@Override
		public void set(E data) {
			lastItemReturned.data = data;
			
		}
	}//End of LinkedListIterator class
	
	
	
	
	
	
	
	
	
	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int lastIndexOf(Object arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean removeAll(Collection<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<E> subList(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T[] toArray(T[] arg0) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public boolean addAll(Collection<? extends E> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAll(int arg0, Collection<? extends E> arg1) {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean contains(Object arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}
}
