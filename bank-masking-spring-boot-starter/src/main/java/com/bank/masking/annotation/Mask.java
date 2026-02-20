package com.bank.masking.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
public @interface Mask {

	int maskingStart();
	int maskingEnd();
	char maskSymbol();
	
}
