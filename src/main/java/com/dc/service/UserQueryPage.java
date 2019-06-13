package com.dc.service;

import java.util.List;
import java.util.Map;

import com.dc.pojo.User1;

public interface UserQueryPage {
	public List<User1> getOnePagenoteData(Map<String, Object> map);
}
