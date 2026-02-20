package com.example.demo;

import org.junit.jupiter.api.Test;

import com.banking.masking.utils.MaskUtil;

import static org.assertj.core.api.Assertions.*;

public class BankingMaskUtilTest {
	
	 @Test
	    void shouldMaskMiddleCharacters() {
	        String result = MaskUtil.mask("lucy@example.com", 2, 2, '*');

	        // length = 16
	        // keep 2 + 2 = 4
	        // mask 12 characters
	        assertThat(result)
	                .isEqualTo("lu************om");
	    }

	    @Test
	    void shouldReturnOriginalIfTooShort() {
	        // length = 3
	        // prefix 2 + suffix 2 = 4 > 3
	        String result = MaskUtil.mask("abc", 2, 2, '*');

	        assertThat(result).isEqualTo("abc");
	    }

	    @Test
	    void shouldHandleNullValue() {
	        String result = MaskUtil.mask(null, 2, 2, '*');

	        assertThat(result).isNull();
	    }

	    @Test
	    void shouldUseCustomMaskCharacter() {
	        String result = MaskUtil.mask("254712345678", 3, 2, '#');

	        // length = 12
	        // keep 3 + 2 = 5
	        // mask 7 characters
	        assertThat(result)
	                .isEqualTo("254#######78");
	    }
}
