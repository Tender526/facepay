package com.abc.facepay;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.abc.facepay.mapper")
public class FacepayApplication {

	public static void main(String[] args) {
		SpringApplication.run(FacepayApplication.class, args);
	}

}
