package com.fjgonmir.lil.learningspring.web;

import com.fjgonmir.lil.learningspring.business.services.ReservationService;
import com.fjgonmir.lil.learningspring.controller.web.RoomReservationRestController;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(RoomReservationRestController.class)
class RoomReservationRestControllerTest {

    @MockBean
    private ReservationService roomReservationService;

    private MockMvc mockMvc;

    @Test
    void getRoomReservationsReturn200() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("api/reservations"))
                .andExpect(status().isOk());
    }
}
