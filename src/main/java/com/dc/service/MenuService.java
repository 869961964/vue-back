package com.dc.service;

import java.util.List;

import com.dc.dao.vo.MenuListVO;
import com.dc.pojo.Menu;

public interface MenuService {
	
	List<Menu> findById(int pid);
	
	List<MenuListVO> getMenuListVO();

}
