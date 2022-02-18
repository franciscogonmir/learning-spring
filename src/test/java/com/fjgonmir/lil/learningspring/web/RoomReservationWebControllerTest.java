package com.fjgonmir.lil.learningspring.web;

import static org.hamcrest.CoreMatchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fjgonmir.lil.learningspring.business.domain.RoomReservation;
import com.fjgonmir.lil.learningspring.business.services.ReservationService;
import com.fjgonmir.lil.learningspring.controller.web.RoomReservationController;
import com.fjgonmir.lil.learningspring.utils.DateUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@WebMvcTest(RoomReservationController.class)
class RoomReservationWebControllerTest {

    @MockBean
    private ReservationService reservationService;
    @Autowired
    private MockMvc mockMvc;


    @Test
    void getReservations() throws Exception {
        String dateString = "2020-01-01";
        Date date = DateUtil.createDateFromDateString(dateString);
        List<RoomReservation> roomReservationList = new ArrayList<>();
        RoomReservation roomReservation = new RoomReservation();
        roomReservation.setLastName("unit");
        roomReservation.setFirstName("Junit");
        roomReservation.setDate(date);
        roomReservation.setGuestId(1);
        roomReservation.setRoomId(100);
        roomReservation.setRoomName("Junit room");
        roomReservation.setRoomNumber("J1");
        roomReservationList.add(roomReservation);
        when(this.reservationService.getRoomReservationsForDate(date))
                .thenReturn(roomReservationList);
        this.mockMvc
                .perform(get("/room-reservations?date=2020-01-01"))
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("roomReservations"))
                .andExpect(content().string(containsString("unit")));
    }
}
