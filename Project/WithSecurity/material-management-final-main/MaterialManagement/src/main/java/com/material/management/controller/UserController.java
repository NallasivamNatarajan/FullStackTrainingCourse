package com.material.management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.material.management.dto.AuthRequestDto;
import com.material.management.dto.UserDto;
import com.material.management.service.UserService;
import com.material.management.util.JwtUtil;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@Autowired
    private JwtUtil jwtUtil;
   
    @Autowired
    private AuthenticationManager authenticationManager;
	
	@PostMapping(value = "/login",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserDto> getLoginDetails(@RequestBody AuthRequestDto authRequest){
		UserDto userDto=new UserDto();
		userDto.setPassword(authRequest.getPassword());
		userDto.setUserName(authRequest.getUserName());
		UserDto userDto2 = userService.getUser(userDto);
		HttpHeaders headers = getHeaders("GET");
		
		if(userDto2!=null)
		{
			try {
	            authenticationManager.authenticate(
	                    new UsernamePasswordAuthenticationToken(authRequest.getUserName(), authRequest.getPassword())
	            );
	        } catch (Exception ex) {
	            ex.getMessage();
	        }
			String token = jwtUtil.generateToken(authRequest.getUserName());
			headers.add("Authorization", "Bearer " + token);
			userDto2.setJwtToken(token);
	       System.out.println(token);
	       System.out.println(userDto2);
	       System.out.println(headers);
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
