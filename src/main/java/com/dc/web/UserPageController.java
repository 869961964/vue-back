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
public class UserPageController {
	@Autowired
	private UserQueryPage userQueryPage;
	@RequestMapping("/userPage")
	public PageInfo<User1> getOnePagenoteData(Integer pageIndex, Integer pageSize,String query) throws Exception {
        /*创建分页工具类*/
       PageHelper.startPage(pageIndex, pageSize);
       Map<String,Object> map=new HashMap<String,Object>();
       map.put("username",query);
      // map.put("startdate",startdate);
       //map.put("enddate",enddate);
       List<User1> docs = userQueryPage.getOnePagenoteData(map);
       PageInfo<User1> pageInfo = new PageInfo<>(docs);
       log.info("pageInfo={}",pageInfo.toString());
       return pageInfo;

   }

}
