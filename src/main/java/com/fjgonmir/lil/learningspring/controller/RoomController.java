package com.fjgonmir.lil.learningspring.controller;

import com.fjgonmir.lil.learningspring.entity.Room;
import com.fjgonmir.lil.learningspring.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/rooms")
public class RoomController {
    @Autowired
    private RoomRepository roomRepository;

    @GetMapping
    public Iterable<Room> getRooms() {
        return this.roomRepository.findAll();
    }
}
