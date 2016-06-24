package main.controller;

import main.dto.Response;
import main.enums.SuccessMessageEnum;
import main.globalexception.BadRequestException;
import main.globalexception.UserBlockedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class MyExceptionController implements ErrorController {

    @Autowired
    private Response response;

    @RequestMapping("/rest/userBlock")
    public HttpEntity testException() {
        int x = 10/0;
        throw new UserBlockedException();
    }

    @RequestMapping("/rest/successResponse")
    public HttpEntity successResponse() {
        Map map = new HashMap();
        map.put("mykey","myvalue");
        return response.successResponse(map, SuccessMessageEnum.MESSAGE_SEND_SUCCESSFULLY);
    }

    @RequestMapping("/rest/errorResponse")
    public HttpEntity errorResponse() {
        return response.errorResponse(new UserBlockedException());

    }

    @RequestMapping("/error")
    public HttpEntity error() {
        Map map = new HashMap();
        map.put("statusCode","400 Bad Request");
        return response.errorResponse(new BadRequestException());

    }


    /**
     * Returns the path of the error page.
     *
     * @return the error path
     */
    @Override
    public String getErrorPath() {
        return "/error";
    }
}
