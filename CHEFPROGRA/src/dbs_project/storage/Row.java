package dbs_project.storage;

import dbs_project.util.annotation.NotNull;
import dbs_project.abstraction.GenericLinearReadAccessible;

/**
 * Row. Provides access through the GenericLinearReadAccessible interface.
 */
public interface Row extends GenericLinearReadAccessible {

    /**
     * Provides information and properties for this Row.
     * @return meta information about this row
     */
    @NotNull
    RowMetaData getMetaData();
}
