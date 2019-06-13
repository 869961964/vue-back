package com.dc.service.impl;

import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.dc.pojo.User;
import com.dc.service.TokenService;

@Service
public class TokenServiceImpl implements TokenService {

	@Override
	public String getToken(User user) {
        String token="";
        token= JWT.create().withAudience(String.valueOf(user.getId()))
                .sign(Algorithm.HMAC256(user.getPassword()));
        return token;
    }

}
