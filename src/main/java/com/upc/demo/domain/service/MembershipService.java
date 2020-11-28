package com.upc.demo.domain.service;

import com.upc.demo.domain.model.Membership;

import org.springframework.http.ResponseEntity;

import java.util.List;

public interface MembershipService {
    List<Membership> getAllMembershipsByProviderId(Long providerId);
    Membership getMembershipByIdAndProviderId(Long providerId, Long membershipId);
    Membership createMembership(Long providerId, Membership membership);
    Membership updateMembership(Long providerId, Long membershipId, Membership membershipDetails);
    ResponseEntity<?> deleteMembership(Long providerId, Long membershipId);
}
