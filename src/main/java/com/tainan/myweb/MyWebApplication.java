package com.tainan.myweb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.tainan")
public class MyWebApplication implements CommandLineRunner{

	@Autowired
	private MemberRepository memberRepo;
	
	public static void main(String[] args) {
		SpringApplication.run(MyWebApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {

	}

}
