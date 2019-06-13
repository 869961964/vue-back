package com.dc.dao.vo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
@Data
public class MenuListVO {
	
	private int id;
	
	@JsonProperty(value="authName")
	private String name;
	
	@JsonProperty(value="path")
	private String url;
	
	private List<MenuListVO> children;

}
