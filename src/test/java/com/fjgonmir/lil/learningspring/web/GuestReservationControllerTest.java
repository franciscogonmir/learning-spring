package com.fjgonmir.lil.learningspring.web;

import com.fjgonmir.lil.learningspring.Business.services.GuestService;
import com.fjgonmir.lil.learningspring.controller.web.GuestReservationController;
import com.fjgonmir.lil.learningspring.entity.Guest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.containsString;
import static org.mockito.Mockito.when;

@WebMvcTest(GuestReservationController.class)
public class GuestReservationControllerTest {

    @MockBean
    private GuestService guestService;
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getGuestReservationhasDataInResponse() throws Exception{
        Guest guest = new Guest();
        guest.setGuestId(1L);
        guest.setFirstName("Guest");
        guest.setLastName("last Guest");
        guest.setEmailAddress("guest@guest.com");
        guest.setPhoneNumber("111-111-111");
        List<Guest> guestList = new ArrayList<>();
        guestList.add(guest);
        when(guestService.findAllGuest()).thenReturn(guestList);
        mockMvc.perform(MockMvcRequestBuilders.get("/guest-reservations"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(containsString("guest@guest.com")));


    }
}
