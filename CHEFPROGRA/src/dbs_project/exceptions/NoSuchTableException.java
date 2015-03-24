package dbs_project.exceptions;

/**
 * Thrown if the database does not contain a requested table.
 */
public class NoSuchTableException extends Exception {

	/**
	 * 
	 */
	public NoSuchTableException() {
		super();
	}

	/**
	 * @param message
	 * @param cause
	 */
	public NoSuchTableException(String message, Throwable cause) {
	}

	/**
	 * @param message
	 */
	public NoSuchTableException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public NoSuchTableException(Throwable cause) {
		super(cause);
	}
}
