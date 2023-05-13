package com.apiRestMysql;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.apiRestMysql.repository.TopicosRepository;
import com.apiRestMysql.entities.Topicos;

@SpringBootApplication
public class ApiRestMysqlApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiRestMysqlApplication.class, args);
		
	
	}

}
