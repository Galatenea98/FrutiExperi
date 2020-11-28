package com.upc.demo.service;

import com.upc.demo.domain.model.MembershipType;
import com.upc.demo.domain.repository.MembershipTypeRepository;
import com.upc.demo.domain.service.MembershipTypeService;
import com.upc.demo.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MembershipTypeImpl implements MembershipTypeService {
    @Autowired
    private MembershipTypeRepository membershipTypeRepository;
    @Override
    public ResponseEntity<?> deleteMembershipType(Long membershipTypeId) {
        MembershipType membershipType = membershipTypeRepository.findById(membershipTypeId)
                .orElseThrow(() -> new ResourceNotFoundException("MembershipType", "Id", membershipTypeId));
        membershipTypeRepository.delete(membershipType);
        return ResponseEntity.ok().build();
    }

    @Override
    public MembershipType updateMembershipType(Long membershipTypeId, MembershipType membershipTypeRequest) {
        MembershipType membershipType = membershipTypeRepository.findById(membershipTypeId)
                .orElseThrow(() -> new ResourceNotFoundException("MembershipType", "Id", membershipTypeId));
        membershipType.setName(membershipTypeRequest.getName());
        return membershipTypeRepository.save(membershipType);
    }

    @Override
    public MembershipType createMembershipType(MembershipType membershipType) {
        return membershipTypeRepository.save(membershipType);
    }

    @Override
    public MembershipType getMembershipTypeById(Long membershipTypeId) {
        return membershipTypeRepository.findById(membershipTypeId)
                .orElseThrow(() -> new ResourceNotFoundException("MembershipType", "Id", membershipTypeId));
    }

    @Override
    public List<MembershipType> getAllMembershipTypes() {
        return membershipTypeRepository.findAll();
    }
}
