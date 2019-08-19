package com.dc.web;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dc.dao.vo.ResponseResult;
import com.dc.exception.NoUserException;
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
	public ResponseResult<String> login(@RequestBody UserInfo userInfo){
		System.out.println("username="+userInfo.getUsername());
		log.info("username={},password={}",userInfo.getUsername(),userInfo.getPassword());
		
		User user = new User();
		user.setLoginName(userInfo.getUsername());
		user.setPassword(userInfo.getPassword());
		//Map<String, String> map = new HashMap<>();
		ResponseResult<String> result;
		try {
			User user1 = userService.queryForLogin(user);
			String token = tokenService.getToken(user1);
			result = new ResponseResult<String>("true",user1.getLoginName(),token);
//			map.put("code", "true");
//			map.put("userName",user1.getLoginName());
//			map.put("token", token);
//			
		} catch (NoUserException e) {
			result = new ResponseResult<String>("faile",e.getMessage(),"");
//			map.put("code", e.getCode().toString());
//			map.put("userName",e.getMessage());
//			map.put("token", "");	
		}
		return result;
	}

}
