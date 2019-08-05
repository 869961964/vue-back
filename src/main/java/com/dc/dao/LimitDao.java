package com.dc.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.dc.pojo.Limit;

public interface LimitDao {
	@Select("select * from role_limit")
	List<Limit> getLimit();
}
