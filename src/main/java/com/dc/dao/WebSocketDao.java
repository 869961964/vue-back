package com.dc.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.dc.pojo.WebSocketPojo;

public interface WebSocketDao {
	@Select("select * from websocket where user_id=#{userId}")
	List<WebSocketPojo> getmessage(String userId);

	@Select("select count(*) from websocket where user_id=#{userId}")
	int getMessageCount(String userId);

	@Update("update websocket set read_stuts=#{readStuts} where id=#{id}")
	int readOk(@Param("id") int id, @Param("readStuts") String readStuts);

	@Delete("delete from websocket where id=#{id}")
	int deleteMsg(int id);
}
