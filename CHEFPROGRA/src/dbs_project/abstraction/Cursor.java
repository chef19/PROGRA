package dbs_project.abstraction;

import dbs_project.structures.DataStructure;

/**
 * Interface for an object that allows iteration over a set of data by
 * changing it's interal values to represent the next dataset when next()
 * is called.
 * Cursors start one position *before* the first item (-1) and stop one
 * position *behind* the last.
 * ([-1, #items], first valid item has position 0).
 */
public interface Cursor {

    /**
     * Moves the cursor to the next position.
     *
     * @return true if the cursor was moved to a valid position
     * ([0, #item - 1])
     */
    boolean next();

    /**
     *
     * @return the current position of the cursor
     *
     * (intervall -1 <= position <= number of items)
     */
    int getCursorPosition();
    
    /**
     * Close the cursor and release all resources. After calling this method
     * calls to next() should return false.
     */
    void close();
    
    /**
     * This method returns the type of data structure used for its internal implementation. 
     * 
     * @return DataStructure that represents the internal data structure for this cursor. 
     */
    DataStructure getType();

}
