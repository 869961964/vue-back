package com.dc.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dc.pojo.AppMsgPojo;
import com.dc.service.AppMsgService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/appWebsocket")
@Slf4j
public class AppMsgController {


	@Autowired
	private AppMsgService appMsgService;


	// 获取app消息列表
	@RequestMapping("/getAppMsge")
	public PageInfo<AppMsgPojo> getWebSocketMsge(@RequestParam(value = "userName") String userName, Integer pageIndex,
			Integer pageSize, String query) {
		/* 创建分页工具类 */
		PageHelper.startPage(pageIndex, pageSize);
		// 查询userId对应的通知消息
		List<AppMsgPojo> list = appMsgService.getmessage(userName);
		PageInfo<AppMsgPojo> pageInfo = new PageInfo<>(list);
		log.info(list.toString());
		return pageInfo;
	}

	@RequestMapping("/sendMsg")
	public String sendMsg(@RequestParam(value = "id") int id, @RequestParam(value = "sendStuts") String sendStuts) {
		System.out.println(sendStuts);
		String readStuts;
		if (sendStuts.equals("否")) {
			sendStuts = "是";
		} else {
			sendStuts = "否";
		}
		Integer count = appMsgService.sendMsg(id, sendStuts);
		if (count > 0) {
			return "修改推送消息成功!";
		} else {
			return "修改推送消息失败!";
		}

	}
	@RequestMapping("deleteMsg")
	public Map<String,String> deleteMsg(int id){
		Map<String,String> map = new HashMap<>();
		int count = appMsgService.deleteMsg(id);
		if(count>0){
			map.put("code", "删除消息成功!");
		}else {
			map.put("code", "删除消息失败!");
		}
		return map;
	}
}
