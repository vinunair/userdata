package com.github.vinunair.userdata.service;

import java.util.List;

import com.github.vinunair.userdata.domain.User;

public interface UserDataService {

	User saveUser(User user);
	Iterable<User>searchUserByName(String name);
}
