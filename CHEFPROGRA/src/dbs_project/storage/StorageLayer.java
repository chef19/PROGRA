package dbs_project.storage;

import dbs_project.util.annotation.NotNull;
import dbs_project.exceptions.NoSuchTableException;
import dbs_project.exceptions.TableAlreadyExistsException;

import java.util.Map;

import dbs_project.structures.DataStructure;
import dbs_project.structures.LinearDataStructure;

/**
 * The storage layer of the database.
 */
public interface StorageLayer {

    /**
     * Create a new table
     *
     * @param tableName
     *            Name of the table to be created
     * @param schema
     *            Schema as map column name -> type
     *            
     * @param type
     * 			DataStructure type to be used to store the table's data internally. Just. DataStructure.LINKEDLIST and DataStructure.DOUBLYLINKEDLIST are valid!
     *
     * @return Unique id of the new table
     * @throws TableAlreadyExistsException
     *             Table with same name already in DB
     */
    int createTable(@NotNull String tableName, @NotNull Map<String, Type> schema, DataStructure type)
            throws TableAlreadyExistsException;

    /**
     * Delete a table
     *
     * @param tableID
     *            Unique id of the table to be deleted
     * @throws NoSuchTableException
     *             Table with given name does not exist
     */
    void deleteTable(int tableID) throws NoSuchTableException;

    /**
     * @param tableID
     *            Unique id of the table to be renamed
     * @param newName
     *            New table name
     * @throws TableAlreadyExistsException
     *             Table already exists
     * @throws NoSuchTableException
     *             No such table
     */
    void renameTable(int tableID, @NotNull String newName)
            throws TableAlreadyExistsException, NoSuchTableException;

    /**
     * @param tableID
     *            Unique id of the table
     * @return A reference to the table
     * @throws NoSuchTableException
     *             Table with given name does not exist
     */
    @NotNull
    Table getTable(int tableID) throws NoSuchTableException;

    /**
     * @return A collection providing references to all tables in the database. It uses a LinearDataStructure to store the references to
     * all the tables in the storage layer. 
     */
    @NotNull
    LinearDataStructure<? extends Table> getTables(DataStructure type);
    
    /**
     * 
     * @return Mapping table name -> table meta data for all tables in the db.  
     */
    @NotNull
    Map<String, TableMetaData> getDatabaseSchema();

}
