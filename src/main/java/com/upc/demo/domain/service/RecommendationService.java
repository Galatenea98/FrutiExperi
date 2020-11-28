package com.upc.demo.domain.service;

import com.upc.demo.domain.model.Recommendation;

import org.springframework.http.ResponseEntity;

import java.util.List;

public interface RecommendationService {
    List<Recommendation> getAllRecommendationsByServiceId(Long serviceId);
    Recommendation getRecommendationByIdAndServiceId(Long serviceId, Long recommendationId);
    Recommendation createRecommendation(Long serviceId, Recommendation recommendation);
    Recommendation updateRecommendation(Long serviceId, Long recommendationId, Recommendation recommendationDetails);
    ResponseEntity<?> deleteRecommendation(Long serviceId, Long recommendationId);
}
