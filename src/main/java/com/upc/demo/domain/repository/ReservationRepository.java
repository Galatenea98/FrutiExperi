package com.upc.demo.domain.repository;

import com.upc.demo.domain.model.Reservation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation,Long> {
    List<Reservation> findByServiceId(Long serviceId);
    Optional<Reservation> findByIdAndServiceId(Long id, Long serviceId);
}
