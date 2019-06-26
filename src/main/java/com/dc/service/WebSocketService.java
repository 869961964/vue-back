package com.dc.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.dc.pojo.WebSocketPojo;

public interface WebSocketService {

	List<WebSocketPojo> getmessage(String userId);

	int getMessageCount(String userId);

	int readOk(int id, String read);
	
	int deleteMsg(int id);

}
