package dbs_project.exceptions;

/**
 * Thrown if the Persistence layer tries to commit or rollback while no 
 * transaction is currently running.
 */
public class NoTransactionActiveException extends Exception {

	/**
	 * 
	 */
	public NoTransactionActiveException() {
		super();
	}

	/**
	 * @param message
	 * @param cause
	 */
	public NoTransactionActiveException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param message
	 */
	public NoTransactionActiveException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public NoTransactionActiveException(Throwable cause) {
		super(cause);
	}
}
