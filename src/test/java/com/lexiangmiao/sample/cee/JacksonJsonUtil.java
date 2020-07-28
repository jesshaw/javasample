package com.lexiangmiao.sample.cee;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.TimeZone;

/**
 * Json转化
 */
public class JacksonJsonUtil {
    public static <T> T parseObject(String content, Class<T> valueType) throws IOException {
        if (content == null) {
            return null;
        }
        ObjectMapper mapper = getObjectMapper();
        return mapper.readValue(content, valueType);
    }

    public static <T> T parseObjectIgnoreCase(String content, Class<T> valueType) throws IOException {
        if (content == null) {
            return null;
        }
        ObjectMapper mapper = getObjectMapper();
        mapper.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);
        return mapper.readValue(content, valueType);
    }

    public static <T> T parseObject(String content, TypeReference typeReference) throws IOException {
        if (content == null) {
            return null;
        }
        ObjectMapper mapper = getObjectMapper();
        return mapper.readValue(content, typeReference);
    }

    public static <T> List<T> parseArray(String content, Class<T> clazz) throws IOException {
        if (content == null) {
            return null;
        }
        ObjectMapper mapper = getObjectMapper();
        return mapper.readValue(content, mapper.getTypeFactory().constructCollectionType(List.class, clazz));
    }


    public static <T> T deepCopy(T content, Class<T> clazz) throws IOException {
        if (content == null) {
            return null;
        }
        ObjectMapper mapper = getObjectMapper();
        return mapper.readValue(mapper.writeValueAsString(content), clazz);
    }

    public static JsonNode readNode(String json, String jsonPointerExpression) throws IOException {
        if (StringUtils.isEmpty(json)) {
            return null;
        }
        if (jsonPointerExpression != null) {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode root = objectMapper.readTree(json);
            return root.at(jsonPointerExpression);
        }
        return null;
    }

    public static JsonNode readNode(String json) throws IOException {
        if (StringUtils.isEmpty(json)) {
            return null;
        }
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode root = objectMapper.readTree(json);
        return root;
    }

    public static String readNodeValue(String json, String jsonPointerExpression) {
        try {
            JsonNode node = readNode(json, jsonPointerExpression);
            if (node != null) {
                return node.asText();
            }
            return "";
        } catch (IOException e) {
            return "";
        }
    }

    public static String toJsonString(Object value) {
        try {
            ObjectMapper mapper = getObjectMapper();
            mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
            return mapper.writeValueAsString(value);
        } catch (JsonProcessingException ex) {
            return null;
        }
    }

    public static String toJsonStringIncludeNull(Object value) {
        try {
            ObjectMapper mapper = getObjectMapper();
            return mapper.writeValueAsString(value);
        } catch (JsonProcessingException ex) {
            return null;
        }
    }

    public static String toJsonStringWithDefaultPrettyPrinter(Object value) {
        try {
            ObjectMapper mapper = getObjectMapper();
            return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(value);
        } catch (JsonProcessingException ex) {
            return null;
        }
    }

    public static String toJsonString(Object object, String dateFormat) throws JsonProcessingException {
        ObjectMapper mapper = getObjectMapper();

        DateFormat df = new SimpleDateFormat(dateFormat);
        mapper.setDateFormat(df);

        return mapper.writeValueAsString(object);
    }

    private static ObjectMapper getObjectMapper() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        mapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
        mapper.setTimeZone(TimeZone.getDefault());

        DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.XXX");
        mapper.setDateFormat(df);
        return mapper;
    }
}
