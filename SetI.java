/*
 * SetI.java 
 * 
 * Version: 
 *       1 
 * 
 * Revisions: 
 *       2
 */

/**
 * This file describes the interface for MyHashSet class.
 *
 * @author      Soniya Rode
 * @author      Aishwarya Sontakke
 */

public interface SetI<E> {

	boolean	add(E e);
	void makeBuckets();
	void print();
	void printArray(Object[] Array);
	int	hashCode();
	int	size();
	void clear();
	boolean	isEmpty();
	boolean	contains(Object o);
	boolean	equals(Object o);
	boolean	addAll(SetI<? extends E> c);
	boolean	containsAll(SetI<?> c);
	boolean	removeAll(SetI<?> c);	
	boolean	remove(Object o);
	Object[] toArray();
}