package com.fjgonmir.lil.learningspring.Business.services;

import com.fjgonmir.lil.learningspring.Business.domain.RoomReservation;
import com.fjgonmir.lil.learningspring.entity.Guest;
import com.fjgonmir.lil.learningspring.entity.Reservation;
import com.fjgonmir.lil.learningspring.entity.Room;
import com.fjgonmir.lil.learningspring.repository.GuestRepository;
import com.fjgonmir.lil.learningspring.repository.ReservationRepository;
import com.fjgonmir.lil.learningspring.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ReservationService {

    private RoomRepository roomRepository;

    private GuestRepository guestRepository;

    private ReservationRepository reservationRepository;

    @Autowired
    public ReservationService(RoomRepository roomRepository, GuestRepository guestRepository, ReservationRepository reservationRepository) {
        this.roomRepository = roomRepository;
        this.guestRepository = guestRepository;
        this.reservationRepository = reservationRepository;
    }

    public List<RoomReservation> getRoomReservationsForDate(Date date) {
        Map<Long, RoomReservation> roomReservationMap = new HashMap<>();
        getDataFromRooms(roomReservationMap);
        getDataFromReservations(roomReservationMap, date);
        return roomReservationMap.entrySet()
            .stream()
            .map(entry -> entry.getValue())
            .collect(Collectors.toList());
    }

    private void getDataFromReservations(Map<Long, RoomReservation> roomReservationMap, Date date) {
        Iterable<Reservation> reservations = reservationRepository.findReservationsByReservationDate(date);
        reservations.forEach((reservation) -> {
            RoomReservation roomReservation = roomReservationMap.get(reservation.getRoomId());
            roomReservation.setDate(reservation.getReservationDate());
            roomReservation.setGuestId(reservation.getGuestId());
            setDataFromGuest(roomReservation, reservation.getGuestId());
            roomReservationMap.put(roomReservation.getRoomId(), roomReservation);
        });
    }

    private void setDataFromGuest(RoomReservation roomReservation, Long guestId) {
        Optional<Guest> guest = guestRepository.findById(guestId);
        if (guest.isPresent()) {
            roomReservation.setFirstName(guest.get().getFirstName());
            roomReservation.setLastName(guest.get().getLastName());
        }
    }

    private void getDataFromRooms(Map<Long, RoomReservation> roomReservationMap) {
        Iterable<Room> rooms = roomRepository.findAll();
        rooms.forEach((room) -> {
            RoomReservation roomReservation = new RoomReservation();
            roomReservation.setRoomId(room.getRoomId());
            roomReservation.setRoomName(room.getRoomName());
            roomReservation.setRoomNumber(room.getRoomNumber());
            roomReservationMap.put(roomReservation.getRoomId(), roomReservation);
        });
    }
}
