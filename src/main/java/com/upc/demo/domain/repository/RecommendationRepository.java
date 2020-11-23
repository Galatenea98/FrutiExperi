package com.upc.demo.domain.repository;

import com.upc.demo.domain.model.Recommendation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RecommendationRepository extends JpaRepository<Recommendation,Long> {
    Page<Recommendation> findByServiceId(Long serviceId, Pageable pageable);
    Optional<Recommendation> findByIdAndServiceId(Long id, Long serviceId);

}
