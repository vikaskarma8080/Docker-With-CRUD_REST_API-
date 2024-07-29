package com.job.app.service;

import org.springframework.data.domain.Page;

import com.job.app.entity.Users;

public interface IUserService {
	Users getUserById(Long id);

	Users getUserByUsername(String username);

	Users saveUser(Users user);

	void deleteUser(Long id);
	
	Users updateUser(Long id, Users user);
	
	  public Page<Users> getAllUsers(int page, int size) ;
	     
}
