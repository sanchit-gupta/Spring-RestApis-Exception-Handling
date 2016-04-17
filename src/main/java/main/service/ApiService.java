package main.service;

import main.exception.InvalidParamException;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class ApiService {

    public Map saveToDB(String id) {
        System.out.println("from service id : " + id);
//        Map map = new HashMap();
//        map.put("id ",id);
//        return map;
        throw new InvalidParamException("Invalid params found as id : " + id);
    }
}
