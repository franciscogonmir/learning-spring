package com.fjgonmir.lil.learningspring.controller.web;


import com.fjgonmir.lil.learningspring.Business.domain.RoomReservation;
import com.fjgonmir.lil.learningspring.Business.services.ReservationService;
import com.fjgonmir.lil.learningspring.utils.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/reservations")
public class RoomReservationRestController {

    private ReservationService reservationService;

    @Autowired
    public RoomReservationRestController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping
    public List<RoomReservation> getRoomReservations(@RequestBody String date){
        Date dateFromString = DateUtil.createDateFromDateString(date);
        return reservationService.getRoomReservationsForDate(dateFromString);
    }
}
