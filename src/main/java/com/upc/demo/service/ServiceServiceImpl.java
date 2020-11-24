package com.upc.demo.service;

import com.upc.demo.domain.repository.ServiceRepository;
import com.upc.demo.domain.service.ServiceService;
import com.upc.demo.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ServiceServiceImpl implements ServiceService {
    @Autowired
    ServiceRepository serviceRepository;
    
    @Override
    public ResponseEntity<?> deleteService(Long serviceId) {
        com.upc.demo.domain.model.Service service = serviceRepository.findById(serviceId)
                .orElseThrow(() -> new ResourceNotFoundException("Service", "Id", serviceId));
        serviceRepository.delete(service);
        return ResponseEntity.ok().build();
    }

    @Override
    public com.upc.demo.domain.model.Service updateService(Long serviceId, com.upc.demo.domain.model.Service serviceRequest) {
        com.upc.demo.domain.model.Service service = serviceRepository.findById(serviceId)
                .orElseThrow(() -> new ResourceNotFoundException("Service", "Id", serviceId));
        return serviceRepository.save(service);
    }

    @Override
    public com.upc.demo.domain.model.Service createService(com.upc.demo.domain.model.Service service) {
        return serviceRepository.save(service);
    }

    @Override
    public com.upc.demo.domain.model.Service getServiceById(Long serviceId) {
        return serviceRepository.findById(serviceId)
                .orElseThrow(() -> new ResourceNotFoundException("Service", "Id", serviceId));
    }

    @Override
    public Page<com.upc.demo.domain.model.Service> getAllServices(Pageable pageable) {
        return serviceRepository.findAll(pageable);
    }
}
