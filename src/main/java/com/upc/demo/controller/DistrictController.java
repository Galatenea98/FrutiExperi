package com.upc.demo.controller;

import com.upc.demo.domain.model.District;
import com.upc.demo.domain.service.DistrictService;
import com.upc.demo.resource.DistrictResource;
import com.upc.demo.resource.saving.SaveDistrictResource;
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
public class DistrictController {   
    @Autowired
    private ModelMapper mapper;
    
    @Autowired
    private DistrictService districtService;
    
    @GetMapping("/districts")
    public List<DistrictResource> getAllDistricts(){
        return districtService.getAllDistricts().stream().map(this::convertToResource).collect(Collectors.toList());
    }

    @GetMapping("/districts/{id}")
    public DistrictResource getDistrictById(
            @Parameter(description="District Id")
            @PathVariable(name = "id") Long districtId) {
        return convertToResource(districtService.getDistrictById(districtId));
    }

    @PostMapping("/districts")
    public DistrictResource createDistrict(@Valid @RequestBody SaveDistrictResource resource)  {
        District district = convertToEntity(resource);
        return convertToResource(districtService.createDistrict(district));
    }

    @PutMapping("/districts/{id}")
    public DistrictResource updateDistrict(@PathVariable(name = "id") Long districtId, @Valid @RequestBody SaveDistrictResource resource) {
        District district = convertToEntity(resource);
        return convertToResource(districtService.updateDistrict(districtId, district));
    }

    @DeleteMapping("/districts/{id}")
    public ResponseEntity<?> deleteDistrict(@PathVariable(name = "id") Long districtId) {
        return districtService.deleteDistrict(districtId);
    }


    private District convertToEntity(SaveDistrictResource resource) {
        return mapper.map(resource, District.class);
    }

    private DistrictResource convertToResource(District entity) {
        return mapper.map(entity, DistrictResource.class);
    }
}
