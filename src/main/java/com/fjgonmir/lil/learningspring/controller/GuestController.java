package com.fjgonmir.lil.learningspring.controller;

import com.fjgonmir.lil.learningspring.entity.Guest;
import com.fjgonmir.lil.learningspring.repository.GuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/guests")
public class GuestController {
    @Autowired
    private GuestRepository guestRepository;

    @GetMapping
    public Iterable<Guest> getGuest(){
        return guestRepository.findAll();
    }
}
