package com.dc.pojo;

import lombok.Data;

@Data
public class Menu {
	private int id;
	private String name;
	private String url;
	private int pid;
    private String imgurl;
}
