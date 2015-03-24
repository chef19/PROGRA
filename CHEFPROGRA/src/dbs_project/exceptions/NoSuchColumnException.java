package dbs_project.exceptions;

/**
 * Thrown if the table does not contain a requested column.
 */
public class NoSuchColumnException extends Exception {

	/**
	 * 
	 */
	public NoSuchColumnException() {
		super();
	}

	/**
	 * @param message
	 * @param cause
	 */
	public NoSuchColumnException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param message
	 */
	public NoSuchColumnException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public NoSuchColumnException(Throwable cause) {
		super(cause);
	}
}
