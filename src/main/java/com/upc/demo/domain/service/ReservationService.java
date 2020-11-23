package com.upc.demo.domain.service;

import com.upc.demo.domain.model.Reservation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public interface ReservationService {
    Page<Reservation> getAllReservationsByServiceId(Long serviceId, Pageable pageable);
    Reservation getReservationByIdAndServiceId(Long serviceId, Long reservationId);
    Reservation createReservation(Long serviceId, Reservation reservation);
    Reservation updateReservation(Long serviceId, Long reservationId, Reservation reservationDetails);
    ResponseEntity<?> deleteReservation(Long serviceId, Long reservationId);
}
