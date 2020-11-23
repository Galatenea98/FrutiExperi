package com.upc.demo.domain.service;

import com.upc.demo.domain.model.Recommendation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public interface RecommendationService {
    Page<Recommendation> getAllRecommendationsByServiceId(Long serviceId, Pageable pageable);
    Recommendation getRecommendationByIdAndServiceId(Long serviceId, Long recommendationId);
    Recommendation createRecommendation(Long serviceId, Recommendation recommendation);
    Recommendation updateRecommendation(Long serviceId, Long recommendationId, Recommendation recommendationDetails);
    ResponseEntity<?> deleteRecommendation(Long serviceId, Long recommendationId);
}
