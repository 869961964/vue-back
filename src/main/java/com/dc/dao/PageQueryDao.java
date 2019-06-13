package com.dc.dao;

import java.util.List;
import java.util.Map;

import com.dc.pojo.User1;

public interface PageQueryDao {
	public List<User1> getOnePagenoteData(Map<String, Object> map);
}
