package com.dc.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.dc.pojo.Menu;

public interface MenuDao {
	
	@Select("select * from t_menu where pid=#{pid} ")
	List<Menu> findById(int pid);

}
