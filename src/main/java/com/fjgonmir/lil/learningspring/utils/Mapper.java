package com.fjgonmir.lil.learningspring.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fjgonmir.lil.learningspring.exceptions.MapperException;

public class Mapper {

    private Mapper() {
        throw new IllegalStateException("utility class");
    }

    public static String convertObjectToJsonString(Object roomList) throws MapperException {
        try {
            ObjectMapper mapper = new ObjectMapper();
            return mapper.writeValueAsString(roomList);
        } catch (JsonProcessingException e) {
            throw new MapperException(e.getMessage());
        }
    }
}
