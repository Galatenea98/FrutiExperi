package com.upc.demo.domain.service;

import com.upc.demo.domain.model.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public interface ServiceService {
    ResponseEntity<?> deleteService(Long serviceId);
    Service updateService(Long serviceId, Service serviceRequest);
    Service createService(Service service);
    Service getServiceById(Long serviceId);
    Page<Service> getAllServices(Pageable pageable);
}
