package com.dc.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dc.dao.vo.MenuListVO;
import com.dc.service.MenuService;
import com.dc.token.UserLoginToken;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class MenuController {
	@Autowired
	private MenuService menuService;

	@RequestMapping("/menus")
	@UserLoginToken
	public List<MenuListVO> getMenuList(@RequestParam("userID")String userID) {
		log.info("sdfsad{}",userID);
		return menuService.getMenuListVO();
	}
}
