package edu.miracosta.cs113;

public class Entry<K, V> {
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
