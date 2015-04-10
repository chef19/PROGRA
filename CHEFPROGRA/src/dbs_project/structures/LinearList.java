package dbs_project.structures;

import dbs_project.structures.LinearDataStructure;

/**
 * This interface represents a Linked List or Doubly Linked List data structure
 *  (as seen in class). All the methods are the same for both types. 
 * 
 * @author  Isaac Alpzar Chacn
 *
 * @param <T>
 */

public interface LinearList<T> extends LinearDataStructure<T> {
	
	void insert(T element);
	
	void append(T element);
	
	void remove();
	
	T getElement();
	
	/**
	 * 
	 * @return true, if the list moved to the next element. If the current
	 * element is the last one, it returns false.
	 */
	boolean next();
	
	/**
	 * 
	 * @return true, if the list moved to the previous element. If the current
	 * element is the first one, it returns false.
	 */
	boolean previous();
	
	int getPosition();
	
	void goToStart();
	
	void goToEnd();
	
	void goToPos(int pos) throws IndexOutOfBoundsException;
	
	int getPositionOfElement(T element);

}
