package com.dc.exception;

import lombok.Data;

@Data
public class NoUserException extends Exception {
	static final long serialVersionUID = -3387516993124229948L;
	private String message;
	private Integer code;
	public NoUserException(String message,Integer code) {
		this.message=message;
		this.code=code;
	}

	public NoUserException(String message, Throwable cause) {
		super(message, cause);
	}
	
}
