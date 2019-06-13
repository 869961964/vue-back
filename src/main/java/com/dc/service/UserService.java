package com.dc.service;

import com.dc.pojo.User;

public interface UserService {
	User queryForLogin(User user);
	
	User queryUserById(int id);
}
