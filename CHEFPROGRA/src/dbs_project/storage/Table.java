package dbs_project.storage;

import dbs_project.abstraction.Relation;
import dbs_project.structures.DataStructure;
import dbs_project.util.annotation.NotNull;
import dbs_project.exceptions.ColumnAlreadyExistsException;
import dbs_project.exceptions.NoSuchColumnException;
import dbs_project.exceptions.NoSuchRowException;
import dbs_project.exceptions.SchemaMismatchException;
import org.apache.commons.collections.primitives.IntIterator;

/**import org.apache.commons.collections.primitives.IntIterator;
*/

/**
 * Interface for a relation in the database.
 */
public interface Table extends Relation {

    /**
     * Sets the name of specified column
     *
     * @param columnId
     *            Unique id of the column to rename
     * @param newColumnName
     *            New name
     * @throws ColumnAlreadyExistsException
     *             ColumnAlreadyExistsException
     * @throws NoSuchColumnException
     *             NoSuchColumnException
     */
    void renameColumn(int columnId, @NotNull String newColumnName)
            throws ColumnAlreadyExistsException, NoSuchColumnException;

    /**
     * Add a new, empty column to a table. Values are initialized as null.
     *
     * @return Column id that is unique within this table to adress the new column
     *
     * @param columnName
     *            Column name
     * @param columnType
     *            Column type
     * @throws ColumnAlreadyExistsException
     *             Column with the same name already exists in the table
     */
    int createColumn(@NotNull String columnName, @NotNull Type columnType)
            throws ColumnAlreadyExistsException;

    /**
     * Inserts a row in this table
     *
     * @param row
     *            New row
     * @return Row ID that is unique in for this table (can be useful for
     *         indexing later on)
     * @throws SchemaMismatchException
     *             Schema of supplied row does not match that of table
     */
    int addRow(@NotNull Row row) throws SchemaMismatchException;

    /**
     * Inserts rows in this table
     *
     * @param row
     *            New row
     * @return Row ID that is unique for this table (can be useful for
     *         indexing later on)
     * @throws SchemaMismatchException
     *             Schema of supplied row does not match that of table
     */
    @NotNull
    IntIterator addRows(@NotNull RowCursor rows) throws SchemaMismatchException;
    
    /**
     * Inserts a column in this table, named and typed as described in its 
     * meta data. 
     * 
     * Number of values in the column have to match the number of rows in the 
     * table, if the table is not empty.
     *
     * @param column
     *            New column
     * @return Column ID that is unique for this table (can be useful for
     *         indexing later on)
     * @throws SchemaMismatchException
     *             Schema of supplied column does not match that of table
     * @throws ColumnAlreadyExistsException
     *             Column with the same name already exists in the table
     */
    int addColumn(@NotNull Column column) throws SchemaMismatchException, ColumnAlreadyExistsException;

    /**
     * Inserts columns in this table, named and typed as described in their 
     * meta data. 
     * 
     * Number of values in all columns have to match the number of rows in the 
     * table, if the table is not empty.
     *
     * @param columns
     *            New columns
     * @return Column IDs that are unique in for this table (can be useful for
     *         indexing later on)
     * @throws SchemaMismatchException
     *             Schema of at least one supplied column does not match that of table
     * @throws ColumnAlreadyExistsException
     *             Column with the same name already exists in the table
     */
    @NotNull
    IntIterator addColumns(@NotNull ColumnCursor columns) throws SchemaMismatchException, ColumnAlreadyExistsException;

    /**
     * Delete matching rows
     *
     * @param rowID
     *            DeprecatedRow ID of row to be deleted
     *
     * @throws NoSuchRowException
     *             DeprecatedRow does not exist
     */
    void deleteRow(int rowID) throws NoSuchRowException;

    /**
     * Delete matching rows
     *
     * @param rowID
     *            DeprecatedRow ID of row to be deleted
     *
     * @throws NoSuchRowException
     *             DeprecatedRow does not exist
     */
    void deleteRows(@NotNull IntIterator rowIDs) throws NoSuchRowException;

    /**
     *
     * Drop a column
     *
     * @param columnId
     *            Id of the column to drop
     * @throws NoSuchColumnException
     *             NoSuchColumn
     */
    void dropColumn(int columnId)
            throws NoSuchColumnException;

    /**
     *
     * Drop a column
     *
     * @param columnId
     *            Id of the column to drop
     * @throws NoSuchColumnException
     *             NoSuchColumn
     */
    void dropColumns(@NotNull IntIterator columnIds)
            throws NoSuchColumnException;

    /**
     *
     * Get a reference to a column
     *
     * @param columnId
     *            Id of the column
     * @return A reference to the column
     * @throws NoSuchColumnException
     *             The requested column does not exist
     */
    @NotNull
    Column getColumn(int columnId)
            throws NoSuchColumnException;

    /**
     * @return Collection of all column instances in this table with the given Ids
     * @throws NoSuchColumnException
     *             One of the requested columns does not exist
     */
    @NotNull
    ColumnCursor getColumns(@NotNull DataStructure type, @NotNull IntIterator columnIds) throws NoSuchColumnException;

    /**
     * @param rowIds
     *            The ids of the requested rows
     * @return An operator that supplies the rows
     * @throws NoSuchRowExcception
     *          A row for on of the given ids does not exist
     */
    @NotNull
    RowCursor getRows(@NotNull DataStructure type, @NotNull IntIterator rowIds) throws NoSuchRowException;

    /**
     * 
     * @param rowId
     *          id of the requested row
     * @return the requested row
     * @throws NoSuchRowExcception
     *          A row for the given id does not exist
     */
    @NotNull
    Row getRow(int rowId) throws NoSuchRowException;

    /**
     *
     * Update a row with matching id using supplied values
     *
     * @param rowID
     *            If of row to be updated
     * @param newRow
     *            New row
     * @throws SchemaMismatchException
     *             Schema of supplied row does not match that of table
     * @throws NoSuchRowException
     *             Referenced row does not exist
     */
    void updateRow(int rowID, @NotNull Row newRow)
            throws SchemaMismatchException, NoSuchRowException;

    /**
     *
     * Update rows with matching Ids using supplied rows. #ids == #rows!
     *
     * @param rowIDs
     *            IDs of rows to be updated
     * @param newRows
     *            New rows
     * @throws SchemaMismatchException
     *             Schema of supplied rows does not match that of table
     * @throws NoSuchRowException
     *             Referenced row does not exist
     */
    void updateRows(@NotNull IntIterator rowIDs, @NotNull RowCursor newRows)
            throws SchemaMismatchException, NoSuchRowException;
    
    /**
     *
     * Update columns with matching Ids using supplied columns. #ids == #columns!
     * 
     * Number of values in the update columns have to match the number of values 
     * in the other columns, if other columns exist.
     *
     * @param columnIDs
     *            IDs of columns to be updated
     * @param updateColumns
     *            New columns
     * @throws SchemaMismatchException
     *             Schema of supplied rows does not match that of table
     * @throws NoSuchColumnException
     *             Referenced column does not exist
     */
    void updateColumns(@NotNull IntIterator columnIDs, @NotNull ColumnCursor updateColumns)
            throws SchemaMismatchException, NoSuchColumnException;

    /**
     *
     * Update a complete column with matching Id using supplied values.
     * 
     * Number of values in the update column have to match the number of values 
     * in the other columns, if other columns exist.
     *
     * @param columnId
     *            ID of column to be updated
     * @param updateColumn
     *            New column
     * @throws SchemaMismatchException
     *             Schema of supplied column does not match that of table
     * @throws NoSuchColumnException
     *             Referenced column does not exist
     */
    void updateColumn(int columnId, @NotNull Column updateColumn)
            throws SchemaMismatchException, NoSuchColumnException;

    /**
     *
     * @return Meta data that describes the table
     */
    @NotNull
    TableMetaData getTableMetaData();
}
