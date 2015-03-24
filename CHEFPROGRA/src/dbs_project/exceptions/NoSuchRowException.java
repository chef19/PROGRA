package dbs_project.exceptions;

/**
 * Thrown if the table does not contain a requested column.
 */
public class NoSuchRowException extends Exception {
	/**
	 * 
	 */
	public NoSuchRowException() {
		super();
	}

	/**
	 * @param message
	 * @param cause
	 */
	public NoSuchRowException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param message
	 */
	public NoSuchRowException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public NoSuchRowException(Throwable cause) {
		super(cause);
	}
}
