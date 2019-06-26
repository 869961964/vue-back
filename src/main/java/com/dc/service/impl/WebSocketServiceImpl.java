package com.dc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dc.dao.WebSocketDao;
import com.dc.pojo.WebSocketPojo;
import com.dc.service.WebSocketService;
@Service
public class WebSocketServiceImpl implements WebSocketService {
	@Autowired
	private WebSocketDao webSocketDao;
	@Override
	public List<WebSocketPojo> getmessage(String userId) {
		List<WebSocketPojo> list= webSocketDao.getmessage(userId);
		return list;
	}
	@Override
	public int getMessageCount(String userId) {
		
		return webSocketDao.getMessageCount(userId);
	}
	@Override
	public int readOk(int id, String read) {
		
		return webSocketDao.readOk(id, read);
	}
	@Override
	public int deleteMsg(int id) {
		
		return webSocketDao.deleteMsg(id);
	}

}
