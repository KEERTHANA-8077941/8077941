package com.clothmart.vyntramart.dao;

import java.util.List;

import com.clothmart.vyntramart.model.User;

public interface UserDao {
	void insertUser(User cus);
	void insertUsers(List<User> users);
	List<User> getAllUsers();
	User getUserById(String userId);
}