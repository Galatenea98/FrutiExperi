package com.upc.demo.service;

import com.upc.demo.domain.model.District;
import com.upc.demo.domain.service.DistrictService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class DistrictServiceImpl implements DistrictService {
    @Override
    public ResponseEntity<?> deleteDistrict(Long districtId) {
        return null;
    }

    @Override
    public District updateDistrict(Long districtId, District districtRequest) {
        return null;
    }

    @Override
    public District createDistrict(District district) {
        return null;
    }

    @Override
    public District getDistrictById(Long districtId) {
        return null;
    }

    @Override
    public Page<District> getAllDistricts(Pageable pageable) {
        return null;
    }
}
