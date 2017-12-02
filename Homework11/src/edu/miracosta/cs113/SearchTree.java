package edu.miracosta.cs113;

public interface SearchTree<E> {
	public boolean add(E item);
	public E delete(E target);
	public E find(E target);
	public boolean contains(E item);
	public E remove(E target);
}
