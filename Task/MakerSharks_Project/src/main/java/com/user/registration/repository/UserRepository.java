package com.user.registration.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.user.registration.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	public User findByUserEmail(String userEmail);
	
	public User findByUserName(String userName);

}
