package dbs_project.abstraction;

import dbs_project.util.annotation.NotNull;

/**
 * Interface for objects that have a name.
 */
public interface Named {

    /**
     *
     * @return Name of the object
     */
    @NotNull
    String getName();
}
