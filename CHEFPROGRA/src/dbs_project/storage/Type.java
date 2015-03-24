package dbs_project.storage;

import java.util.Date;

/**
 * This enum describes all data types you have to support in the project.
 * 
 * Hint: You can use enums in switch statements.
 */
public enum Type {
    //The supported types
    INTEGER(Integer.TYPE),
    DOUBLE(Double.TYPE),
    STRING(String.class),
    DATE(Date.class),
    BOOLEAN(Boolean.TYPE),
    OBJECT(Object.class);
    //
    private final Class<?> javaClass;

    private Type(Class<?> wrapperClass) {
        this.javaClass = wrapperClass;
    }

    /**
     *
     * @return corresponding java class for the type
     */
    public Class<?> getJavaClass() {
        return javaClass;
    }
}
