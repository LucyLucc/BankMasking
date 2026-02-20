package com.bank.books;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.bank.books.repository")
@EntityScan(basePackages = "com.bank.books.entity")
public class BankBooksApiDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankBooksApiDemoApplication.class, args);
	}

}
