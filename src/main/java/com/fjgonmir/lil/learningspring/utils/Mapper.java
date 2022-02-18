package com.fjgonmir.lil.learningspring.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fjgonmir.lil.learningspring.entity.Room;

import java.util.List;

public class Mapper {

    public static String convertObjectToJsonString(List<Room> roomList){
        try {
            ObjectMapper mapper = new ObjectMapper();
            return mapper.writeValueAsString(roomList);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }
}
