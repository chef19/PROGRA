package dbs_project.exceptions;

/**
 * Thrown if a column with the same name already exists in a table.
 */
public class ColumnAlreadyExistsException extends Exception {


	/**
	 * 
	 */
	public ColumnAlreadyExistsException() {
		super();
	}

	/**
	 * @param message
	 * @param cause
	 */
	public ColumnAlreadyExistsException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param message
	 */
	public ColumnAlreadyExistsException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public ColumnAlreadyExistsException(Throwable cause) {
		super(cause);
	}
}
