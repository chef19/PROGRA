package dbs_project.exceptions;

/**
 * Thrown if a query execution fails. Should deliver the cause whenever possible.
 */
public class QueryExecutionException extends Exception {

	/**
	 * 
	 */
	public QueryExecutionException() {
		super();
	}

	/**
	 * @param message
	 * @param cause
	 */
	public QueryExecutionException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param message
	 */
	public QueryExecutionException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public QueryExecutionException(Throwable cause) {
		super(cause);
	}
}
