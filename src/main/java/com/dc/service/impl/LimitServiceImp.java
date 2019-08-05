package com.dc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dc.dao.LimitDao;
import com.dc.pojo.Limit;
import com.dc.service.LimitService;
@Service
public class LimitServiceImp implements LimitService {
	@Autowired
	private LimitDao limitDao;

	@Override
	public List<Limit> getLimit() {
		// TODO Auto-generated method stub
		return limitDao.getLimit();
	}

}
