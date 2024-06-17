package com.user.registration.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Data
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "Username is mandatory")
	@Size(min = 3, max = 50, message = "Username must be between 3 and 50 characters")
	@Column(name = "username", nullable = false, unique = true)
	private String userName;

	@NotBlank(message = "Email is mandatory")
	@Email(message = "Email should be valid")
	@Column(name = "email", nullable = false, unique = true)
	private String userEmail;

	@NotEmpty(message = "Password is mandatory")
	@Size(min = 8, message = "Password must be at least 8 characters")
	@Column(name = "password", nullable = false)
	private String password;

}
