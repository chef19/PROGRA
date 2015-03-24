package dbs_project.storage;

import dbs_project.abstraction.Identifiable;
import dbs_project.abstraction.Named;
import dbs_project.util.annotation.NotNull;
import dbs_project.util.annotation.Nullable;

/**
 * Provides information and properties for this column.
 * Name and id have to be at least unique within a certain table.
 * (but you can even use unique column ids throughout the system if you want).
 */
public interface ColumnMetaData extends Identifiable, Named {

    /**
     *
     * @return number of values in this column (if known or negative value otherwise)
     */
    int getRowCount();

    /**
     * @return The table that this column belongs to or null if it does not
     * belong to a table
     */
    @Nullable
    Table getSourceTable();

    /**
     *
     * @return Label for this column or source table name + . + column name, 
     * if the column was not explicitly labeled (like in: select xyz as label ...)
     */
    @NotNull
    String getLabel();

    /**
     *
     * @return Type of the values in this column
     */
    @NotNull
    Type getType();
    
    
    /**
     * translates the column index for getXXX methods to a row id
     * This is e.g. needed for tuple reconstruction when using add/updateColumn()
     * 
     * @param positionInColumn [0,#rows-1]
     * @return the id of the row that the value at the given position belongs to.
     */
    int getRowId(int positionInColumn) throws IndexOutOfBoundsException;

}
