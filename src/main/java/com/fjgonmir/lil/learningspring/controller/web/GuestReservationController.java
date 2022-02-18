package com.fjgonmir.lil.learningspring.controller.web;

import com.fjgonmir.lil.learningspring.Business.services.GuestService;
import com.fjgonmir.lil.learningspring.entity.Guest;
import org.apache.catalina.LifecycleState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("guest-reservations")
public class GuestReservationController {

    private GuestService guestService;
    @Autowired
    public GuestReservationController(GuestService guestService){
        this.guestService = guestService;
    }

    @GetMapping
    public String getGuest(Model model){
        model.addAttribute("guestList",guestService.findAllGuest());
        return "guests";
    }
}
