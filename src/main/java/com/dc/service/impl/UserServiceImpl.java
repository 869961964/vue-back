package com.dc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dc.pojo.User;
import com.dc.service.UserService;
import com.dc.dao.UserDao;
import com.dc.exception.NoUserException;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Override
	public User queryForLogin(User user) throws NoUserException {
		User user1 = userDao.queryForLogin(user);
		if (user1 == null) {
			throw new NoUserException("未定义该用户", 100);
		}
		return user1;
	}

	@Override
	public User queryUserById(int id) {

		return userDao.queryUserById(id);
	}

}
