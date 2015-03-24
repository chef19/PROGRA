package dbs_project.storage;

import dbs_project.abstraction.Identifiable;
import dbs_project.util.annotation.NotNull;

/**
 * Provides information and properties for this Row.
 */
public interface RowMetaData extends Identifiable {

    /**
     *
     * @return number of columns in the row
     */
    int getColumnCount();

    /**
     *
     * @param position of the column in the row [0, #columns[.
     * (this position is independent from the column id!)
     * @return Meta Data that describes the given column in the row
     * @throws IndexOutOfBoundsException
     */
    @NotNull
    ColumnMetaData getColumnMetaData(int positionInTheRow) throws IndexOutOfBoundsException;
}
