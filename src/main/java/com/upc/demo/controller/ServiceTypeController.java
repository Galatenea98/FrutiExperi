package com.upc.demo.controller;

import com.upc.demo.domain.model.ServiceType;
import com.upc.demo.domain.service.ServiceTypeService;
import com.upc.demo.resource.ServiceTypeResource;
import com.upc.demo.resource.saving.SaveServiceTypeResource;
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
public class ServiceTypeController {
    @Autowired
    private ModelMapper mapper;

    @Autowired
    private ServiceTypeService serviceTypeService;

    @GetMapping("/serviceTypes")
    public Page<ServiceTypeResource> getAllServiceTypes(
            @Parameter(description="Pageable Parameter")
                    Pageable pageable) {
        Page<ServiceType> serviceTypesPage = serviceTypeService.getAllServiceTypes(pageable);
        List<ServiceTypeResource> resources = serviceTypesPage.getContent().stream().map(this::convertToResource).collect(Collectors.toList());

        return new PageImpl<>(resources, pageable, resources.size());
    }

    @GetMapping("/serviceTypes/{id}")
    public ServiceTypeResource getServiceTypeById(
            @Parameter(description="ServiceType Id")
            @PathVariable(name = "id") Long serviceTypeId) {
        return convertToResource(serviceTypeService.getServiceTypeById(serviceTypeId));
    }

    @PostMapping("/serviceTypes")
    public ServiceTypeResource createServiceType(@Valid @RequestBody SaveServiceTypeResource resource)  {
        ServiceType serviceType = convertToEntity(resource);
        return convertToResource(serviceTypeService.createServiceType(serviceType));
    }

    @PutMapping("/serviceTypes/{id}")
    public ServiceTypeResource updateServiceType(@PathVariable(name = "id") Long serviceTypeId, @Valid @RequestBody SaveServiceTypeResource resource) {
        ServiceType serviceType = convertToEntity(resource);
        return convertToResource(serviceTypeService.updateServiceType(serviceTypeId, serviceType));
    }

    @DeleteMapping("/serviceTypes/{id}")
    public ResponseEntity<?> deleteServiceType(@PathVariable(name = "id") Long serviceTypeId) {
        return serviceTypeService.deleteServiceType(serviceTypeId);
    }


    private ServiceType convertToEntity(SaveServiceTypeResource resource) {
        return mapper.map(resource, ServiceType.class);
    }

    private ServiceTypeResource convertToResource(ServiceType entity) {
        return mapper.map(entity, ServiceTypeResource.class);
    }
}
