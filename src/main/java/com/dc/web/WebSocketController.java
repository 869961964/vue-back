package com.dc.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dc.pojo.User1;
import com.dc.pojo.WebSocketPojo;
import com.dc.service.WebSocketService;
import com.dc.websocket.WebSocket;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("websocket")
@Slf4j
public class WebSocketController {
	@Autowired
	private WebSocket webSocket;

	@Autowired
	private WebSocketService webSocketService;

	@RequestMapping("/sendAllWebSocket")
	public String test() {
		webSocket.sendAllMessage("清晨起来打开窗，心情美美哒~");
		return "websocket群体发送！";
	}

	@RequestMapping("/sendOneMessage")
	public String sendOneWebSocket(@RequestParam(value = "userId") String userId) {
		// 查询userId对应的通知消息
		// List<WebSocketPojo> list= webSocketService.getmessage(userId);

		// log.info(list.toString());
		Integer count = webSocketService.getMessageCount(userId);
		webSocket.sendOneMessage(userId, count);
		System.out.println("发送给" + userId + "成功");
		return "websocket单人发送";
	}

	// 获取webSocket消息列表
	@RequestMapping("/getWebSocketMsge")
	public PageInfo<WebSocketPojo> getWebSocketMsge(@RequestParam(value = "userId") String userId, Integer pageIndex,
			Integer pageSize, String query) {
		/* 创建分页工具类 */
		PageHelper.startPage(pageIndex, pageSize);
		// 查询userId对应的通知消息
		List<WebSocketPojo> list = webSocketService.getmessage(userId);
		PageInfo<WebSocketPojo> pageInfo = new PageInfo<>(list);
		log.info(list.toString());
		return pageInfo;
	}

	@RequestMapping("/readOk")
	public String readOkt(@RequestParam(value = "id") int id, @RequestParam(value = "read") String read) {
		System.out.println(read);
		String readStuts;
		if (read.equals("已读")) {
			readStuts = "未读";
		} else {
			readStuts = "已读";
		}
		Integer count = webSocketService.readOk(id, readStuts);
		if (count > 0) {
			return "修改已读/未读成功";
		} else {
			return "修改已读/未读成功";
		}

	}
	@RequestMapping("deleteMsg")
	public Map<String,String> deleteMsg(int id){
		Map<String,String> map = new HashMap<>();
		int count = webSocketService.deleteMsg(id);
		if(count>0){
			map.put("code", "删除消息成功!");
		}else {
			map.put("code", "删除消息失败!");
		}
		return map;
	}
}
