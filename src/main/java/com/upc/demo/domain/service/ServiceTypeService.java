package com.upc.demo.domain.service;

import com.upc.demo.domain.model.ServiceType;

import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ServiceTypeService {
    ResponseEntity<?> deleteServiceType(Long serviceTypeId);
    ServiceType updateServiceType(Long serviceTypeId, ServiceType serviceTypeRequest);
    ServiceType createServiceType(ServiceType serviceType);
    ServiceType getServiceTypeById(Long serviceTypeId);
    List<ServiceType> getAllServiceTypes();
}
