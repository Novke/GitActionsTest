package rs.fon.silab.exception;

public class ExamException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1642609340886113711L;

	public ExamException() {
		super();
	}

	public ExamException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public ExamException(String message, Throwable cause) {
		super(message, cause);
	}

	public ExamException(String message) {
		super(message);
	}

	public ExamException(Throwable cause) {
		super(cause);
	}

}
