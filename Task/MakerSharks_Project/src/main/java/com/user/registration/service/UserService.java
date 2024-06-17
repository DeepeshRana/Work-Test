package com.user.registration.service;

import java.util.Optional;

import com.user.registration.dto.UserDto;

public interface UserService {

	UserDto registerUser(UserDto userDto) throws Exception;

	Optional<UserDto> fetchUserByUserName(String userName);

}
