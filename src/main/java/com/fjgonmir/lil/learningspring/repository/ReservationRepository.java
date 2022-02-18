package com.fjgonmir.lil.learningspring.repository;

import com.fjgonmir.lil.learningspring.entity.Reservation;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;

public interface ReservationRepository extends CrudRepository<Reservation, Long> {

    Iterable<Reservation> findReservationsByReservationDate(Date date);
}
