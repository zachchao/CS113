package edu.miracosta.cs113;

public interface Map<K, V> {
	
	public V get(K key);
	public boolean isEmpty();
	public V put (K key, V value);
	public V remove(K key);
	public int size();
}
