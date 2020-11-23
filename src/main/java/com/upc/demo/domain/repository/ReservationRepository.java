package com.upc.demo.domain.repository;

import com.upc.demo.domain.model.Reservation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation,Long> {
    Page<Reservation> findByServiceId(Long serviceId, Pageable pageable);
    Optional<Reservation> findByIdAndServiceId(Long id, Long serviceId);
}
