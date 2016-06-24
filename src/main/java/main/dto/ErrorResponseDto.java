package main.dto;

import main.globalexception.GenericException;
import org.springframework.http.HttpStatus;

import java.util.HashMap;
import java.util.Map;

public class ErrorResponseDto implements ResponseDto {

	private String message;
	private int code = HttpStatus.BAD_REQUEST.value();
	private String status = "0";
    private Map data;

	public ErrorResponseDto() {
	}

	public ErrorResponseDto(HttpStatus httpStatus) {
		this.code = httpStatus.value();
	}
	
	@SuppressWarnings("static-access")
	public ErrorResponseDto(GenericException exception, String message) {
		this.code = exception.errorMsg.getHttpStatus().value();
		this.status = exception.errorMsg.getStatus();
		this.message = message;
        this.data = new HashMap();
	}


	@Override
	public String getMessage() {
		return this.message;
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

    public Map getData() {
        return data;
    }

    public void setData(Map data) {
        this.data = data;
    }
}
