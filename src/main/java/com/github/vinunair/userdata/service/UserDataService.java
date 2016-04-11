package com.github.vinunair.userdata.service;

import com.github.vinunair.userdata.domain.User;

public interface UserDataService {

	User saveUser(User user);
	Iterable<User>searchUserByName(String name);
}
