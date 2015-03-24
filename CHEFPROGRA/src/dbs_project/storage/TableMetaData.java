package dbs_project.storage;

import dbs_project.abstraction.Identifiable;
import dbs_project.abstraction.Named;
import dbs_project.util.annotation.NotNull;
import java.util.Map;

/**
 * Provides information and properties for a table.
 */
public interface TableMetaData extends Identifiable, Named {

    /**
     *
     * @return the schema for the table (column name -> column meta data, no ordering assumed)
     */
    @NotNull
    Map<String, ColumnMetaData> getTableSchema();

    /**
     * 
     * @return number of rows in the table if known, or negative value otherwise
     */
    int getRowCount();

}
