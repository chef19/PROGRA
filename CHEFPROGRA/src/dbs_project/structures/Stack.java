package dbs_project.structures;

import dbs_project.structures.LinearDataStructure;

/**
 * This interface represents the Stack data structure (as seen in class).
 * 
 * @author  Isaac Alpzar Chacn
 *
 * @param <T>
 */
public interface Stack<T> extends LinearDataStructure<T> {
	
	void push(T element);
	
	T pop();
	
	T top();
	
	int size();
	
	void clear();
	
	String toString();

}
