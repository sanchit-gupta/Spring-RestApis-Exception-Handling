package main.globalexception;


import main.enums.ErrorMessageEnum;

public class GenericException extends RuntimeException {

	private static final long serialVersionUID = -7545506317146446892L;
	
	public static ErrorMessageEnum errorMsg = ErrorMessageEnum.GENERIC_EXCEPTION;
	public String message;

	public GenericException() {
		super(errorMsg.getHttpStatus().getReasonPhrase());
	}

	public GenericException(ErrorMessageEnum errorMsg) {
		super(errorMsg.getHttpStatus().getReasonPhrase());
		GenericException.errorMsg = errorMsg;
	}

	public GenericException(ErrorMessageEnum errorMsg, Object[] args) {
		super(errorMsg.getHttpStatus().getReasonPhrase());
		errorMsg.setArgs(args);
		GenericException.errorMsg = errorMsg;
	}

	public GenericException(String message) {
		super(message);
		this.message = message;
	}

	@Override
	public String toString() {
		return "ERROR MESSAGE >>>>> " + errorMsg + ", MESSAGE >>>>> " + message;
	}

}
