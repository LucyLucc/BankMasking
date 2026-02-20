package com.banking.masking.configuration;

import com.banking.masking.properties.MaskProperties;
import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.databind.module.SimpleModule;

import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

@AutoConfiguration
@EnableConfigurationProperties(MaskProperties.class)
@ConditionalOnProperty(prefix = "bank.masking", name = "enabled", havingValue = "true")
public class BankMaskingAutoConfiguration {

	 @Bean
	    public Module bankMaskingModule(MaskProperties properties) {
	        System.out.println("Masking AutoConfiguration Loaded");
	        System.out.println("properties"+properties.getMaskingEnd()+properties.getMaskingEnd()+properties.getMaskingSymbol());
	        SimpleModule module = new SimpleModule();
	        module.setSerializerModifier(new BankMaskingSerializerConfigModifier(properties));
	        return module;
	    }
}