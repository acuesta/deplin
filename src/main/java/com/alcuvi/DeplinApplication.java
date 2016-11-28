package com.alcuvi;

import java.net.UnknownHostException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;

@SpringBootApplication
public class DeplinApplication {

	public static void main(String[] args) {
		SpringApplication.run(DeplinApplication.class, args);
	}

	/*
	 * Use the standard Mongo driver API to create a com.mongodb.Mongo instance.
	 */
	public @Bean Mongo mongo() throws UnknownHostException {
		return new MongoClient("localhost");
	}

	public @Bean MongoTemplate mongoTemplate() throws Exception {
		return new MongoTemplate(mongo(), "instances");
	}
}
