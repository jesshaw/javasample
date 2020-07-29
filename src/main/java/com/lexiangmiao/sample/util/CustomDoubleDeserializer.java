package com.lexiangmiao.sample.util;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;

/**
 * Created by mzxiao on 2020/7/29 11:23
 */
public class CustomDoubleDeserializer extends JsonDeserializer<Double> {

    @Override
    public Double deserialize(JsonParser jp, DeserializationContext ds) throws IOException, JsonProcessingException {

        String value = jp.getValueAsString();
        if(value != null && !value.isEmpty() && !value.equals("null")&& !value.equals("--")&& !value.equals("-"))
            return Double.valueOf(value);
        return null;
    }

    @Override
    public Class<Double> handledType() {
        return Double.class;
    }
}
