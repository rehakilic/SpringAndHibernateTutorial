package com.spring.RestfulWebService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api")
public class TestService {

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String test () {
        return "rest service test";
    }
}
