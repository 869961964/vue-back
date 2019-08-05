package com.dc.pojo;

import lombok.Data;

@Data
public class Limit {
	private int id;
	private String roleId;// 角色ID
	private String roleName;// 角色名称
	private int roleLevel;// 角色级别
	private String roleDef;// 默认角色
}
