package com.dc.web;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dc.pojo.User;
import com.dc.pojo.UserInfo;
import com.dc.service.TokenService;
import com.dc.service.UserService;
import com.dc.token.PassToken;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class LoginController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private TokenService tokenService;
	
	@PostMapping(value="/login123")
	@PassToken
	public Map<String, String> login(@RequestBody UserInfo userInfo){
		System.out.println("username="+userInfo.getUsername());
		log.info("username={},password={}",userInfo.getUsername(),userInfo.getPassword());
		
		User user = new User();
		user.setLoginName(userInfo.getUsername());
		user.setPassword(userInfo.getPassword());
		
		User user1 = userService.queryForLogin(user);
		Map<String, String> map = new HashMap<>();
		if(user1 != null) {
			String token = tokenService.getToken(user1);
			map.put("success", "true");
			map.put("userName",user1.getLoginName());
			map.put("token", token);
			
		}
		return map;
	}

}
