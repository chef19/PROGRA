package dbs_project.structures;

import dbs_project.structures.LinearDataStructure;

/**
 * This interface represents the Queue1 data structure (as seen in class).
 * 
 * @author Isaac Alp�zar Chac�n
 *
 * @param <T>
 */
public interface Queue<T> extends LinearDataStructure<T> {
	
	void enqueue(T element);
	
	T dequeue();
	
	T first();
	
	int size();
	
	void clear();
	
	String toString();
	
}
