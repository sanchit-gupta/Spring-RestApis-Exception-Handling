package main.controller;

import main.service.ApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {

    @Autowired
    ApiService apiService;

    @RequestMapping("/rest/index")
    public HttpEntity index(String id) {

        return ResponseEntity.ok().body(apiService.saveToDB(id));
    }
}