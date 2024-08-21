package com.sist.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
@ComponentScan(basePackages = {"com.sist.web.entity",
							   "com.sist.web.commons",
							   "com.sist.web.dao",
							   "com.sist.web.service",
							   "com.sist.web.controller"})
@SpringBootApplication
public class MyDevProject01Application {

	public static void main(String[] args) {
		SpringApplication.run(MyDevProject01Application.class, args);
	}

}
