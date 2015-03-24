package dbs_project.exceptions;

/**
 * Thrown if data is to be inserted that somehow violates the table structure.
 * 
 * (e.g. columns or row count not matching)
 */
public class SchemaMismatchException extends Exception {

	/**
	 * 
	 */
	public SchemaMismatchException() {
		super();
	}

	/**
	 * @param message
	 * @param cause
	 */
	public SchemaMismatchException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param message
	 */
	public SchemaMismatchException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public SchemaMismatchException(Throwable cause) {
		super(cause);
	}
}
