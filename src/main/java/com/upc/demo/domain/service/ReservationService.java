package com.upc.demo.domain.service;

import com.upc.demo.domain.model.Reservation;

import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ReservationService {
    List<Reservation> getAllReservationsByServiceId(Long serviceId);
    Reservation getReservationByIdAndServiceId(Long serviceId, Long reservationId);
    Reservation createReservation(Long serviceId, Reservation reservation);
    Reservation updateReservation(Long serviceId, Long reservationId, Reservation reservationDetails);
    ResponseEntity<?> deleteReservation(Long serviceId, Long reservationId);
}
