package com.github.vinunair.userdata.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.github.vinunair.userdata.domain.User;

public interface UserRespository extends CrudRepository<User, Integer> {

	List<User> findByFirstnameContaining(String firstName);
	List<User> findByLastnameContaining(String lastName);
	List<User> findByFirstnameAndLastnameContaining(String firstname,String lastname);
	
}
