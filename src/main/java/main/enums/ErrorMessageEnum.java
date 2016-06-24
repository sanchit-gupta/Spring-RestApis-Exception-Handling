package main.enums;

import org.springframework.http.HttpStatus;

public enum ErrorMessageEnum {

	GENERIC_EXCEPTION(HttpStatus.INTERNAL_SERVER_ERROR, "generic.exception", null,"0"),
	NOT_AUTHORIZED(HttpStatus.UNAUTHORIZED, "not.authorized", null,"0" ),
	BLOCKED(HttpStatus.BAD_REQUEST, "user.block", null,"4" ),
	BAD_REQUEST(HttpStatus.BAD_REQUEST, "BAD_REQUEST",null,"400");

	HttpStatus httpStatus;
	String messageCode;
	Object[] args;
	String status = "0";

	ErrorMessageEnum(HttpStatus httpStatus, String messageCode, Object[] args, String status) {
		this.httpStatus = httpStatus;
		this.messageCode = messageCode;
		this.args = args;
		this.status = status;
	}

	public String getMessageCode() {
		return messageCode;
	}

	public void setMessageCode(String messageCode) {
		this.messageCode = messageCode;
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	public void setHttpStatus(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}

	public Object[] getArgs() {
		return args;
	}

	public void setArgs(Object[] args) {
		this.args = args;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	

}
