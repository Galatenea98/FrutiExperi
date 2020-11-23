package com.upc.demo.domain.service;

import com.upc.demo.domain.model.Membership;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public interface MembershipService {
    Page<Membership> getAllMembershipsByProviderId(Long providerId, Pageable pageable);
    Membership getMembershipByIdAndProviderId(Long providerId, Long membershipId);
    Membership createMembership(Long providerId, Membership membership);
    Membership updateMembership(Long providerId, Long membershipId, Membership membershipDetails);
    ResponseEntity<?> deleteMembership(Long providerId, Long membershipId);
}
