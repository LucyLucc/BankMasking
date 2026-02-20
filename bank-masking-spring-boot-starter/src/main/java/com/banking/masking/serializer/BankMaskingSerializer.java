package com.banking.masking.serializer;

import java.io.IOException;

import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.banking.masking.properties.MaskProperties;
import com.fasterxml.jackson.core.JsonGenerator;

public class BankMaskingSerializer extends StdSerializer<Object> {

    private final MaskProperties properties;

    public BankMaskingSerializer(MaskProperties properties) {
        super(Object.class); // Use Object instead of String
        this.properties = properties;
    }

    @Override
    public void serialize(Object value, JsonGenerator gen, SerializerProvider provider) throws IOException {
        if (value == null) {
            gen.writeNull();
            return;
        }

        String str = value.toString();

        if (str.length() <= properties.getMaskingStart() + properties.getMaskingEnd()) {
            gen.writeString(str);
            return;
        }

        int maskLength = str.length() - properties.getMaskingStart() - properties.getMaskingEnd();
        String masked = str.substring(0, properties.getMaskingStart())
                + String.valueOf(properties.getMaskingSymbol()).repeat(maskLength)
                + str.substring(str.length() - properties.getMaskingEnd());

        gen.writeString(masked);
    }
}