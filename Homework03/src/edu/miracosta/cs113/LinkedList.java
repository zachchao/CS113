package edu.miracosta.cs113;

/**
 *LinkedList.java Creates a custom linked list class
 *
 *Class Invariant : None
 *
 *@author   Zachary Chao <zach.chao@yahoo.com> (A lot taken from Nery Chapeton-Lamas)
 *@version  1.0
 *   
 */
public class LinkedList <E>{
	private Node <E> head = null;
	private int size = 0;
	
	/**
	 * Gets the size
	 * 
	 * @return size
	 */
	public int getSize(){
		return size;
	}
	
	/**
	 * Gets the data from the node given the index
	 * @param index the index of the node to get
	 * 
	 * @return the data of the node
	 */
	public E get(int index){
		if(index < 0 || index > size){
			throw new IndexOutOfBoundsException(Integer.toString(index));
		}
		if (getNode(index) == null){
			return null;
		}
		return getNode(index).data;
	}
	
	/**
	 * Allows removal from the list given an index
	 * 
	 * @param index The index of the node to remove
	 * 
	 * @return returns The deleted node's data
	 */
	public E remove(int index) {
		if (index < 0 || index > size || size == 0){
			throw new IndexOutOfBoundsException(Integer.toString(index));
		//If removing the head
		}else if (index == 0){
			Node<E> oldHead = head;
			head = oldHead.link;
			return oldHead.data;
		}else{
			Node<E> current = getNode(index);
			//If removing the last node just drop the link
			if (getNode(index+1) == null){
				getNode(index-1).link = null;
				return current.data;
			}else{
				getNode(index-1).link = current.link;
				return current.data;
			}
		}
	}
	
	/**
	 * Public setter for the linked list
	 * 
	 * @param index The index to set the new data
	 * @param newData The new data to set into the node
	 * 
	 * @return The data fo the node that was deleted
	 */
	public E set(int index, E newData){
		if(index < 0 || index > size){
			throw new IndexOutOfBoundsException(Integer.toString(index));
		}
		Node<E> node = getNode(index);
		E oldData = node.data;
		node.data = newData;
		return oldData;
	}
	
	/**
	 * Allows the user to add a new data to the linked list
	 * 
	 * @param index The index of where to add the new data
	 * @param item The new data to be added
	 * 
	 * @return None
	 */
	public void add(int index, E item){
		if(index == 0){
			addFirst(item);
		}else if(index < 0 || index > size){
			throw new IndexOutOfBoundsException(Integer.toString(index));
		}else{
			Node<E> node = getNode(index - 1);
			addAfter(node, item);
		}
	}
	
	/**
	 * Add an item at the end of the list
	 * 
	 * @param item The data to add to the list
	 * 
	 * @return True always because it overrides List interface
	 */
	public boolean add(E item){
		add(size, item);
		return true;
	}
	
	/**
	 * Private method to add to the beginning of the list
	 * 
	 * @param data The new data to add to the head
	 * 
	 * @return None
	 */
	private void addFirst(E data){
		head = new Node<E>(data, head);
		size ++;
	}
	
	/**
	 * Add after a given node
	 * 
	 * @param node The node to add after
	 * @param item The data to add
	 * 
	 * @return None
	 */
	private void addAfter(Node<E> node, E item){
		node.link = new Node<E>(item, node.link);
		size ++;
	}
	
	/**
	 * Removes a node after a given node
	 * 
	 * @param node The node which's next node should be removed
	 * 
	 * @return The removed data
	 */
	private E removeAfter(Node<E> node){
		if (node != null){
			Node<E> temp = node.link;
			node.link = temp.link;
			size --;
			return temp.data;
		}else{
			return null;
		}
	}
	
	/**
	 * Removes the head node
	 * 
	 * @return The head nodes data
	 */
	private E removeFirst(){
		if (head == null){
			return null;
		}else{
			Node<E> temp = head;
			head = head.link;
			size--;
			return temp.data;
		}
	}
	
	/**
	 * toString method for turning the list into a string
	 * 
	 * @return a string representing the linkedList
	 */
	@Override
	public String toString(){
		Node<E> node = head;
		String result = "";
		while(node != null){
			result += node.data;
			if(node.link != null){
				result += " => ";
			}
			node = node.link;
		}
		return result;
	}
	
	/**
	 * toString method for custom delimiter
	 * 
	 * @return a string representing the linkedList with a delimiter
	 */
	public String toString(String delim){
		Node<E> node = head;
		String result = "";
		while(node != null){
			result += node.data;
			if(node.link != null){
				result += delim;
			}
			node = node.link;
		}
		return result;
	}
	
	/**
	 * Gets the node given an index
	 * 
	 * @param index The index of the node to retrieve
	 * 
	 * @return The node at the given index
	 */
	private Node<E> getNode(int index){
		Node<E> node = head;
		int i = 0;
		while(i < index && node != null){
			node = node.link;
			i++;
		}
		return node;
	}
	
	/**
	 *Private inner Node class for holding data and a link to a new node
	 *
	 *Class Invariant : None
	 *
	 *@author   Zachary Chao <zach.chao@yahoo.com>
	 *@version  1.0
	 *
	 */
	private class Node <E>{
		private Node <E> link;
		private E data;
		
		/** 
		 * Creates a new node with a null text field aka tail node
		 * 
		 * @param data The data stored
		 * 
		 * @return None
		 */
		private Node(E data){
			this.data = data;
			this.link = null;
		}
		
		/**
		 * Creates a new node that references another node
		 * 
		 * @param data The data stored
		 * @param link The node referenced by the new node
		 * 
		 * @return None
		 */
		private Node(E data, Node <E> link){
			this.data = data;
			this.link = link;
		}
	}
}
