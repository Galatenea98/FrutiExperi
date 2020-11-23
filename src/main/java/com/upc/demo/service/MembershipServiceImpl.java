package com.upc.demo.service;

import com.upc.demo.domain.model.Membership;
import com.upc.demo.domain.repository.MembershipRepository;
import com.upc.demo.domain.repository.ProviderRepository;
import com.upc.demo.domain.service.MembershipService;
import com.upc.demo.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class MembershipServiceImpl implements MembershipService {
    @Autowired
    private MembershipRepository membershipRepository;
    @Autowired
    private ProviderRepository providerRepository;

    @Override
    public Page<Membership> getAllMembershipsByProviderId(Long providerId, Pageable pageable) {
        return membershipRepository.findByProviderId(providerId, pageable);
    }

    @Override
    public Membership getMembershipByIdAndProviderId(Long providerId, Long membershipId) {
        return membershipRepository.findByIdAndProviderId(membershipId, providerId) .orElseThrow(() -> new ResourceNotFoundException());
    }

    @Override
    public Membership createMembership(Long providerId, Membership membership) {
        return providerRepository.findById(providerId).map(provider -> {
            //membership.setProvider(provider);
            return membershipRepository.save(membership);
        }).orElseThrow(() -> new ResourceNotFoundException(
                "Provider", "Id", providerId));
    }

    @Override
    public Membership updateMembership(Long providerId, Long membershipId, Membership membershipDetails) {
        if(!providerRepository.existsById(providerId))
            throw new ResourceNotFoundException("Provider", "Id", providerId);

        return membershipRepository.findById(membershipId).map(membership -> {
            membership.setUpdatedAt(membershipDetails.getUpdatedAt());
            return membershipRepository.save(membership);
        }).orElseThrow(() -> new ResourceNotFoundException("Membership", "Id", membershipId));
    }

    @Override
    public ResponseEntity<?> deleteMembership(Long providerId, Long membershipId) {
        return membershipRepository.findByIdAndProviderId(membershipId, providerId).map(membership -> {
            membershipRepository.delete(membership);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException(
                "Membership not found with Id " + membershipId + " and ProviderId " + providerId));
    }
}
