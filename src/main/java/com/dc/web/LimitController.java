package com.dc.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dc.pojo.Limit;
import com.dc.pojo.User1;
import com.dc.service.impl.LimitServiceImp;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/limit")
public class LimitController {
	@Autowired
	private LimitServiceImp limitServiceImp;

	
	@RequestMapping("/limit")
	public PageInfo<Limit> getLimitData(Integer pageIndex, Integer pageSize, String query) throws Exception {
		/* 创建分页工具类 */
		PageHelper.startPage(pageIndex, pageSize);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("username", query);
		//map.put("urban",query);
		//map.put("province",query);
		List<Limit> docs = limitServiceImp.getLimit();
		PageInfo<Limit> pageInfo = new PageInfo<>(docs);
		log.info("pageInfo={}", pageInfo.toString());
		return pageInfo;

	}
}
