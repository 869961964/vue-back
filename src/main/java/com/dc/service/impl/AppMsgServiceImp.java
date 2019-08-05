package com.dc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dc.dao.AppMsgDao;
import com.dc.pojo.AppMsgPojo;
import com.dc.service.AppMsgService;
@Service
public class AppMsgServiceImp implements AppMsgService {
	@Autowired
	private AppMsgDao appMsgDao;
	@Override
	public List<AppMsgPojo> getmessage(String userName) {
		// TODO Auto-generated method stub
		return appMsgDao.getmessage();
	}

	@Override
	public int getMessageCount(String userName) {
		// TODO Auto-generated method stub
		return appMsgDao.getMessageCount(userName);
	}

	@Override
	public int deleteMsg(int id) {
		// TODO Auto-generated method stub
		return appMsgDao.deleteMsg(id);
	}

	@Override
	public int sendMsg(int id, String sendStuts) {
		// TODO Auto-generated method stub
		return appMsgDao.sendMsg(id, sendStuts);
	}

}
