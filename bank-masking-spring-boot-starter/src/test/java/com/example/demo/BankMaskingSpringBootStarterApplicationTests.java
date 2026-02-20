package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

import com.banking.masking.configuration.BankMaskingAutoConfiguration;

@SpringBootTest
@ImportAutoConfiguration(BankMaskingAutoConfiguration.class)
class BankMaskingSpringBootStarterApplicationTests {

	

}
