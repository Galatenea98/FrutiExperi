package com.upc.demo.service;

import com.upc.demo.domain.model.Reservation;
import com.upc.demo.domain.repository.ReservationRepository;
import com.upc.demo.domain.repository.ServiceRepository;
import com.upc.demo.domain.service.ReservationService;
import com.upc.demo.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationServiceImpl implements ReservationService {
    @Autowired
    private ReservationRepository reservationRepository;
    @Autowired
    private ServiceRepository serviceRepository;

    @Override
    public List<Reservation> getAllReservationsByServiceId(Long serviceId) {
        return reservationRepository.findByServiceId(serviceId);
    }

    @Override
    public Reservation getReservationByIdAndServiceId(Long serviceId, Long reservationId) {
        return reservationRepository.findByIdAndServiceId(reservationId, serviceId)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Reservation not found with Id " + reservationId +
                                " and ServiceId " + serviceId));
    }

    @Override
    public Reservation createReservation(Long serviceId, Reservation reservation) {
        return serviceRepository.findById(serviceId).map(service -> {
            reservation.setService(service);
            return reservationRepository.save(reservation);
        }).orElseThrow(() -> new ResourceNotFoundException(
                "Service", "Id", serviceId));
    }

    @Override
    public Reservation updateReservation(Long serviceId, Long reservationId, Reservation reservationDetails) {
        if(!serviceRepository.existsById(serviceId))
            throw new ResourceNotFoundException("Service", "Id", serviceId);

        return reservationRepository.findById(reservationId).map(reservation -> {
            return reservationRepository.save(reservation);
        }).orElseThrow(() -> new ResourceNotFoundException("Reservation", "Id", reservationId));
    }

    @Override
    public ResponseEntity<?> deleteReservation(Long serviceId, Long reservationId) {
        return reservationRepository.findByIdAndServiceId(reservationId, serviceId).map(reservation -> {
            reservationRepository.delete(reservation);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException(
                "Reservation not found with Id " + reservationId + " and ServiceId " + serviceId));
    }
}
