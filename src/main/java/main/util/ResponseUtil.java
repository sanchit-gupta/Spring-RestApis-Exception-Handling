package main.util;

import main.dto.ErrorResponseDto;
import main.dto.Response;
import main.dto.ResponseDto;
import main.dto.SuccessResponseDto;
import main.enums.SuccessMessageEnum;
import main.globalexception.GenericException;
import main.locale.MessageByLocale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class ResponseUtil implements Response {
	
	@Autowired
	private MessageByLocale messsageByLocale;

	@SuppressWarnings("rawtypes")
	@Override
	public HttpEntity<ResponseDto> successResponse(Object data, SuccessMessageEnum successMsg) {
		@SuppressWarnings("unchecked")
		ResponseDto responseDto = new SuccessResponseDto(data, successMsg.getHttpStatus());
//		responseDto.setMessage(messsageByLocale.getSuccessMessage(successMsg));
		responseDto.setMessage("messsageByLocale.getSuccessMessage(successMsg)");
		return httpResponse(responseDto);
	}

	@Override
	public HttpEntity<ResponseDto> errorResponse(GenericException exception) {
//		ResponseDto responseDto = new ErrorResponseDto(exception,messsageByLocale.getErrorMessage(exception.errorMsg));
		ResponseDto responseDto = new ErrorResponseDto(exception,"messsageByLocale.getErrorMessage(exception.errorMsg)");
        return httpResponse(responseDto);
	}

	@Override
	public HttpEntity<ResponseDto> httpResponse(ResponseDto responseDto) {
		return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.valueOf(responseDto.getCode()));
	}

	@Override
	public HttpEntity<ResponseDto> throwableErrorResponse(Throwable exception) {
		ResponseDto responseDto = new ErrorResponseDto(HttpStatus.NOT_IMPLEMENTED);
        return httpResponse(responseDto);
	}
	
}
