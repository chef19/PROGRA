package dbs_project.abstraction;

import dbs_project.storage.ColumnCursor;
import dbs_project.storage.RowCursor;
import dbs_project.util.annotation.NotNull;
import dbs_project.structures.DataStructure;


/**
 *
 * Abstraction of a relation, consisting of read accessible columns and rows.
 * 
 */
public interface Relation {

    /**
     * @return cursor that supplies the rows of the relation
     */
    @NotNull
    RowCursor getRows(DataStructure type);
    
    /**
     * @return  cursor that supplies the rows of the relation
     */
    @NotNull
    ColumnCursor getColumns(DataStructure type);

    
}
