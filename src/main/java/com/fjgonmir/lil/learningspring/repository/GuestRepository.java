package com.fjgonmir.lil.learningspring.repository;

import com.fjgonmir.lil.learningspring.entity.Guest;
import org.springframework.data.repository.CrudRepository;

public interface GuestRepository extends CrudRepository<Guest, Long> {
}
