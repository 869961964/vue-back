package com.dc.pojo;

import java.io.Serializable;

import lombok.Data;

@Data
public class WebSocketPojo implements Serializable {
	private int id;
	private String userId;
	private String message;
	private String creatTime;
	private String readStuts;
}
