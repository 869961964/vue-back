package com.dc.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dc.pojo.User1;
import com.dc.service.UserQueryPage;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/user")
public class UserPageController {
	@Autowired
	private UserQueryPage userQueryPage;

	@RequestMapping("/userPage")
	public PageInfo<User1> getOnePagenoteData(Integer pageIndex, Integer pageSize, String query) throws Exception {
		/* 创建分页工具类 */
		PageHelper.startPage(pageIndex, pageSize);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("username", query);
		//map.put("urban",query);
		//map.put("province",query);
		List<User1> docs = userQueryPage.getOnePagenoteData(map);
		PageInfo<User1> pageInfo = new PageInfo<>(docs);
		log.info("pageInfo={}", pageInfo.toString());
		return pageInfo;

	}
	
	@RequestMapping("/deleteUser")
	public Map<String,String> deleteUser(String username) {
		Map<String,String> map = new HashMap<>();
		int count =userQueryPage.deleteUser(username);
		if(count>0) {
			map.put("msg", "删除成功");
		}else {
			map.put("msg", "删除失败");
		}
		return map;
	}
	
	

}
