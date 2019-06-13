package com.dc.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.dc.dao.vo.MenuListVO;
import com.dc.pojo.Menu;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class MenuServiceTest {
	
	@Autowired
	private MenuService menuService;

	@Test
	public void testFindById() throws Exception {
		/*List<Menu> menuList = menuService.findById(0);
		
		List<MenuListVO> menuListVOList = new ArrayList<>();
		
		
		for (Menu menu : menuList) {
			MenuListVO menuListVO = new MenuListVO();
			menuListVO.setId(menu.getId());
			menuListVO.setName(menu.getName());
			menuListVO.setUrl(menu.getUrl());
			
			List<Menu> menuList1 = menuService.findById(menu.getId());
			
			
			
			menuListVO.setChildren(menuList1);
			menuListVOList.add(menuListVO);
		}
		
		log.info("menuListVOList={}",menuListVOList.toString());
		
		ObjectMapper jsonList = new ObjectMapper();
		String jsonString = jsonList.writeValueAsString(menuListVOList);
		log.info("jsonString={}",jsonString.toString());*/

	}
	
	@Test
	public void testGetMenuListVO() throws Exception {
		List<MenuListVO> menuListVO = menuService.getMenuListVO();
		ObjectMapper jsonList = new ObjectMapper();
		String jsonString = jsonList.writeValueAsString(menuListVO);
		log.info("jsonString={}",jsonString.toString());
	}

}
