package com.springapp.mvc.test;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

	@RequestMapping(value="/echo", method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Map<String, Object>> jsonException(@RequestHeader HttpHeaders headers,
															 @RequestBody Map<String, Object> body) {

		String userId = headers.getFirst("X-vnd-user-id");

		body.put("userId", userId);

		return new ResponseEntity<Map<String, Object>>(body, headers, HttpStatus.CREATED);
	}
}