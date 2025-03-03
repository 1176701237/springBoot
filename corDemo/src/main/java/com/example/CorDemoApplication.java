package com.example;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.cordemo.model.mapper")
public class CorDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CorDemoApplication.class, args);
	}

}
