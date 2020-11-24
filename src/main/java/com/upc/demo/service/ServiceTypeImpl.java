package com.upc.demo.service;

import com.upc.demo.domain.model.ServiceType;
import com.upc.demo.domain.repository.ServiceTypeRepository;
import com.upc.demo.domain.service.ServiceTypeService;
import com.upc.demo.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ServiceTypeImpl implements ServiceTypeService {
    @Autowired
    private ServiceTypeRepository serviceTypeRepository;
    @Override
    public ResponseEntity<?> deleteServiceType(Long serviceTypeId) {
        ServiceType serviceType = serviceTypeRepository.findById(serviceTypeId)
                .orElseThrow(() -> new ResourceNotFoundException("ServiceType", "Id", serviceTypeId));
        serviceTypeRepository.delete(serviceType);
        return ResponseEntity.ok().build();
    }

    @Override
    public ServiceType updateServiceType(Long serviceTypeId, ServiceType serviceTypeRequest) {
        ServiceType serviceType = serviceTypeRepository.findById(serviceTypeId)
                .orElseThrow(() -> new ResourceNotFoundException("ServiceType", "Id", serviceTypeId));
        serviceType.setName(serviceTypeRequest.getName());
        return serviceTypeRepository.save(serviceType);
    }

    @Override
    public ServiceType createServiceType(ServiceType serviceType) {
        return serviceTypeRepository.save(serviceType);
    }

    @Override
    public ServiceType getServiceTypeById(Long serviceTypeId) {
        return serviceTypeRepository.findById(serviceTypeId)
                .orElseThrow(() -> new ResourceNotFoundException("ServiceType", "Id", serviceTypeId));
    }

    @Override
    public Page<ServiceType> getAllServiceTypes(Pageable pageable) {
        return serviceTypeRepository.findAll(pageable);
    }
}
