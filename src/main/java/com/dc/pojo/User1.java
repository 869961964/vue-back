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
	private String passWord;
	private Boolean userStatus;
	private String date;
	private String sex;
	private String email;
	private String roleName;
	
	
}
