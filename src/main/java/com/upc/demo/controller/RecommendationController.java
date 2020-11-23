package com.upc.demo.controller;

import com.upc.demo.domain.model.Recommendation;
import com.upc.demo.domain.service.RecommendationService;
import com.upc.demo.resource.RecommendationResource;
import com.upc.demo.resource.saving.SaveRecommendationResource;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class RecommendationController {
    @Autowired
    private ModelMapper mapper;
    @Autowired
    private RecommendationService recommendationService;

    @GetMapping("/services/{serviceId}/recommendations")
    public Page<RecommendationResource> getAllRecommendationsByServiceId(
            @PathVariable(name = "serviceId") Long serviceId,
            Pageable pageable) {
        Page<Recommendation> recommendationPage = recommendationService.getAllRecommendationsByServiceId(serviceId, pageable);
        List<RecommendationResource> resources = recommendationPage.getContent().stream().map(this::convertToResource).collect(Collectors.toList());
        return new PageImpl<>(resources, pageable, resources.size());
    }

    @GetMapping("/services/{serviceId}/recommendations/{recommendationId}")
    public RecommendationResource getRecommendationByIdAndServiceId(@PathVariable(name = "serviceId") Long serviceId,
                                                             @PathVariable(name = "recommendationId") Long recommendationId) {
        return convertToResource(recommendationService.getRecommendationByIdAndServiceId(serviceId, recommendationId));
    }

    @PostMapping("/services/{serviceId}/recommendations")
    public RecommendationResource createRecommendation(@PathVariable(name = "serviceId") Long serviceId,
                                               @Valid @RequestBody SaveRecommendationResource resource) {
        return convertToResource(recommendationService.createRecommendation(serviceId, convertToEntity(resource)));

    }

    @PutMapping("/services/{serviceId}/recommendations/{recommendationId}")
    public RecommendationResource updateRecommendation(@PathVariable(name = "serviceId") Long serviceId,
                                               @PathVariable(name = "recommendationId") Long recommendationId,
                                               @Valid @RequestBody SaveRecommendationResource resource) {
        return convertToResource(recommendationService.updateRecommendation(serviceId, recommendationId, convertToEntity(resource)));
    }

    @DeleteMapping("/services/{serviceId}/recommendations/{recommendationId}")
    public ResponseEntity<?> deleteRecommendation(@PathVariable(name = "serviceId") Long serviceId,
                                              @PathVariable(name = "recommendationId") Long recommendationId) {
        return recommendationService.deleteRecommendation(serviceId, recommendationId);
    }

    private Recommendation convertToEntity(SaveRecommendationResource resource) {
        return mapper.map(resource, Recommendation.class);
    }

    private RecommendationResource convertToResource(Recommendation entity) {
        return mapper.map(entity, RecommendationResource.class);
    }
}
