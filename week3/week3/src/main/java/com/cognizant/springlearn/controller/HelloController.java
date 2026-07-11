// Week 3 / 2. spring-rest-handson / "Hello World RESTful Web Service"
package com.cognizant.springlearn.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// Method: GET
// URL: /hello
// Sample Request: http://localhost:8090/hello
// Sample Response: Hello World!!
@RestController
public class HelloController {

    private static final Logger LOGGER = LoggerFactory.getLogger(HelloController.class);

    @GetMapping("/hello")
    public String sayHello() {
        LOGGER.info("Start");
        String message = "Hello World!!";
        LOGGER.info("End");
        return message;
    }

}
