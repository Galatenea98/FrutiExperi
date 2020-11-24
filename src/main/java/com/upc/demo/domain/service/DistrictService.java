package com.upc.demo.domain.service;

import com.upc.demo.domain.model.District;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public interface DistrictService {
    ResponseEntity<?> deleteDistrict(Long districtId);
    District updateDistrict(Long districtId, District districtRequest);
    District createDistrict(District district);
    District getDistrictById(Long districtId);
    Page<District> getAllDistricts(Pageable pageable);
}
