package com.upc.demo.service;

import com.upc.demo.domain.model.Recommendation;
import com.upc.demo.domain.repository.RecommendationRepository;
import com.upc.demo.domain.repository.ServiceRepository;
import com.upc.demo.domain.service.RecommendationService;
import com.upc.demo.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class RecommendationServiceImpl implements RecommendationService {
    @Autowired
    private RecommendationRepository recommendationRepository;
    @Autowired
    private ServiceRepository serviceRepository;

    @Override
    public Page<Recommendation> getAllRecommendationsByServiceId(Long serviceId, Pageable pageable) {
        return recommendationRepository.findByServiceId(serviceId, pageable);
    }

    @Override
    public Recommendation getRecommendationByIdAndServiceId(Long serviceId, Long recommendationId) {
            return recommendationRepository.findByIdAndServiceId(recommendationId, serviceId)
                    .orElseThrow(() -> new ResourceNotFoundException(
                            "Recommendation not found with Id " + recommendationId +
                                    " and ServiceId " + serviceId));
    }

    @Override
    public Recommendation createRecommendation(Long serviceId, Recommendation recommendation) {
            return serviceRepository.findById(serviceId).map(service -> {
                recommendation.setService(service);
                return recommendationRepository.save(recommendation);
            }).orElseThrow(() -> new ResourceNotFoundException(
                    "Service", "Id", serviceId));
    }

    @Override
    public Recommendation updateRecommendation(Long serviceId, Long recommendationId, Recommendation recommendationDetails) {
            if(!serviceRepository.existsById(serviceId))
                throw new ResourceNotFoundException("Service", "Id", serviceId);

            return recommendationRepository.findById(recommendationId).map(recommendation -> {
                recommendation.setContent(recommendationDetails.getContent()    );
                return recommendationRepository.save(recommendation);
            }).orElseThrow(() -> new ResourceNotFoundException("Recommendation", "Id", recommendationId));
    }

    @Override
    public ResponseEntity<?> deleteRecommendation(Long serviceId, Long recommendationId) {
            return recommendationRepository.findByIdAndServiceId(recommendationId, serviceId).map(recommendation -> {
                recommendationRepository.delete(recommendation);
                return ResponseEntity.ok().build();
            }).orElseThrow(() -> new ResourceNotFoundException(
                    "Recommendation not found with Id " + recommendationId + " and ServiceId " + serviceId));
    }
}
