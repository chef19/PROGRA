package dbs_project.structures;

import dbs_project.structures.LinearDataStructure;

/**
 * This interface represents the Queue1 data structure (as seen in class).
 * 
 * @author Isaac Alpizar Chacon
 *
 * @param <T>
 */
public interface Queue<T> extends LinearDataStructure<T> {
	
	public void enqueue(T element);
	
	T dequeue();
	
	T first();
	
	int size();
	
	void clear();
	
	String toString();
	
}
