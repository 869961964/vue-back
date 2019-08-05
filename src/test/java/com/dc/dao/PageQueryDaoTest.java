package com.dc.dao;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.dc.pojo.User1;

import lombok.extern.slf4j.Slf4j;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Slf4j
public class PageQueryDaoTest {
	@Autowired
	private PageQueryDao pageQueryDao;

	
	@Test
	public void test() {
	  for(int i=0;i<20;i++) {
		  User1 user1 = new User1();
		  user1.setUserName("lisi");
		  user1.setPassWord("123456");
		  user1.setEmail("123456@163.com");
		  user1.setSex("女");
		  user1.setUserStatus(false);
		  pageQueryDao.addUser(user1);
	  }
	  

	}

}
