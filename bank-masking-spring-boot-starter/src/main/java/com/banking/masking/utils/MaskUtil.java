package com.banking.masking.utils;

import com.banking.masking.properties.MaskProperties;

public class MaskUtil {
	
	
	public static String mask(Object words, int maskingStart, int maskingEnd, char maskSymbol ) {
		
		if (words == null || words.toString() == null ) {
            return null;
        }

        if (maskingStart < 0 || maskingEnd < 0) {
            throw new IllegalArgumentException("Masking values must be >= 0");
        }

        if (words.toString().length() <= maskingStart + maskingEnd) {
            return words.toString();
        }
        
        
		String part1, part2 , part3 = "";
		
		int maskLength = words.toString().length() - maskingStart - maskingEnd;
		
		String masked = String.valueOf(maskSymbol).repeat(maskLength);
		
		part1 = words.toString().substring(0,maskingStart);
		part2 = masked;
		part3 = words.toString().substring(words.toString().length() - maskingEnd);
		
		
		return part1 + part2 + part3;
		
	}

	
}
