package com.springboot.simple2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringBootSimple2Application implements CommandLineRunner, ApplicationRunner 
{
	private static final Logger log = LoggerFactory.getLogger(SpringBootSimple2Application.class);
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootSimple2Application.class, args);
	}
	
	@Bean
	String info() {
		return "간단한 문자열 bean입니다.";
	}
	
	@Autowired
	String info;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		// TODO Auto-generated method stub
		log.info("## > ApplicationRunner 구현체 ...");
		log.info("info 빈에 access: " + info);
		args.getNonOptionArgs().forEach(file -> log.info(file));
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		log.info("## > CommandLineRunner 구현체 ...");
		log.info("info 빈에 access: " + info);
		
		for(String arg : args) {
			log.info(arg);
		}
	}
}
