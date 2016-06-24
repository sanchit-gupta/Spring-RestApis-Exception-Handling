package main.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.springframework.http.HttpStatus;

@JsonPropertyOrder({ "code", "status", "data", "message" })
public class SuccessResponseDto<T> implements ResponseDto {

	private String message;
	private int code = HttpStatus.OK.value();
	private String status = "1";
	private T data;

	public SuccessResponseDto() {
	}

	public SuccessResponseDto(T data, HttpStatus httpStatus) {
		this.data = data;
		this.code = httpStatus.value();
	}

	@Override
	public String getMessage() {
		return message;
	}

	@Override
	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public int getCode() {
		return this.code;
	}

	@Override
	public void setCode(int code) {
		this.code = code;
	}

	@Override
	public String getStatus() {
		return this.status;
	}

	@Override
	public void setStatus(String status) {
		this.status = status;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "SuccessResponseDto [message=" + message + ", code=" + code + ", status=" + status + ", data=" + data
				+ "]";
	}

}
