package com.fjgonmir.lil.learningspring.utils;

import com.fjgonmir.lil.learningspring.entity.Room;
import com.fjgonmir.lil.learningspring.exceptions.MapperException;
import com.google.gson.Gson;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class MapperTest {

    private List<Room> roomList;

    @BeforeEach
    public void setUp() {
        roomList = new ArrayList<>();

        Room room1 = new Room();
        room1.setRoomId(1);
        room1.setRoomName("name one");
        room1.setRoomNumber("room number one");
        room1.setBedInfo("Bed info one");

        Room room2 = new Room();
        room2.setRoomId(1);
        room2.setRoomName("name two");
        room2.setRoomNumber("room number two");
        room2.setBedInfo("Bed info two");

        Room room3 = new Room();
        room3.setRoomId(1);
        room3.setRoomName("name three");
        room3.setRoomNumber("room number three");
        room3.setBedInfo("Bed info three");

        roomList.add(room1);
        roomList.add(room2);
        roomList.add(room3);
    }

    @Test
    void mapperListRoomResturnCorrectJson() throws MapperException {
        Assertions.assertEquals(Mapper.convertObjectToJsonString(roomList), new Gson().toJson(roomList));
    }

    @Test
    void convertObjectToJsonStringReturnNull() throws MapperException {
        Assertions.assertEquals(Mapper.convertObjectToJsonString(null), new Gson().toJson(null));
    }

    @Test
    void convertObjectToJsonStringReturnEmptyList() throws MapperException {
        Assertions.assertEquals(Mapper.convertObjectToJsonString(new ArrayList<>()), new Gson().toJson(new ArrayList<>()));
    }

    @Test
    void convertObjectToJsonStringthrowException() {
        Assertions.assertThrows(MapperException.class, () -> Mapper.convertObjectToJsonString(
                new Object()
        ));
    }

}
