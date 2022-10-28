package org.eka.tests.tools;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.eka.tests.common.solutionV2.TestData;

import java.io.InputStream;

public class JsonParser {
    private static ObjectMapper mapper = new ObjectMapper();

    public String loadFromResources(String filePath) {
        try (InputStream in = Thread.currentThread()
                .getContextClassLoader()
                .getResourceAsStream(filePath)) {

            JsonNode jsonNode = mapper.readValue(in, JsonNode.class);
            return mapper.writeValueAsString(jsonNode);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public <T> T loadFromResources(String filePath, Class<T> clazz) {
        try (InputStream in = Thread.currentThread()
                .getContextClassLoader()
                .getResourceAsStream(filePath)) {

            return mapper.readValue(in, clazz);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public<I, O> TestData<I, O> loadFromResources(String filePath, Class<I> iClass, Class<O> oClass) {
        try (InputStream in = Thread.currentThread()
                .getContextClassLoader()
                .getResourceAsStream(filePath)) {

            JavaType type = mapper.getTypeFactory().constructParametricType(TestData.class, iClass, oClass);
            return mapper.readValue(in, type);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public<I, O> TestData<I, O> loadFromJsonString(String jsonString, Class<I> iClass, Class<O> oClass) {
        try {
            JavaType type = mapper.getTypeFactory().constructParametricType(TestData.class, iClass, oClass);
            return mapper.readValue(jsonString, type);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }}
