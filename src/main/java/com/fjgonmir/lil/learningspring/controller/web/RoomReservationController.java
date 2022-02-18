package com.fjgonmir.lil.learningspring.controller.web;

import com.fjgonmir.lil.learningspring.Business.domain.RoomReservation;
import com.fjgonmir.lil.learningspring.Business.services.ReservationService;
import com.fjgonmir.lil.learningspring.utils.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/room-reservations")
public class RoomReservationController {
    private final ReservationService reservationService;

    @Autowired
    public RoomReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping
    public String getReservations(@RequestParam(value = "date", required = false) String dateString, Model model) {
        Date date = DateUtil.createDateFromDateString(dateString);
        model.addAttribute("roomReservations", reservationService.getRoomReservationsForDate(date));
        return "reservations";

    }
}
