package com.springapp.mvc.test;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;
import java.util.Map;

@RestController
@RequestMapping("")
public class UserController extends BaseRestController{

	@RequestMapping(value="/user", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
	@ResponseStatus(HttpStatus.OK)
	public Map<String, Object> jsonUser() {

		Map<String, Object> result = new LinkedHashMap<String, Object>();
		result.put("name", "John");
		result.put("surname", "Doe");

		return result;

	}

	@RequestMapping(value="/exc", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
	@ResponseStatus(HttpStatus.OK)
	public void jsonException() {

		throw new RuntimeException();

	}
}