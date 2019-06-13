package com.dc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dc.pojo.User;
import com.dc.service.UserService;
import com.dc.dao.UserDao;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;

	@Override
	public User queryForLogin(User user) {
		return userDao.queryForLogin(user);
	}

	@Override
	public User queryUserById(int id) {
		
		return userDao.queryUserById(id);
	}

}
