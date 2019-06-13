package com.dc.pojo;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
	
	private int id;
	private String userName;
	private String loginName;
	private String phoneNumber;
	private String sex;
	private String email;
	private String password;
	
	
	

}
