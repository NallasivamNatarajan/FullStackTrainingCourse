package com.material.management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.material.management.dto.UserDto;
import com.material.management.service.UserService;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@GetMapping (value = "/login",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserDto> getLoginDetails(@RequestParam ("username") String username,@RequestParam ("pass") String pass)
	{
		UserDto userDto=new UserDto();
		userDto.setPassword(pass);
		userDto.setUserName(username);
		UserDto userDto2 = userService.getUser(userDto);
		HttpHeaders headers = getHeaders("GET");
		
		if(userDto2!=null)
		{		
			return new ResponseEntity<UserDto> (userDto2,headers,HttpStatus.OK);
		}
		return null;
	}
	
	private HttpHeaders getHeaders(String post) {
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "application/json");
		headers.add("Access-Control-Allow-Orgin", "*");
		headers.add("Access-Control-Allow-Headers", "Origin, X-Requested-With,Content-Type,Accept");
		headers.add("Access-Control-Allow-Methods", post);
		return headers;
	}

}
