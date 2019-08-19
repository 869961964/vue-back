package com.dc.service;

import com.dc.exception.NoUserException;
import com.dc.pojo.User;

public interface UserService {
	User queryForLogin(User user) throws NoUserException;
	
	User queryUserById(int id);
}
