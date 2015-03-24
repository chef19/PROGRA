package dbs_project.exceptions;

/**
 * Thrown if a column with the same name already exists in a table. 
 */
public class TableAlreadyExistsException extends Exception {

	/**
	 * 
	 */
	public TableAlreadyExistsException() {
		super();
	}

	/**
	 * @param message
	 * @param cause
	 */
	public TableAlreadyExistsException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param message
	 */
	public TableAlreadyExistsException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public TableAlreadyExistsException(Throwable cause) {
		super(cause);
	}
}
