package com.dc.dao.vo;

import lombok.Data;

@Data
public class ResponseResult<T> {
	private String code;
	private T data;
	private String token;

	public ResponseResult(String code, T data, String token) {
		super();
		this.code = code;
		this.data = data;
		this.token = token;
	}

	public ResponseResult(String code, T data) {
		super();
		this.code = code;
		this.data = data;
	}

}
