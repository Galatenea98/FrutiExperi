package com.upc.demo.domain.service;

import com.upc.demo.domain.model.Service;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ServiceService {
    ResponseEntity<?> deleteService(Long serviceId);
    Service updateService(Long serviceId, Service serviceRequest);
    Service createService(Service service);
    Service getServiceById(Long serviceId);
    List<Service> getAllServices();
}
