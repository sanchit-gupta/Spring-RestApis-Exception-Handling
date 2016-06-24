package main.enums;

import org.springframework.http.HttpStatus;

public enum SuccessMessageEnum {
	
	SUCCESS(HttpStatus.OK, "chat.joined.successfully", null),
	CHAT_JOINED_SUCESSFULLY(HttpStatus.OK, "chat.joined.successfully", null),
	LEAVE_CHAT_SUCESSFULLY(HttpStatus.OK, "leave.chat.successfully", null),
	BEAM_LIKED_SUCCESSFULLY(HttpStatus.OK, "beam.liked.successfully", null),
	BEAM_DISLIKED_SUCCESSFULLY(HttpStatus.OK, "beam.disliked.successfully", null),
	MESSAGE_SEND_SUCCESSFULLY(HttpStatus.OK, "message.send.successfully", null),
	PROFANITY_UPDATE_SUCCESS(HttpStatus.OK, "message.profanity.update.successfully", null),
	PROFANITY_UPDATE_FAILED(HttpStatus.BAD_REQUEST, "message.profanity.update.fail", null),
	PROFANITY_REMOVE_SUCCESS(HttpStatus.OK, "message.profanity.remove.successfully", null),
	PROFANITY_REMOVE_FAILED(HttpStatus.BAD_REQUEST, "message.profanity.remove.fail", null),
	EVENT_STATS_FROM_CACHE_SUSSESSFULLY(HttpStatus.OK, "eventStats.fetch.success", null),
	NON_LOGGED_IN_VIEWER_JOINED(HttpStatus.OK, "fameplus.event.viewer.join.nonlogined", null),
	LOGGED_IN_VIEWER_JOINED(HttpStatus.OK, "fameplus.event.viewer.join.logined", null);

	HttpStatus httpStatus;
	String messageCode;
	Object[] args;

	SuccessMessageEnum(HttpStatus httpStatus, String messageCode, Object[] args) {
		this.httpStatus = httpStatus;
		this.messageCode = messageCode;
		this.args = args;
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

	@Override
	public String toString() {
		return "httpStatus :: " + httpStatus + " messageCode :: " + messageCode + " args :: " + messageCode;
	}

}
