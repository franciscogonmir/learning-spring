package com.fjgonmir.lil.learningspring.Business.services;

import com.fjgonmir.lil.learningspring.entity.Guest;
import com.fjgonmir.lil.learningspring.repository.GuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

@Service
public class GuestService {

    private GuestRepository guestRepository;

    @Autowired
    public GuestService(GuestRepository guestRepository) {
        this.guestRepository = guestRepository;
    }

    public List<Guest> findAllGuest() {
        List<Guest> guestList = new ArrayList<>();
        guestRepository.findAll().iterator().forEachRemaining(guestList::add);
        guestList.sort(Comparator.comparing(Guest::getLastName));
        return guestList;
    }
}
