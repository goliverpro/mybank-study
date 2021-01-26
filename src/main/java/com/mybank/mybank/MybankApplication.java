package com.mybank.mybank;

import com.mybank.mybank.domain.Account;
import com.mybank.mybank.service.AccountService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class MybankApplication {

	public static void main(String[] args) {
		SpringApplication.run(MybankApplication.class, args);

		System.out.println("test");


	}

}
