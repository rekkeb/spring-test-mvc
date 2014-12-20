package com.springapp.mvc.test;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class BaseRestController {

    private static final String MESSAGE = "message";
    private static final String CODE = "code";
    private static final String ERROR_LABEL = "error : ";

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<Map<String, String>> handlerException(Exception e) {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        Map<String, String> body = new HashMap<String, String>();
        body.put(CODE, HttpStatus.INTERNAL_SERVER_ERROR.toString());
//		body.put(MESSAGE, "");

        return new ResponseEntity<Map<String, String>>(body, headers, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}


