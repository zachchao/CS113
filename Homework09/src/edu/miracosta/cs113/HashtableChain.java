package edu.miracosta.cs113;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.LinkedList;

public class HashtableChain<K, V> implements Map<K, V>{
	
	private LinkedList<Entry<K, V>>[] table;
	private int numKeys = 0;
	private static final int CAPACITY = 2;
	private static final int LOAD_THRESHOLD = 3;
	
	public HashtableChain(){
		table = new LinkedList[CAPACITY];
	}

	@Override
	public V put(K key, V value) {
		int index = key.hashCode() % table.length;
		
		if(index < 0){
			index = (((index*-1)/table.length) * table.length) + table.length + index;
		}
		
		if(table[index] == null){
			table[index] = new LinkedList<Entry<K, V>>();
		}
		
		//If the key already exists, replace it
		for(Entry<K, V> obj : table[index]){
			//Already exists
			if(obj.equals(key)){
				V temp = obj.getValue();
				obj.setValue(value);
				return temp;
			}
		}
		
		//Not Found
		table[index].addFirst(new Entry<K, V>(key, value));
		numKeys += 1;
		
		if(numKeys > (LOAD_THRESHOLD * table.length)){
			rehash();
		}
		return null;
	}
	
	private void rehash(){
		LinkedList<Entry<K, V>>[] newTable = new LinkedList[(table.length * 2) + 1];
		for(int i = 0; i < table.length; i++){
			for(Entry<K, V> obj : table[i]){
				int index = obj.key.hashCode() % newTable.length;

				if(index < 0){
					index = (((index*-1)/table.length) * table.length) + table.length + index;
				}
				
				if(newTable[index] == null){
					newTable[index] = new LinkedList<Entry<K, V>>();
				}
				
				newTable[index].addFirst(obj);
			}
		}
		table = newTable;
	}
	
	@Override
	public V get(K key) {
		int index = key.hashCode() % table.length;

		if(index < 0){
			index = (((index*-1)/table.length) * table.length) + table.length + index;
		}
		
		if(table[index] == null){
			return null;
		}
		
		//Search through the linkedlist for the object
		for(Entry<K, V> obj : table[index]){
			if(obj.key.equals(key)){
				return obj.value;
			}
		}
		
		//Not Found
		return null;
	}

	@Override
	public boolean isEmpty() {
		return numKeys == 0;
	}

	@Override
	public V remove(K key) {
		V value = null;
		int index = key.hashCode() % table.length;
		
		if(index < 0){
			index = (((index*-1)/table.length) * table.length) + table.length + index;
		}
		
		if(table[index] == null){
			return null;
		}
		
		int loc = 0;
		for(Entry<K, V> obj : table[index]){
			//Found the object
			if(obj.getKey().equals(key)){
				numKeys--;
				value = table[index].remove(loc).getValue();
				//Removed last item in LinkedList
				if(table[index].size() == 0){
					//Delete LinkedList
					table[index] = null;
				}
			}
			loc++;
		}
			
		return value;
	}

	@Override
	public int size() {
		return numKeys;
	}
	
	public String toString(){
		String returnString = "";
		for(int i = 0; i < table.length; i++){
			returnString += i + " : ";
			
			if(table[i] == null){
				returnString += "null";
			}else{
				for(Entry<K, V> obj : table[i]){
					returnString += obj.toString() + ", ";
				}
			}
			
			returnString += "\n";
		}
		
		return returnString;
	}
	
	
	private class EntrySet extends AbstractSet<HashtableChain<K, V>.Entry<K, V>>{

		@Override
		public Iterator<HashtableChain<K, V>.Entry<K, V>> iterator() {
			return new SetIterator();
		}

		@Override
		public int size() {
			return numKeys;
		}
		

	}

	
	private class SetIterator implements Iterator<Entry<K, V>>{
		private int index= 0;
		Iterator<Entry<K, V>> iterator = null;
		Entry<K, V> lastItemReturned = null;
		
		@Override
		public boolean hasNext() {
			if(this.iterator != null){
				if(this.iterator.hasNext()){
					return true;
				}else{
					this.iterator = null;
					index++;
				}
			}
			while(index < table.length && table[index] == null){
				index++;
			}
			if(index == table.length){
				return false;
			}
			this.iterator = table[index].iterator();
			return this.iterator.hasNext();
		}

		@Override
		public HashtableChain<K, V>.Entry<K, V> next() {
			if(hasNext()){
				lastItemReturned = this.iterator.next();
				return lastItemReturned;
			}else{
				return null;
			}
		}
		
		public void remove(){
			if(lastItemReturned != null){
				this.iterator.remove();
				lastItemReturned = null;
			}else{
				throw new IllegalStateException();
			}
		}
		
	}
	
	
	private class Entry<K, V> {
		private K key;
		private V value;
		
		public Entry(K key, V value){
			this.key = key;
			this.value = value;
		}
		
		public K getKey(){
			return this.key;
		}
		
		public V getValue(){
			return this.value;
		}
		
		public V setValue(V val){
			this.value = val;
			return this.getValue();
		}
	}
}
