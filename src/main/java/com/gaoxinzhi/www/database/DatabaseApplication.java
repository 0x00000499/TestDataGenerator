package com.gaoxinzhi.www.database;

import com.gaoxinzhi.www.database.handler.DBOperationHandler;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Scanner;

@SpringBootApplication
@MapperScan("com.gaoxinzhi.www.database.mapper")
public class DatabaseApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(DatabaseApplication.class, args);
		DBOperationHandler dbOperationHandler = (DBOperationHandler) context.getBean("DBOperationHandler");
		System.out.println("system up");
		dbOperationHandler.GenerateDataToDB();
		System.out.println("system down");
	}

}
