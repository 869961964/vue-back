package com.dc.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User1 {
	
	private int id;
	private String userName;
	private String password;
	private Boolean status;
	private String date;
	private String sex;
	private String email;
	
	
	
}
