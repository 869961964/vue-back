package com.dc.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dc.dao.PageQueryDao;
import com.dc.pojo.User1;
import com.dc.service.UserQueryPage;
@Service
public class UserQueryPageImpl implements UserQueryPage {
	@Autowired
	private PageQueryDao pageQueryDao;

	public List<User1> getOnePagenoteData(Map<String, Object> map) {
		return pageQueryDao.getOnePagenoteData(map);
	}

}
