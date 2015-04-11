package dbs_project.abstraction;

import dbs_project.util.annotation.Nullable;

import java.util.Date;

import dbs_project.structures.DataStructure;
import dbs_project.structures.LinearDataStructure;

/**
 * This interface allows read access to linear data (array, column, row).
 * It allows access to primitive types without autoboxing.
 * 
 * Valid Java casts (e.g. double -> int) should be supported
 * without throwing a ClassCastException. However illegal casts (like int -> Date)
 * should result in a ClassCastException.
 *
 * Access to invalid indexes should throw an IndexOutOfBoundsException.
 *
 * Although theses are all RuntimeExceptions (for convenience in later use) and
 * the compiler will not force you to implement them, we will test correct behaviour.
 */
public interface GenericLinearReadAccessible {

    /**
     *
     * @param index - the first index is 0, the second is 1, ...
     * @return the value on this position; if the value is NULL, the value returned is Type.NULL_VALUE_INTEGER
     */
    Integer getInteger(int index) throws IndexOutOfBoundsException, ClassCastException;

    /**
     *
     * @param index - the first index is 0, the second is 1, ...
     * @return the value on this position; if the value is NULL, the value returned is Type.NULL_VALUE_BOOLEAN
     */
    Boolean getBoolean(int index) throws IndexOutOfBoundsException, ClassCastException;

    /**
     *
     * @param index - the first column is 0, the second is 1, ...
     * @return the value on this position; if the value is NULL, the value returned is Type.NULL_VALUE_DOUBLE
     */
    Double getDouble(int index) throws IndexOutOfBoundsException, ClassCastException;

    /**
     *
     * @param index - the first index is 0, the second is 1, ...
     * @return the value on this position
     */
    @Nullable
    Date getDate(int index) throws IndexOutOfBoundsException, ClassCastException;

    /**
     * This must work for all types.
     * If value is not instance of string, return it's String representation 
     * (For null this is String.valueOf(null))
     *
     * @param index - the first index is 0, the second is 1, ...
     * @return the value on this position
     */
    @Nullable
    String getString(int index) throws IndexOutOfBoundsException;

    /**
     * this works for all types
     *
     * @param index - the first index is 0, the second is 1, ...
     * @return the value on this position
     */
    @Nullable
    Object getObject(int index) throws IndexOutOfBoundsException;

    /**
     *
     * @param index - the first index is 0, the second is 1, ...
     * @return true if the value at this position is NULL and false otherwise
     */
    boolean isNull(int index) throws IndexOutOfBoundsException;
    
    /**
     * Returns the content of the GenericLinearReadAccessible 
     * represented as one of the four types of LinearDataStructure
     * 
     * @param type
     * @return An object LinearDataStructure<?>
     */
    LinearDataStructure<?> asLinearDataStructure(DataStructure type);
}
