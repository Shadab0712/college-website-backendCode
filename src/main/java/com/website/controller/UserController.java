package com.website.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.website.dto.UserDTO;
import com.website.service.UserService;

@RestController
@RequestMapping("/api/v1/users")
@CrossOrigin("http://localhost:3001")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("/save")
	public ResponseEntity<String> createUser(@RequestBody UserDTO userDTO) {
		userService.createUser(userDTO);
		return new ResponseEntity<>("Query successfull", HttpStatus.CREATED);
	}

}
