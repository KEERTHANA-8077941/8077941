package com.clothmart.vyntramart.service;
import java.util.List;

import com.clothmart.vyntramart.model.User;

public interface UserService {
	void insertUser(User u);
	void insertUsers(List<User> users);
	List<User> getAllUsers();
	void getUserById(String uid);
}
