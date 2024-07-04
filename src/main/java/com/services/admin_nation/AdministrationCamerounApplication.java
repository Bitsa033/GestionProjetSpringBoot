package com.services.admin_nation;

import java.util.List;

import java.util.Random;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class AdministrationCamerounApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdministrationCamerounApplication.class, args);
		
	}
	
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	public String genererID() {
		Random rand=new Random();
		long r1=rand.nextLong();
		long r2=rand.nextLong();
		long id=r1 +r2;
		int leftLimit = 97; // letter 'a'
	    int rightLimit = 122; // letter 'z'
	    int targetStringLength = 5;

	    String generatedString = rand.ints(leftLimit, rightLimit + 1)
	      .limit(targetStringLength)
	      .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
	      .toString();
	    String identifiant = "MAT-" +generatedString + "-" + id + "-" + generatedString ;
		return identifiant;
		
	}
	
	

}
