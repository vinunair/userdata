package com.github.vinunair.userdata.service;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import com.github.vinunair.userdata.domain.User;
import com.github.vinunair.userdata.repository.UserRespository;

public class UserServiceImpl implements UserService {

	private UserRespository userRespository;
	
	@Autowired
	public void setUserRepository(UserRespository userRespository) {
		this.userRespository = userRespository;
	}
	
	public User saveUser(User user) {
		return userRespository.save(user);
	}

	public Iterable<User> searchUserByName(String name) {
		List<User> fetchUserByFirstName = userRespository.findByFirstnameContaining(name);
		List<User> fetchUserByLastName = userRespository.findByLastnameContaining(name);
		List<User> fetchUserByFirstnameAndLastName = userRespository.findByFirstnameAndLastnameContaining(name, name);
		
		Set uniqueUsersByName = new HashSet<User>();
		Collections.addAll(uniqueUsersByName, fetchUserByFirstName,fetchUserByLastName,fetchUserByFirstnameAndLastName);
 		return uniqueUsersByName;
	}

}
