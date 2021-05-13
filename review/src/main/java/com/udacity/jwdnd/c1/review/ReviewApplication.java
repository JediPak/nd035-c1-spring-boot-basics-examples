package com.udacity.jwdnd.c1.review;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ReviewApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReviewApplication.class, args);
	}

	/*@Bean
	public String message(){
		System.out.println("Bean created");
		return "Hello, Spring!";
	}

	@Bean
	public String uppercaseMessage(MessageService messageService){
		String uppercaseMessage = null;
		uppercaseMessage = messageService.uppercase();
		System.out.println("lowercase message initial: "+uppercaseMessage);
		return uppercaseMessage;
	}

	@Bean
	public String lowercaseMessage(MessageService messageService){
		String lowercaseMessage = null;
		lowercaseMessage = messageService.lowercase();
		System.out.println("lowercase message initial: "+lowercaseMessage);
		return lowercaseMessage;
 	}*/
}
