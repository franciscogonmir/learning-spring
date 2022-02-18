package com.fjgonmir.lil.learningspring.controller;

import com.fjgonmir.lil.learningspring.entity.Reservation;
import com.fjgonmir.lil.learningspring.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reservations")
public class ReservationController {

    @Autowired
    private ReservationRepository reservationRepository;

    @GetMapping
    public Iterable<Reservation> getReservations(){
        return reservationRepository.findAll();
    }
}
