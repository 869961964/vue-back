package com.dc.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.dc.pojo.User;

public interface UserDao {
	
	@Select("select * from t_user where login_name=#{loginName} and password=#{password} ")
	User queryForLogin(User user);
	
	@Select("select * from t_user where id=#{id} ")
	User queryUserById(int id);
	

}
