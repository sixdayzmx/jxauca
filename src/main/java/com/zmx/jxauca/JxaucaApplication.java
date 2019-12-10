package com.zmx.jxauca;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@MapperScan("com.zmx.jxauca.mapper")
public class JxaucaApplication {


	public static void main(String[] args) {
		SpringApplication.run(JxaucaApplication.class, args);
	}

}

//<component-scan basepackage = "com.zmx"/>