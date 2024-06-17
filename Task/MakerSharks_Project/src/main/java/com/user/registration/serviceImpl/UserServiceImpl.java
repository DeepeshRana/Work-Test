package com.user.registration.serviceImpl;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.registration.dto.UserDto;
import com.user.registration.entity.User;
import com.user.registration.exception.UserRegistrationException;
import com.user.registration.repository.UserRepository;
import com.user.registration.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public UserDto registerUser(UserDto userDto) throws Exception {

		if (userRepository.findByUserEmail(userDto.getUserEmail()) != null) {
			throw new UserRegistrationException("userEmail", userDto.getUserEmail(), "Email already exists");
		}

		User user = toUser(userDto);
		User savedUser = userRepository.save(user);
		return toDto(savedUser);
	}

	@Override
	public Optional<UserDto> fetchUserByUserName(String userName) {
		User user = userRepository.findByUserName(userName);
		if (user != null) {
			return Optional.of(toDto(user));
		} else {
			return Optional.empty();
		}
	}

	/*
	 * Convert user to userDto
	 */
	private UserDto toDto(User user) {
		UserDto userDto = modelMapper.map(user, UserDto.class);
		return userDto;
	}

	/*
	 * convert userDto to user
	 */
	private User toUser(UserDto userDto) {
		User user = modelMapper.map(userDto, User.class);
		return user;
	}

}
