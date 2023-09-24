package com.gaoxinzhi.www.database;

import com.gaoxinzhi.www.database.handler.DBOperationHandler;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@MapperScan("com.gaoxinzhi.www.database.mapper")
public class DatabaseApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(DatabaseApplication.class, args);
		DBOperationHandler dbOperationHandler = (DBOperationHandler) context.getBean("DBOperationHandler");
		dbOperationHandler.GenerateDataToDB();
	}

}
