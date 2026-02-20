package com.banking.masking.properties;

import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "bank.masking")
public class MaskProperties {
	 	private boolean enabled = true;
	    private List<String> fields;
	    private int maskingStart;
	    private int maskingEnd;
	    private char maskingSymbol = '*';
		public boolean isEnabled() {
			return enabled;
		}
		public void setEnabled(boolean enabled) {
			this.enabled = enabled;
		}
		public List<String> getFields() {
			return fields;
		}
		public void setFields(List<String> fields) {
			this.fields = fields;
		}
		public int getMaskingStart() {
			return maskingStart;
		}
		public void setMaskingStart(int maskingStart) {
			this.maskingStart = maskingStart;
		}
		public int getMaskingEnd() {
			return maskingEnd;
		}
		public void setMaskingEnd(int maskingEnd) {
			this.maskingEnd = maskingEnd;
		}
		public char getMaskingSymbol() {
			return maskingSymbol;
		}
		public void setMaskingSymbol(char maskingSymbol) {
			this.maskingSymbol = maskingSymbol;
		}

   
}