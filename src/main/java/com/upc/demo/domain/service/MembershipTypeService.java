package com.upc.demo.domain.service;

import com.upc.demo.domain.model.MembershipType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface MembershipTypeService {
    ResponseEntity<?> deleteMembershipType(Long membershipTypeId);
    MembershipType updateMembershipType(Long membershipTypeId, MembershipType membershipTypeRequest);
    MembershipType createMembershipType(MembershipType membershipType);
    MembershipType getMembershipTypeById(Long membershipTypeId);
    List<MembershipType> getAllMembershipTypes();
}
