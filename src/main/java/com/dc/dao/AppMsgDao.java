package com.dc.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.dc.pojo.AppMsgPojo;


public interface AppMsgDao {
	@Select("select * from app_msg")
	List<AppMsgPojo> getmessage();

	@Select("select count(*) from app_msg where user_id=#{userName}")
	int getMessageCount(String userName);

	@Update("update app_msg set send_stuts=#{sendStuts} where id=#{id}")
	int sendMsg(@Param("id") int id, @Param("sendStuts") String sendStuts);

	@Delete("delete from app_msg where id=#{id}")
	int deleteMsg(int id);
}
