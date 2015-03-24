package dbs_project.exceptions;

/**
 * Thrown if the persistens layer tries to begin a new transaction while
 * there is still a transaction running.
 * 
 */
public class TransactionAlreadyActiveException extends Exception {


	/**
	 * 
	 */
	public TransactionAlreadyActiveException() {
		super();
	}

	/**
	 * @param message
	 * @param cause
	 */
	public TransactionAlreadyActiveException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param message
	 */
	public TransactionAlreadyActiveException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public TransactionAlreadyActiveException(Throwable cause) {
		super(cause);
	}
}
