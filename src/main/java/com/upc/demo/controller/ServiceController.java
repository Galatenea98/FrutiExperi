package com.upc.demo.controller;

import com.upc.demo.domain.model.Service;
import com.upc.demo.domain.service.ServiceService;
import com.upc.demo.resource.ServiceResource;
import com.upc.demo.resource.saving.SaveServiceResource;
import io.swagger.v3.oas.annotations.Parameter;
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
public class ServiceController {
    @Autowired
    private ModelMapper mapper;

    @Autowired
    private ServiceService serviceService;

    @GetMapping("/services")
    public Page<ServiceResource> getAllServices(
            @Parameter(description="Pageable Parameter")
                    Pageable pageable) {
        Page<Service> servicesPage = serviceService.getAllServices(pageable);
        List<ServiceResource> resources = servicesPage.getContent().stream().map(this::convertToResource).collect(Collectors.toList());

        return new PageImpl<>(resources, pageable, resources.size());
    }

    @GetMapping("/services/{id}")
    public ServiceResource getServiceById(
            @Parameter(description="Service Id")
            @PathVariable(name = "id") Long serviceId) {
        return convertToResource(serviceService.getServiceById(serviceId));
    }

    @PostMapping("/services")
    public ServiceResource createService(@Valid @RequestBody SaveServiceResource resource)  {
        Service service = convertToEntity(resource);
        return convertToResource(serviceService.createService(service));
    }

    @PutMapping("/services/{id}")
    public ServiceResource updateService(@PathVariable(name = "id") Long serviceId, @Valid @RequestBody SaveServiceResource resource) {
        Service service = convertToEntity(resource);
        return convertToResource(serviceService.updateService(serviceId, service));
    }

    @DeleteMapping("/services/{id}")
    public ResponseEntity<?> deleteService(@PathVariable(name = "id") Long serviceId) {
        return serviceService.deleteService(serviceId);
    }


    private Service convertToEntity(SaveServiceResource resource) {
        return mapper.map(resource, Service.class);
    }

    private ServiceResource convertToResource(Service entity) {
        return mapper.map(entity, ServiceResource.class);
    }
}
