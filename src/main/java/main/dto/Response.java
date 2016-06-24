package main.dto;

import main.enums.SuccessMessageEnum;
import main.globalexception.GenericException;
import org.springframework.http.HttpEntity;

public interface Response {

	public HttpEntity<ResponseDto> httpResponse(ResponseDto responseDto);

	public HttpEntity<ResponseDto> successResponse(Object data, SuccessMessageEnum successMsg);

	public HttpEntity<ResponseDto> errorResponse(GenericException exception);
	
	public HttpEntity<ResponseDto> throwableErrorResponse(Throwable exception);

}
