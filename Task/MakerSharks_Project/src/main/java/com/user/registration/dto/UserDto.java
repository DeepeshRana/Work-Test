package com.user.registration.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UserDto {

	private Long id;

	@NotBlank(message = "Username is mandatory")
	@Size(min = 3, max = 50, message = "Username must be between 3 and 50 characters")
	private String userName;

	@NotBlank(message = "Email is mandatory")
	@Email(message = "Email should be valid")
	private String userEmail;
	
	@NotBlank(message = "Password is mandatory")
    @Size(min = 8, message = "Password must be at least 8 characters")
    private String password;

}
