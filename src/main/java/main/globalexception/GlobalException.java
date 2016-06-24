package main.globalexception;

import main.dto.Response;
import main.dto.ResponseDto;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalException extends Throwable{

	private static final long serialVersionUID = 7462824960611476789L;
	
	Logger log = LogManager.getLogger(GlobalException.class);
	
	@Autowired
    private Response response;


	@ExceptionHandler(Throwable.class)
    public HttpEntity<ResponseDto> handleThrowableError(Throwable e) {
        log.error("############ SOME EROR OCCURED ###############");
        log.error("REASON  "+ e.getMessage());
        e.printStackTrace();
        return response.throwableErrorResponse(e);
    }
}
