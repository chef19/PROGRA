package dbs_project.structures;


/**
 * This interface represents a common father for all 4 data structures.
 *
 * @author Isaac Alpízar Chacón
 *
 */
public interface LinearDataStructure<T> {
	 
	/**
     * This method returns the type of data structure used for its internal implementation. 
     * 
     * @return DataStructure that represents the internal data structure for this LinearDataStructure. 
     */
	DataStructure getType();
	
	int size();
	
	void clear();
	
	boolean isEmpty();
	
	String toString();
	
}
