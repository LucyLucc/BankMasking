package com.banking.masking.configuration;

import java.beans.BeanProperty;
import java.util.List;

import com.banking.masking.properties.MaskProperties;
import com.banking.masking.serializer.BankMaskingSerializer;
import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.ser.BeanPropertyWriter;
import com.fasterxml.jackson.databind.ser.BeanSerializerModifier;


public class BankMaskingSerializerConfigModifier extends BeanSerializerModifier{
	
	private MaskProperties properties;
	
	public BankMaskingSerializerConfigModifier(MaskProperties properties) {
		this.properties = properties;
				
	}
	
	 @Override
	    public List<BeanPropertyWriter> changeProperties(
	            SerializationConfig config,
	            BeanDescription beanDesc,
	            List<BeanPropertyWriter> beanProperties) {

	        for (BeanPropertyWriter writer : beanProperties) {
	            System.out.println("Checking field: " + writer.getName());

	            if (properties.getFields() != null && properties.getFields().contains(writer.getName())) {
	                System.out.println("Masking field: " + writer.getName());
	                writer.assignSerializer(new BankMaskingSerializer(properties));
	            }
	        }
		
		return beanProperties;
	}

}
