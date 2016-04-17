package main.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
@RestController
public class GlobalExceptionHandler {

    @ExceptionHandler(value = CustomException.class)
    public Map<String, Object> handleInvalidParamException(InvalidParamException e) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("InvalidParamException", e.getMessage());
        map.put("errorMsg ", e.getMessage());
        map = addErrorCodeInResultMap(map);
        return map;
    }

    @ExceptionHandler(value = Exception.class)
    public Map<String, Object> handleException(Exception e) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("Error ", HttpStatus.INTERNAL_SERVER_ERROR.name());
        map.put("errorMsg ", e.getMessage());
        map.put("code", "1");
        e.printStackTrace();
        return map;
    }

    Map<String, Object> addErrorCodeInResultMap(Map<String, Object> map) {
        map.put("code", "0");
        return map;
    }

}