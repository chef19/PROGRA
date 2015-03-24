package dbs_project.storage;

import dbs_project.abstraction.GenericLinearReadAccessible;
import dbs_project.util.annotation.NotNull;

/**
 * Column. Provides access through the GenericLinearReadAccessible interface.
 */
public interface Column extends GenericLinearReadAccessible {

    /**
     * Delivers information and properties for this Column.
     * @return Meta data about this column.
     */
    @NotNull
    ColumnMetaData getMetaData();
    
    
}
