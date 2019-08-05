package com.dc.service;

import java.util.List;

import com.dc.pojo.AppMsgPojo;



public interface AppMsgService {
	List<AppMsgPojo> getmessage(String userName);

	int getMessageCount(String userName);

	int sendMsg(int id, String sendStuts);
	
	int deleteMsg(int id);
}
