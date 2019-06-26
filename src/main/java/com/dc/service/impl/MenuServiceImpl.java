package com.dc.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dc.dao.MenuDao;
import com.dc.dao.vo.MenuListVO;
import com.dc.pojo.Menu;
import com.dc.service.MenuService;

import lombok.extern.slf4j.Slf4j;
@Service
@Slf4j
public class MenuServiceImpl implements MenuService {
	
	@Autowired
	private MenuDao menuDao;

	@Override
	public List<Menu> findById(int pid) {
		return menuDao.findById(pid);
	}
	
	
	


	@Override
	public List<MenuListVO> getMenuListVO() {
		List<Menu> menuList = menuDao.findById(0);
		
		List<MenuListVO> menuListVOList = new ArrayList<>();
		
		
		for (Menu menu : menuList) {
			MenuListVO menuListVO = new MenuListVO();
			menuListVO.setId(menu.getId());
			menuListVO.setName(menu.getName());
			menuListVO.setUrl(menu.getUrl());
			menuListVO.setImgurl(menu.getImgurl());
			List<Menu> menuList1 = menuDao.findById(menu.getId());
			
			
			
			menuListVO.setChildren(convertFormMenu(menuList1));
			menuListVOList.add(menuListVO);
		}
		
		log.info("menuListVOList={}",menuListVOList.toString());
		return menuListVOList;
	}
	
	public List<MenuListVO> convertFormMenu(List<Menu> menuList){
		List<MenuListVO> menuListVOList = new ArrayList<>();
		for (Menu menu : menuList) {
			MenuListVO menuListVO = new MenuListVO();
			menuListVO.setId(menu.getId());
			menuListVO.setName(menu.getName());
			menuListVO.setUrl(menu.getUrl());
			menuListVO.setImgurl(menu.getImgurl());
			menuListVOList.add(menuListVO);
		}
		
		return menuListVOList;
	}

}
