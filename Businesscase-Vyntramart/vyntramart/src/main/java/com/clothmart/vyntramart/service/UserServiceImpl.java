package com.clothmart.vyntramart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clothmart.vyntramart.dao.UserDao;
import com.clothmart.vyntramart.model.User;
import com.clothmart.vyntramart.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userDao;

	@Override
	public void insertUser(User user) {
		userDao.insertUser(user);
	}

	@Override
	public void insertUsers(List<User> users) {
		userDao.insertUsers(users);
	}

	public List<User> getAllUsers() {
		return userDao.getAllUsers();
	}

	@Override
	public void getUserById(String uId) {
		User user = userDao.getUserById(uId);
		System.out.println(user);
	}

}