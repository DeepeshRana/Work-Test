package com.user.registration.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.user.registration.dto.UserDto;
import com.user.registration.exception.UserRegistrationException;
import com.user.registration.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/user")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("/register")
	public ResponseEntity<Object> registerUser(@Valid @RequestBody UserDto userDto) throws Exception {
		try {
			UserDto registeredUser = userService.registerUser(userDto);
			return ResponseEntity.ok(registeredUser);
		} catch (UserRegistrationException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body("Customer not registered successfully: " + e.getMessage());
		}
	}

	@GetMapping("/fetch")
	public ResponseEntity<UserDto> fetchUser(@RequestParam String username) {
		Optional<UserDto> userDto = userService.fetchUserByUserName(username);
		if (userDto.isPresent()) {
			return ResponseEntity.ok(userDto.get());
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
	}

}
