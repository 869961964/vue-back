package com.dc;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.dc.dao")
public class VueBackApplication {

	public static void main(String[] args) {
		SpringApplication.run(VueBackApplication.class, args);
	}

}
