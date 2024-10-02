package com.dev.internal.personal.employee.util;

import com.dev.internal.personal.employee.model.enums.Gender;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;

public class GenderDeserializer extends JsonDeserializer<Gender> {
    @Override
    public Gender deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        String genderString = p.getText();
        try {
            return Gender.valueOf(genderString.toUpperCase());
        } catch (IllegalArgumentException e) {
            return Gender.M;
        }
    }
}
