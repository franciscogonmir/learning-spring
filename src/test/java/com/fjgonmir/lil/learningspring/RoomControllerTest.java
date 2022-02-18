package com.fjgonmir.lil.learningspring;


import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fjgonmir.lil.learningspring.controller.RoomController;
import com.fjgonmir.lil.learningspring.entity.Room;
import com.fjgonmir.lil.learningspring.repository.RoomRepository;
import com.fjgonmir.lil.learningspring.utils.Mapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

@WebMvcTest(RoomController.class)
@AutoConfigureMockMvc
public class RoomControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private RoomRepository roomRepository;

    private List<Room> rooms;

    @BeforeEach
    public void init(){
        rooms = new ArrayList<>();
        Room room1 = new Room();
        room1.setRoomId(1);
        room1.setRoomName("NAME");
        room1.setRoomNumber("1");
        room1.setBedInfo("INFO");

        Room room2 = new Room();
        room1.setRoomId(2);
        room1.setRoomName("NAME2");
        room1.setRoomNumber("2");
        room1.setBedInfo("INFO2");

        rooms.add(room1);
        rooms.add(room2);
    }

    @Test
    public void shouldReturnStatusOk() throws Exception {
        when(roomRepository.findAll()).thenReturn(rooms);
        this.mockMvc.perform(
            get("/rooms")
        ).andDo(
            print()
        ).andExpect(
            status().isOk()
        ).andExpect(
            content().json(Mapper.convertObjectToJsonString(rooms))
        );
    }
}
