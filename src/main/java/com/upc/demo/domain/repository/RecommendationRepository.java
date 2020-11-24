package com.upc.demo.domain.repository;

import com.upc.demo.domain.model.Recommendation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RecommendationRepository extends JpaRepository<Recommendation,Long> {
    List<Recommendation> findByServiceId(Long serviceId);
    Optional<Recommendation> findByIdAndServiceId(Long id, Long serviceId);

}
