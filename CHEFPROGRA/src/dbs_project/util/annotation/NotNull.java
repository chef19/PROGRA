package dbs_project.util.annotation;

/**
 * Indicates that the annotated return-value or parameter is not allowed to be
 * null. If null is passed for a parameter annotated with this interface, you 
 * should consider throwing a NullpointerException.
 */
public @interface NotNull {
    
}
